package by.sichnenko.committee.model;

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

    public long getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(long enrolleeId) {
        this.enrolleeId = enrolleeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public int getAvarageCertificateScore() {
        return avarageCertificateScore;
    }

    public void setAvarageCertificateScore(int avarageCertificateScore) {
        this.avarageCertificateScore = avarageCertificateScore;
    }

    public int getScoreOnCT() {
        return scoreOnCT;
    }

    public void setScoreOnCT(int scoreOnCT) {
        this.scoreOnCT = scoreOnCT;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
