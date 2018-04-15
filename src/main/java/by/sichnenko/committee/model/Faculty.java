package by.sichnenko.committee.model;

public class Faculty {
    private long facultyId;
    private String name;
    private int budjetPlaceCount;
    private int paidPlaceCount;
    private short passingScoreBudjet;
    private short passingScorePaid;

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
}
