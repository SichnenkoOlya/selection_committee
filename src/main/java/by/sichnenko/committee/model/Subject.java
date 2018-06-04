package by.sichnenko.committee.model;

/**
 * The Subject class
 */
public class Subject {
    private long subjectId;
    private String name;
    private short groupNumber;

    /**
     * Get id of the subject
     *
     * @return id of the subject
     */
    public long getSubjectId() {
        return subjectId;
    }


    /**
     * Set id for the subject
     *
     * @param subjectId id of the subject
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Get name of the subject
     *
     * @return name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for the subject
     *
     * @param name name of the subject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get group number of the subject
     * For example, russian and belarussian are in the one group,
     * because pupil must pass the exam(CT) in only one of this subjects
     *
     * @return group number of the subject
     */
    public short getGroupNumber() {
        return groupNumber;
    }

    /**
     * Set group number of the subject
     *
     * @param groupNumber group number of the subject
     */
    public void setGroupNumber(short groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId &&
                groupNumber == subject.groupNumber &&
                name == null ? subject.name == null : name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (int) subjectId;
        result = prime * result + (int) groupNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }
}
