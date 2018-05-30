package by.sichnenko.committee.util;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.validator.GeneralValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.*;
import java.util.Optional;

import static by.sichnenko.committee.constant.GeneralConstant.IMAGE_DIRECTORY;

public class ImageUploader {

    private static final int BUFFER_LENGTH = 1024;
    private static final Logger LOGGER = LogManager.getLogger(ImageUploader.class);

    /**
     * Allow to upload file
     *
     * @param sessionRequestContent Copy of the request
     * @param paramName             parameter of file in request
     * @param directoryName         Directory in which file will be load
     * @param fileName              Name of file
     * @return Relative path to the uploaded file or empty value if there were problems loading file
     */
    public Optional<String> loadFile(SessionRequestContent sessionRequestContent, String paramName, String directoryName, String fileName) {
        try {
            Part filePart = sessionRequestContent.getParts().get(paramName);
            String submittedfileName = extractFileName(filePart);
            String extension = defineFileExtension(submittedfileName);
            if (!GeneralValidator.isImageExtensionValid(extension)) {
                LOGGER.error("Invalid extension. File wasn't loaded: " + fileName);
                return Optional.empty();
            }
            InputStream fileContent = filePart.getInputStream();
            String relativePath = IMAGE_DIRECTORY + File.separator + directoryName + File.separator + fileName + extension;
            String filePath = sessionRequestContent.getRealPath() + relativePath;

            File newFile = new File(filePath);
            if (newFile.exists()) {
                boolean isDelete = newFile.delete();
                if (!isDelete) {
                    LOGGER.info("Error deleting file: " + fileName);
                }
            }

            boolean isExist = newFile.createNewFile();
            if (isExist) {
                copyInputStreamToFile(fileContent, newFile);
                LOGGER.info("File was successfully loaded:  " + fileName);
                return Optional.of(relativePath);
            } else {
                LOGGER.error("Error loading file: " + fileName);
                return Optional.empty();
            }

        } catch (IOException ex) {
            LOGGER.error("File wasn't loaded: " + fileName, ex);
            return Optional.empty();
        }
    }

    /**
     * Find file extension
     *
     * @param fileName Name of file
     * @return File extension
     */
    private String defineFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index);
    }

    /**
     * Find file name
     *
     * @param part Item that was received within a multipart/form-data POST request.
     * @return Name of submitted item
     */
    private String extractFileName(Part part) {
        String fileName = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }

    /**
     * Write input stream to file
     *
     * @param inputStream inputStream which will be written in file
     * @param file        File in which inputStream will be written
     * @throws IOException .
     */
    private void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[BUFFER_LENGTH];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
