package by.sichnenko.committee.model;

public class Subject {
    private long subjectId;
    private String name;
    private short groupNumber;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(short groupNumber) {
        this.groupNumber = groupNumber;
    }
}
