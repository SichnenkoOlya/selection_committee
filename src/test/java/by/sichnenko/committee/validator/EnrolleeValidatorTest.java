package by.sichnenko.committee.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnrolleeValidatorTest {

    @Test
    public void validatePhoneNumberPositiveCorrectNumberWithPlus() {
        String corrrectPhoneNumber = "+375298496530";
        Assert.assertTrue(EnrolleeValidator.validatePhoneNumber(corrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberPositiveCorrectNumberWithoutPlus1() {
        String corrrectPhoneNumber = "375298496530";
        Assert.assertTrue(EnrolleeValidator.validatePhoneNumber(corrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberPositiveCorrectNumberWithoutPlus2() {
        String corrrectPhoneNumber = "80298496530";
        Assert.assertTrue(EnrolleeValidator.validatePhoneNumber(corrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeNumberHasFewCountDigit() {
        String incorrrectPhoneNumber = "+375298496";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeNumberHasManyCountDigit() {
        String incorrrectPhoneNumber = "+37529849653067700";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeEmptyNumber() {
        String incorrrectPhoneNumber = "";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeNumberHasLetter() {
        String incorrrectPhoneNumber = "+375298four965300";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeNumberHasSymbol() {
        String incorrrectPhoneNumber = "+3752989653%";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validatePhoneNumberNegativeNumberHasTwoPlus() {
        String incorrrectPhoneNumber = "++37529896530";
        Assert.assertFalse(EnrolleeValidator.validatePhoneNumber(incorrrectPhoneNumber));
    }

    @Test
    public void validateNamePositiveRussianName() {
        String correctName = "Вася";
        Assert.assertTrue(EnrolleeValidator.validateName(correctName));
    }

    @Test
    public void validateNamePositiveRussianNameTwoLetter() {
        String correctName = "Ия";
        Assert.assertTrue(EnrolleeValidator.validateName(correctName));
    }

    @Test
    public void validateNamePositiveEnglishName() {
        String correctName = "Olya";
        Assert.assertTrue(EnrolleeValidator.validateName(correctName));
    }

    @Test
    public void validateNamePositiveEnglishNameTwoLetter() {
        String correctName = "Xz";
        Assert.assertTrue(EnrolleeValidator.validateName(correctName));
    }

    @Test
    public void validateNameNegativeVeryLong() {
        String incorrectName = "Xzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectName));
    }

    @Test
    public void validateNameNegativeEmptyName() {
        String incorrectName = "";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectName));
    }

    @Test
    public void validateNameNegativeLittleFirstLetter() {
        String incorrectName = "olya";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectName));
    }

    @Test
    public void validateNameNegativeNameWithSymbols() {
        String incorrectName = "Olya%^ar";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectName));
    }

    @Test
    public void validatePassportPositive7Numbers() {
        String correctPassport = "KB1945674";
        Assert.assertTrue(EnrolleeValidator.validatePassportNumber(correctPassport));
    }

    @Test
    public void validatePassportPositive8Numbers() {
        String correctPassport = "KB19456741";
        Assert.assertTrue(EnrolleeValidator.validatePassportNumber(correctPassport));
    }

    @Test
    public void validatePassportNegativePassportWithLittleLetters() {
        String incorrectPassport = "gh19456741";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }


    @Test
    public void validatePassportNegativePassportWithManyLetters() {
        String incorrectPassport = "HHH19456741";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }

    @Test
    public void validatePassportNegativePassportWithManyDigits() {
        String incorrectPassport = "HH194567564541";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }

    @Test
    public void validatePassportNegativePassportWithLettersInMiddle() {
        String incorrectPassport = "HH194L4541";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }

    @Test
    public void validatePassportNegativePassportWithSymbols() {
        String incorrectPassport = "HH194L454**1";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }

    @Test
    public void validatePassportNegativeEmptyPassport() {
        String incorrectPassport = "";
        Assert.assertFalse(EnrolleeValidator.validateName(incorrectPassport));
    }

    @Test
    public void validateCertificateScorePositive() {
        int correctScore = 30;
        Assert.assertTrue(EnrolleeValidator.validateCertificateScore(correctScore));
    }

    @Test
    public void validateCertificateScorePositiveMinBorder() {
        int correctScore = 0;
        Assert.assertTrue(EnrolleeValidator.validateCertificateScore(correctScore));
    }

    @Test
    public void validateCertificateScorePositiveMaxBorder() {
        int correctScore = 100;
        Assert.assertTrue(EnrolleeValidator.validateCertificateScore(correctScore));
    }

    @Test
    public void validateCertificateScoreNegativeBiggerMaxBorder() {
        int incorrectScore = 101;
        Assert.assertFalse(EnrolleeValidator.validateCertificateScore(incorrectScore));
    }

    @Test
    public void validateCertificateScoreNegativeLessMinBorder() {
        int incorrectScore = -1;
        Assert.assertFalse(EnrolleeValidator.validateCertificateScore(incorrectScore));
    }

    @Test
    public void validateScoreOnCTPositive() {
        int countSubject = 3;
        int countScore = 270;
        Assert.assertTrue(EnrolleeValidator.validateScoreOnCT(countScore, countSubject));
    }

    @Test
    public void validateScoreOnCTPositiveMinCountSubject() {
        int countSubject = 1;
        int countScore = 99;
        Assert.assertTrue(EnrolleeValidator.validateScoreOnCT(countScore, countSubject));
    }

    @Test
    public void validateScoreOnCTPositiveMinCountSubjectAndMaxScore() {
        int countSubject = 1;
        int countScore = 100;
        Assert.assertTrue(EnrolleeValidator.validateScoreOnCT(countScore, countSubject));
    }

    @Test
    public void validateScoreOnCTNegativeWrongCountSubject() {
        int countSubject = 0;
        int countScore = 100;
        Assert.assertFalse(EnrolleeValidator.validateScoreOnCT(countScore, countSubject));
    }

    @Test
    public void validateScoreOnCTNegativeWrongCountScore() {
        int countSubject = 2;
        int countScore = 203;
        Assert.assertFalse(EnrolleeValidator.validateScoreOnCT(countScore, countSubject));
    }
}