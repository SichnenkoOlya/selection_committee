package by.sichnenko.committee.model;

import java.util.Date;
import java.util.List;

/**
 * The Faculty class
 */
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

    /**
     * Get id of the faculty
     *
     * @return id of the faculty
     */
    public long getFacultyId() {
        return facultyId;
    }

    /**
     * Set id for the faculty
     *
     * @param facultyId id of the faculty
     */
    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * Get name of the faculty
     *
     * @return name of the faculty
     */
    public String getName() {
        return name;
    }


    /**
     * Set name the faculty
     *
     * @param name name of the faculty
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get count of budjet places for the faculty
     *
     * @return count of budjet places
     */
    public int getBudjetPlaceCount() {
        return budjetPlaceCount;
    }


    /**
     * Set count of budjet places for the faculty
     *
     * @param budjetPlaceCount count of budjet places for the faculty
     */
    public void setBudjetPlaceCount(int budjetPlaceCount) {
        this.budjetPlaceCount = budjetPlaceCount;
    }

    /**
     * Get count of paid places for the faculty
     *
     * @return count of paid places
     */
    public int getPaidPlaceCount() {
        return paidPlaceCount;
    }


    /**
     * Set count of paid places for the faculty
     *
     * @param paidPlaceCount count of paid places for the faculty
     */
    public void setPaidPlaceCount(int paidPlaceCount) {
        this.paidPlaceCount = paidPlaceCount;
    }

    /**
     * Get passing score for budjet for this faculty
     *
     * @return passing score for budjet for this faculty
     */
    public short getPassingScoreBudjet() {
        return passingScoreBudjet;
    }

    /**
     * Set passing score for budjet for this faculty
     *
     * @param passingScoreBudjet passing score for budjet for this faculty
     */
    public void setPassingScoreBudjet(short passingScoreBudjet) {
        this.passingScoreBudjet = passingScoreBudjet;
    }

    /**
     * Get passing score for paid for this faculty
     *
     * @return passing score for paid for this faculty
     */
    public short getPassingScorePaid() {
        return passingScorePaid;
    }

    /**
     * Set passing score for paid for this faculty
     *
     * @param passingScorePaid passing score for paid for this faculty
     */
    public void setPassingScorePaid(short passingScorePaid) {
        this.passingScorePaid = passingScorePaid;
    }

    /**
     * Get image path for the faculty
     *
     * @return image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Set image path for the faculty
     *
     * @param imagePath image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Get description of the faculty
     *
     * @return description of the faculty
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of the faculty
     *
     * @param description description of the faculty
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get total count of places for the faculty
     *
     * @return total count paid places
     */
    public int getTotalPlaceCount() {
        return totalPlaceCount;
    }

    /**
     * Set total count of places for the faculty
     *
     * @param totalPlaceCount total count of places for the faculty
     */
    public void setTotalPlaceCount(int totalPlaceCount) {
        this.totalPlaceCount = totalPlaceCount;
    }

    /**
     * Get subjects need to enter this faculty
     *
     * @return subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Set subjects need to enter this faculty
     *
     * @param subjects subjects
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Get is finish committee for this faculty
     *
     * @return is finish committee for this faculty
     */
    public boolean getIsFinish() {
        return isFinish;
    }

    /**
     * Set is finish committee for this faculty
     *
     * @param finish is finish committee for this faculty
     */
    public void setIsFinish(boolean finish) {
        isFinish = finish;
    }

    /**
     * Get finish date od committee for this faculty
     *
     * @return finish date od committee for this faculty
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Set finish date od committee for this faculty
     *
     * @param finishDate finish date od committee for this faculty
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return facultyId == faculty.facultyId &&
                budjetPlaceCount == faculty.budjetPlaceCount &&
                paidPlaceCount == faculty.paidPlaceCount &&
                totalPlaceCount == faculty.totalPlaceCount &&
                passingScoreBudjet == faculty.passingScoreBudjet &&
                passingScorePaid == faculty.passingScorePaid &&
                isFinish == faculty.isFinish &&
                name == null ? faculty.name == null : name.equals(faculty.name) &&
                imagePath == null ? faculty.imagePath == null : imagePath.equals(faculty.imagePath) &&
                description == null ? faculty.description == null : description.equals(faculty.description) &&
                subjects == null ? faculty.subjects == null : subjects.equals(faculty.subjects) &&
                finishDate == null ? faculty.finishDate == null : finishDate.equals(faculty.finishDate);
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = prime * result + (description != null ? description.hashCode() : 0);
        result = prime * result + (subjects != null ? subjects.hashCode() : 0);
        result = prime * result + ((isFinish) ? 0 : 1);
        result = prime * result + finishDate.hashCode();
        result = prime * result + budjetPlaceCount;
        result = prime * result + (int) facultyId;
        result = prime * result + paidPlaceCount;
        result = prime * result + totalPlaceCount;
        result = prime * result + passingScoreBudjet;
        result = prime * result + passingScorePaid;
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", name='" + name + '\'' +
                ", budjetPlaceCount=" + budjetPlaceCount +
                ", paidPlaceCount=" + paidPlaceCount +
                ", totalPlaceCount=" + totalPlaceCount +
                ", passingScoreBudjet=" + passingScoreBudjet +
                ", passingScorePaid=" + passingScorePaid +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                ", subjects=" + subjects +
                ", isFinish=" + isFinish +
                ", finishDate=" + finishDate +
                '}';
    }
}
