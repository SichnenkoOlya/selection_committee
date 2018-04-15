package by.sichnenko.committee.model;

import java.util.Objects;

public class User {
    private long userId;
    private String login;
    private String hashPassword;
    private RoleType role;
    private String email;
    private boolean isLocked;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(login, user.login) &&
                Objects.equals(hashPassword, user.hashPassword) &&
                role == user.role &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, login, hashPassword, role, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }

}
