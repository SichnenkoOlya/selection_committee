package by.sichnenko.committee.model;

/**
 * The Enrollee class
 */
public class Enrollee {
    private long enrolleeId;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private String passport;
    private long facultyId;
    private long statusId;
    private long userId;
    private long cityId;
    private int avarageCertificateScore;
    private int scoreOnCT;
    private String infoMessage;

    /**
     * Get enrollee's id
     *
     * @return id of enrollee
     */
    public long getEnrolleeId() {
        return enrolleeId;
    }

    /**
     * Set id for enrollee
     *
     * @param enrolleeId id of enrollee
     */
    public void setEnrolleeId(long enrolleeId) {
        this.enrolleeId = enrolleeId;
    }

    /**
     * Get name of enrollee
     *
     * @return name of enrollee
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for enrollee
     *
     * @param name name of enrollee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get surname of enrollee
     *
     * @return surname of enrollee
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set surname for enrollee
     *
     * @param surname surname of enrollee
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get patronymic of enrollee
     *
     * @return patronymic of enrollee
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Set patronymic for enrollee
     *
     * @param patronymic patronymic of enrollee
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Get phone number of enrollee
     *
     * @return phone number of enrollee
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number for enrollee
     *
     * @param phoneNumber phone number of enrollee
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get faculty id in which enrollee want to enroll
     *
     * @return faculty id
     */
    public long getFacultyId() {
        return facultyId;
    }

    /**
     * Set faculty id  for enrollee
     *
     * @param facultyId faculty id
     */
    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * Get status id of enrollee
     *
     * @return status id  of enrollee
     */
    public long getStatusId() {
        return statusId;
    }

    /**
     * Set status id  for enrollee
     *
     * @param statusId status id  of enrollee
     */
    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    /**
     * Get user id of enrollee
     *
     * @return user id of enrollee
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Set user id for enrollee
     *
     * @param userId user id of enrollee
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Get city id of enrollee
     *
     * @return city id of enrollee
     */
    public long getCityId() {
        return cityId;
    }

    /**
     * Set city id for enrollee
     *
     * @param cityId city id of enrollee
     */
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    /**
     * Get avarage certificate score of enrollee
     *
     * @return avarage certificate score of enrollee
     */
    public int getAvarageCertificateScore() {
        return avarageCertificateScore;
    }

    /**
     * Set avarage certificate score for enrollee
     *
     * @param avarageCertificateScore avarage certificate score of enrollee
     */
    public void setAvarageCertificateScore(int avarageCertificateScore) {
        this.avarageCertificateScore = avarageCertificateScore;
    }

    /**
     * Get sum of score of all subjects on ct of enrollee
     *
     * @return sum of score of all subjects on ct of enrollee
     */
    public int getScoreOnCT() {
        return scoreOnCT;
    }

    /**
     * Set sum of score of all subjects on ct for enrollee
     *
     * @param scoreOnCT patronymic of enrollee
     */
    public void setScoreOnCT(int scoreOnCT) {
        this.scoreOnCT = scoreOnCT;
    }

    /**
     * Get number of passport of enrollee
     *
     * @return number of passport of enrollee
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Set number of passport for enrollee
     *
     * @param passport number of passport of enrollee
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Get info message for enrollee
     *
     * @return info message for enrollee
     */
    public String getInfoMessage() {
        return infoMessage;
    }

    /**
     * Set info message for enrollee
     *
     * @param infoMessage info message for enrollee
     */
    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Enrollee enrollee = (Enrollee) o;
        return enrolleeId == enrollee.enrolleeId &&
                facultyId == enrollee.facultyId &&
                statusId == enrollee.statusId &&
                userId == enrollee.userId &&
                cityId == enrollee.cityId &&
                avarageCertificateScore == enrollee.avarageCertificateScore &&
                scoreOnCT == enrollee.scoreOnCT &&
                name == null ? enrollee.name == null : name.equals(enrollee.name) &&
                surname == null ? enrollee.surname == null : surname.equals(enrollee.surname) &&
                patronymic == null ? enrollee.patronymic == null : patronymic.equals(enrollee.patronymic) &&
                phoneNumber == null ? enrollee.phoneNumber == null : phoneNumber.equals(enrollee.phoneNumber) &&
                passport == null ? enrollee.passport == null : passport.equals(enrollee.passport) &&
                infoMessage == null ? enrollee.infoMessage == null : infoMessage.equals(enrollee.infoMessage);
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (surname != null ? surname.hashCode() : 0);
        result = prime * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = prime * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = prime * result + (passport != null ? passport.hashCode() : 0);
        result = prime * result + (infoMessage != null ? infoMessage.hashCode() : 0);
        result = prime * result + (int) enrolleeId;
        result = prime * result + (int) facultyId;
        result = prime * result + (int) statusId;
        result = prime * result + (int) userId;
        result = prime * result + (int) cityId;
        result = prime * result + avarageCertificateScore;
        result = prime * result + scoreOnCT;
        return result;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "enrolleeId=" + enrolleeId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport + '\'' +
                ", facultyId=" + facultyId +
                ", statusId=" + statusId +
                ", userId=" + userId +
                ", cityId=" + cityId +
                ", avarageCertificateScore=" + avarageCertificateScore +
                ", scoreOnCT=" + scoreOnCT +
                ", infoMessage='" + infoMessage + '\'' +
                '}';
    }
}
