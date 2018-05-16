package by.sichnenko.committee.model;

import java.util.Date;
import java.util.List;

public class Faculty {
    private long facultyId;
    private String name;
    private int budjetPlaceCount;
    private int paidPlaceCount;
    private int totalPlaceCount;
    private short passingScoreBudjet;
    private short passingScorePaid;
    private String imagePath;
    private String description;
    private List<Subject> subjects;
    private boolean isFinish;
    private Date finishDate;

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudjetPlaceCount() {
        return budjetPlaceCount;
    }

    public void setBudjetPlaceCount(int budjetPlaceCount) {
        this.budjetPlaceCount = budjetPlaceCount;
    }

    public int getPaidPlaceCount() {
        return paidPlaceCount;
    }

    public void setPaidPlaceCount(int paidPlaceCount) {
        this.paidPlaceCount = paidPlaceCount;
    }

    public short getPassingScoreBudjet() {
        return passingScoreBudjet;
    }

    public void setPassingScoreBudjet(short passingScoreBudjet) {
        this.passingScoreBudjet = passingScoreBudjet;
    }

    public short getPassingScorePaid() {
        return passingScorePaid;
    }

    public void setPassingScorePaid(short passingScorePaid) {
        this.passingScorePaid = passingScorePaid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalPlaceCount() {
        return totalPlaceCount;
    }

    public void setTotalPlaceCount(int totalPlaceCount) {
        this.totalPlaceCount = totalPlaceCount;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean finish) {
        isFinish = finish;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
