package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.util.ImageUploader;
import by.sichnenko.committee.validator.GeneralValidator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.sichnenko.committee.constant.GeneralConstant.DIRECTORY_FACULTY;
import static by.sichnenko.committee.constant.RequestNameConstant.IMAGE;

/**
 * The FacultyServiceImpl class. Implementation of interface FacultyService.
 *
 * @see FacultyService
 * @see Faculty
 */
public class FacultyServiceImpl implements FacultyService {

    @Override
    public List<Faculty> findAllFaculties() throws ServiceException {
        try {
            FacultyDAO facultyDAO = new FacultyDAOImpl();
            return facultyDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find faculties error ", e);
        }
    }

    @Override
    public List<Faculty> findAllAvaliableFaculties() throws ServiceException {
        try {
            FacultyDAO facultyDAO = new FacultyDAOImpl();
            return facultyDAO.findAllAvaliableFaculties();
        } catch (DAOException e) {
            throw new ServiceException("Find faculties error ", e);
        }
    }

    @Override
    public Faculty findFacultyById(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_ID);
        if (GeneralValidator.isVarExist(facultyId) && GeneralValidator.isPositiveNumber(facultyId)) {
            try {
                FacultyDAO facultyDAO = new FacultyDAOImpl();
                SubjectDAO subjectDAO = new SubjectDAOImpl();
                Faculty faculty = facultyDAO.findFacultyById(Long.valueOf(facultyId[0]));
                faculty.setSubjects(subjectDAO.findSubjetsForFaculty(Long.valueOf(facultyId[0])));
                return faculty;
            } catch (DAOException e) {
                throw new ServiceException("Find faculty error ", e);
            }
        } else {
            throw new ServiceException("Incorrect data ");
        }
    }

    @Override
    public void addFaculty(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_NAME);
        String[] description = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_DESCRIPTION);
        String[] paidCount = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PAID_COUNT);
        String[] budjetCount = sessionRequestContent.getRequestParameters().get(RequestNameConstant.BUDJET_COUNT);
        String[] subjects = sessionRequestContent.getRequestParameters().get(RequestNameConstant.SUBJECT_ID);
        String[] finishDate = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FINISH_DATE);

        if (GeneralValidator.isVarExist(facultyName) && GeneralValidator.isVarExist(description) &&
                GeneralValidator.isPositiveNumber(paidCount) &&
                GeneralValidator.isPositiveNumber(budjetCount) &&
                GeneralValidator.isLegalDate(finishDate) &&
                subjects != null) {
            try {
                FacultyDAO facultyDAO = new FacultyDAOImpl();
                Faculty findFacultyWithSuchName = facultyDAO.findFacultyByName(facultyName[0]);
                if (findFacultyWithSuchName != null) {
                    sessionRequestContent.getRequestAttributes().put(GeneralConstant.FACULTY_EXIST, true);
                    throw new ServiceException("Faculty with such name already exist ");
                }
                SubjectDAO subjectDAO = new SubjectDAOImpl();
                Faculty faculty = new Faculty();
                faculty.setName(facultyName[0]);
                faculty.setDescription(description[0]);
                faculty.setPaidPlaceCount(Integer.valueOf(paidCount[0]));
                faculty.setBudjetPlaceCount(Integer.valueOf(budjetCount[0]));
                faculty.setFinishDate(Date.valueOf(finishDate[0]));
                facultyDAO.create(faculty);
                Faculty findFaculty = facultyDAO.findFacultyByName(facultyName[0]);
                List<Long> subjectsId = new ArrayList<>();
                for (String subjetcId : subjects) {
                    subjectsId.add(Long.valueOf(subjetcId));
                }
                subjectDAO.addSubjectsForFaculty(findFaculty.getFacultyId(), subjectsId);
            } catch (DAOException e) {
                throw new ServiceException("Add faculty error", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }


    @Override
    public void loadImage(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_ID);
        if (GeneralValidator.isPositiveNumber(facultyId)) {
            ImageUploader fileUploader = new ImageUploader();
            Optional<String> filePath = fileUploader.loadFile(sessionRequestContent, IMAGE, DIRECTORY_FACULTY, facultyId[0]);
            if (filePath.isPresent()) {
                FacultyDAO facultyDAO = new FacultyDAOImpl();
                try {
                    facultyDAO.updateImage(Long.valueOf(facultyId[0]), filePath.get());
                } catch (DAOException e) {
                    throw new ServiceException("Image load error ", e);
                }
            } else {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.IMAGE_NOT_LOADED, true);
                throw new ServiceException("Image not loaded for faculty ");
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }
}
