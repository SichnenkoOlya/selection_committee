package by.sichnenko.committee.model;

/**
 * The User class
 */
public class User {
    private long userId;
    private String login;
    private String hashPassword;
    private RoleType role;
    private String email;
    private boolean isBlocked;
    private String imagePath;

    /**
     * Get id of the user
     *
     * @return id of the user
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Set id for the user
     *
     * @param userId id of the user
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Get email of the user
     *
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email for the user
     *
     * @param email email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get role of the user
     *
     * @return role of the user
     * @see RoleType
     */
    public RoleType getRole() {
        return role;
    }

    /**
     * Set role for the user
     *
     * @param role role of the user
     * @see RoleType
     */
    public void setRole(RoleType role) {
        this.role = role;
    }

    /**
     * Get hash of the password of the user
     *
     * @return hash of the password
     */
    public String getHashPassword() {
        return hashPassword;
    }

    /**
     * Set hash of the password of the user
     *
     * @param hashPassword hash of the password of the user
     */
    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    /**
     * Get login of the user
     *
     * @return login of the user
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set login for the user
     *
     * @param login login of the user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get is this user blocked or not
     *
     * @return true if this user is blocked else false
     */
    public boolean getIsBlocked() {
        return isBlocked;
    }

    /**
     * Set is this user blocked or not
     *
     * @param blocked is this user blocked or not
     */
    public void setIsBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    /**
     * Get path of image of the user
     *
     * @return path of image of the user
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Set path of image for the user
     *
     * @param imagePath path of image of the user
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
                isBlocked == user.isBlocked &&
                login == null ? user.login == null : login.equals(user.login) &&
                hashPassword == null ? user.hashPassword == null : hashPassword.equals(user.hashPassword) &&
                email == null ? user.email == null : email.equals(user.email) &&
                imagePath == null ? user.imagePath == null : imagePath.equals(user.imagePath) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + login.hashCode();
        result = prime * result + hashPassword.hashCode();
        result = prime * result + email.hashCode();
        result = prime * result + imagePath.hashCode();
        result = prime * result + (int) userId;
        result = prime * result + ((isBlocked) ? 0 : 1);
        result = prime * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", isBlocked=" + isBlocked +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
