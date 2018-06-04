package by.sichnenko.committee.model;

/**
 * The Status class
 */
public class Status {
    private long statusId;
    private String name;

    /**
     * Get id of the status
     *
     * @return id of the status
     */
    public long getStatusId() {
        return statusId;
    }


    /**
     * Set id for the status
     *
     * @param statusId id of the status
     */
    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    /**
     * Get name of the status
     *
     * @return name of the status
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for the status
     *
     * @param name name of the status
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Status status = (Status) o;
        return statusId == status.statusId &&
                name == null ? status.name == null : name.equals(status.name);
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (int) statusId;
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", name='" + name + '\'' +
                '}';
    }
}
