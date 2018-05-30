package by.sichnenko.committee.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralValidatorTest {
    @Test
    public void isLegalDatePositive() {
        String[] corrrectDate = new String[]{"2018-05-12"};
        Assert.assertTrue(GeneralValidator.isLegalDate(corrrectDate));
    }

    @Test
    public void isLegalDateNegativeArrayIsNull() {
        Assert.assertFalse(GeneralValidator.isLegalDate(null));
    }

    @Test
    public void isLegalDateNegativeDateIsNull() {
        String[] incorrectDate = new String[]{};
        Assert.assertFalse(GeneralValidator.isLegalDate(incorrectDate));
    }

    @Test
    public void isLegalDateNegativeWrongFormat() {
        String[] incorrectDate = new String[]{"12.12.2018"};
        Assert.assertFalse(GeneralValidator.isLegalDate(incorrectDate));
    }

    @Test
    public void isLegalDateNegativeDateIsEmpty() {
        String[] incorrectDate = new String[]{""};
        Assert.assertFalse(GeneralValidator.isLegalDate(incorrectDate));
    }

    @Test
    public void isLegalDateNegativeDateWithLetters() {
        String[] incorrectDate = new String[]{"12 мая 2018"};
        Assert.assertFalse(GeneralValidator.isLegalDate(incorrectDate));
    }

    @Test
    public void isLegalDateNegativeDateWithSymbols() {
        String[] incorrectDate = new String[]{"12-12&&-2017"};
        Assert.assertFalse(GeneralValidator.isLegalDate(incorrectDate));
    }

    @Test
    public void isVarExistArrayPositive() {
        String[] correct = new String[]{"value"};
        Assert.assertTrue(GeneralValidator.isVarExist(correct));
    }

    @Test
    public void isVarExistPositive() {
        String correct = "value";
        Assert.assertTrue(GeneralValidator.isVarExist(correct));
    }

    @Test
    public void isVarExistNegativeArrayIsNull() {
        String[] incorrect = new String[]{};
        Assert.assertFalse(GeneralValidator.isVarExist(incorrect));
    }

    @Test
    public void isVarExistNegativeVarIsNull() {
        Assert.assertFalse(GeneralValidator.isVarExist((String) null));
    }

    @Test
    public void isVarExistNegativeVarIsNull2() {
        Assert.assertFalse(GeneralValidator.isVarExist((String[]) null));
    }

    @Test
    public void isVarExistNegativeVarIsEmpty() {
        String[] incorrect = new String[]{"     "};
        Assert.assertFalse(GeneralValidator.isVarExist(incorrect));
    }

    @Test
    public void isVarExistNegativeVarIsEmpty2() {
        String incorrect = "    ";
        Assert.assertFalse(GeneralValidator.isVarExist(incorrect));
    }

    @Test
    public void isPositiveNumberPositive() {
        String correct = "12";
        Assert.assertTrue(GeneralValidator.isPositiveNumber(correct));
    }

    @Test
    public void isPositiveNumberPositive2() {
        String correct = "12342";
        Assert.assertTrue(GeneralValidator.isPositiveNumber(correct));
    }

    @Test
    public void isPositiveNumberNegativeVarIsNull() {
        Assert.assertFalse(GeneralValidator.isPositiveNumber((String) null));
    }

    @Test
    public void isPositiveNumberNegativeVarIsEmpty() {
        String incorrect = "  ";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isPositiveNumberNegativeVarIsZero() {
        String incorrect = "0";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isPositiveNumberNegativeVarIsNegative() {
        String incorrect = "-42";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isPositiveNumberNegativeVarHasLetter() {
        String incorrect = "42rt";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isPositiveNumberNegativeVarHasSymbols() {
        String incorrect = "42@@";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isPositiveNumberNegativeVarIsFloat() {
        String incorrect = "42.44";
        Assert.assertFalse(GeneralValidator.isPositiveNumber(incorrect));
    }

    @Test
    public void isImageExtensionValidPositiveJPG() {
        String correct = ".JPG";
        Assert.assertTrue(GeneralValidator.isImageExtensionValid(correct));
    }
    @Test
    public void isImageExtensionValidPositiveJPEG() {
        String correct = ".JPEG";
        Assert.assertTrue(GeneralValidator.isImageExtensionValid(correct));
    }

    @Test
    public void isImageExtensionValidPositivePNG() {
        String correct = ".PNG";
        Assert.assertTrue(GeneralValidator.isImageExtensionValid(correct));
    }

    @Test
    public void isImageExtensionValidNegative() {
        String incorrect = ".GIF";
        Assert.assertFalse(GeneralValidator.isImageExtensionValid(incorrect));
    }

    @Test
    public void isImageExtensionValidNegativeWitoitDot() {
        String incorrect = "PNG";
        Assert.assertFalse(GeneralValidator.isImageExtensionValid(incorrect));
    }


    @Test
    public void isImageExtensionValidNegativeWrongExtension() {
        String incorrect = "12312";
        Assert.assertFalse(GeneralValidator.isImageExtensionValid(incorrect));
    }
}
