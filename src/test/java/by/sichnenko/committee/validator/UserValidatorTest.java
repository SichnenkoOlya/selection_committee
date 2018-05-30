package by.sichnenko.committee.validator;

import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserValidatorTest {
    @Test
    public void isAdminUserIsNotAdmin() {
        User user = new User();
        user.setRole(RoleType.USER);
        Assert.assertFalse(UserValidator.isAdmin(user));
    }

    @Test
    public void isAdminUserIsAdmin() {
        User user = new User();
        user.setRole(RoleType.ADMIN);
        Assert.assertTrue(UserValidator.isAdmin(user));
    }

    @Test
    public void isAdminUserIsNull() {
        Assert.assertFalse(UserValidator.isAdmin(null));
    }

    @Test
    public void validateEmailPositive() {
        String correctEmail = "test@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailPositiveEmailWithDigits() {
        String correctEmail = "test12@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailPositiveEmailWirhUnderscore() {
        String correctEmail = "test_test@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailPositiveEmailWirhDot() {
        String correctEmail = "test.test@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailPositiveEmailWithFirstNumber() {
        String correctEmail = "1test@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailPositiveEmailWithFirstUnderscore() {
        String correctEmail = "_test@test.test";
        Assert.assertTrue(UserValidator.validateEmail(correctEmail));
    }

    @Test
    public void validateEmailNegativeWithBigLetter() {
        String incorrectEmail = "Test@test.test";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeWithSymbols() {
        String incorrectEmail = "test$%@test.test";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeWithoutDog() {
        String incorrectEmail = "testtest.test";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeWithoutDot() {
        String incorrectEmail = "testtest";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeEmpty() {
        String incorrectEmail = "";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeBigLastPart() {
        String incorrectEmail = "test@test.testttt";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateEmailNegativeShortLastPart() {
        String incorrectEmail = "test@test.t";
        Assert.assertFalse(UserValidator.validateEmail(incorrectEmail));
    }

    @Test
    public void validateLoginPositive() {
        String correctLogin = "olay";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveThreeLetter() {
        String correctLogin = "ol1";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveWithBigLetters() {
        String correctLogin = "OlAySi";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveWithDot() {
        String correctLogin = "ol.ay";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveWithUnderscore() {
        String correctLogin = "ol_ay";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveWithDash() {
        String correctLogin = "ol-ay";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginPositiveWithNumbers() {
        String correctLogin = "olay11";
        Assert.assertTrue(UserValidator.validateLogin(correctLogin));
    }

    @Test
    public void validateLoginNegativeVeryLong() {
        String incorrectLogin = "Xzzzzzzzzzzzzzsthtrhrthrthrhrthrthtrzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeVeryShort() {
        String incorrectLogin = "z";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeEmptyLogin() {
        String incorrectLogin = "";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeLastDot() {
        String incorrectLogin = "olay.";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeLastUnderscore() {
        String incorrectLogin = "olay_";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeLastDash() {
        String incorrectLogin = "olay-";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validateLoginNegativeLoginWithSymbols() {
        String incorrectLogin = "Olya%^ar";
        Assert.assertFalse(UserValidator.validateLogin(incorrectLogin));
    }

    @Test
    public void validatePasswordPositive() {
        String correctPassword = "rty456RTY$%^";
        Assert.assertTrue(UserValidator.validatePassword(correctPassword));
    }

    @Test
    public void validatePasswordNegativePasswordIsShort() {
        String incorrectPassword = "r6Y$";
        Assert.assertFalse(UserValidator.validatePassword(incorrectPassword));
    }

    @Test
    public void validatePasswordNegativePasswordWitoutSymbols() {
        String incorrectPassword = "rtyRTY122";
        Assert.assertFalse(UserValidator.validatePassword(incorrectPassword));
    }

    @Test
    public void validatePasswordNegativePasswordWithoutNumbers() {
        String incorrectPassword = "rtyRTY";
        Assert.assertFalse(UserValidator.validatePassword(incorrectPassword));
    }

    @Test
    public void validatePasswordNegativePasswordWithoutSmallLetters() {
        String incorrectPassword = "RRRRRRR434^^";
        Assert.assertFalse(UserValidator.validatePassword(incorrectPassword));
    }

    @Test
    public void validatePasswordNegativePasswordWithoutBigLetters() {
        String incorrectPassword = "wergewr542354^^";
        Assert.assertFalse(UserValidator.validatePassword(incorrectPassword));
    }
}
