package by.sichnenko.committee.validator;

import by.sichnenko.committee.type.ImageExtensionType;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import static by.sichnenko.committee.constant.PatternConstant.DATE_REGEX;

public class GeneralValidator {
    /**
     * Validate that string is not empty or null
     *
     * @param stringVar checked string
     * @return true if string is not null or empty, else return false
     */
    public static boolean isVarExist(String[] stringVar) {
        return stringVar != null && stringVar[0] != null &&
                !stringVar[0].trim().isEmpty();
    }

    /**
     * Validate that string is not empty or null
     *
     * @param stringVar checked string
     * @return true if string is not null or empty, else return false
     */
    public static boolean isVarExist(String stringVar) {
        return stringVar != null && !stringVar.trim().isEmpty();
    }

    /**
     * Validate that string is positive number
     *
     * @param stringVar checked string
     * @return true if string is positive number, else return false
     */
    public static boolean isPositiveNumber(String stringVar) {
        boolean isPositiveNumber;
        try {
            if (stringVar != null) {
                int number = Integer.parseInt(stringVar);
                isPositiveNumber = number > 0;
            } else {
                isPositiveNumber = false;
            }

        } catch (NumberFormatException e) {
            isPositiveNumber = false;
        }
        return isPositiveNumber;
    }

    public static boolean isPositiveNumber(String stringVar[]) {
        return isVarExist(stringVar) && isPositiveNumber(stringVar[0]);
    }

    /**
     * Validate that string is valid image extension
     *
     * @param extension extension
     * @return true if string is valid image extension, else return false
     * @see ImageExtensionType
     */
    public static boolean isImageExtensionValid(String extension) {
        boolean isValid = true;

        if (extension != null) {
            try {
                ImageExtensionType.valueOf(extension.toUpperCase());

            } catch (IllegalArgumentException e) {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isLegalDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_REGEX);
        sdf.setLenient(false);
        return sdf.parse(date, new ParsePosition(0)) != null;
    }

    public static boolean isLegalDate(String[] date) {
        return isVarExist(date) && isLegalDate(date[0]);
    }

}
