package by.sichnenko.committee.validator;

public class GeneralValidator {

    public static boolean isVarExist(String[] stringVar) {
        return stringVar != null && stringVar[0] != null &&
                !stringVar[0].trim().isEmpty();
    }

}
