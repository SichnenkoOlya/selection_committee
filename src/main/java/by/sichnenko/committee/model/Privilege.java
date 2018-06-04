package by.sichnenko.committee.model;

/**
 * The Privilege class
 */
public class Privilege {
    private long privilegeId;
    private String name;

    /**
     * Get id of the privilege
     *
     * @return id of the privilege
     */
    public long getPrivilegeId() {
        return privilegeId;
    }

    /**
     * Set id for the privilege
     *
     * @param privilegeId id of the privilege
     */
    public void setPrivilegeId(long privilegeId) {
        this.privilegeId = privilegeId;
    }

    /**
     * Get name of the privilege
     *
     * @return name of the privilege
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for the privilege
     *
     * @param name name of the privilege
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
        Privilege privilege = (Privilege) o;
        return privilegeId == privilege.privilegeId &&
                name == null ? privilege.name == null : name.equals(privilege.name);
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (int) privilegeId;
        return result;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId=" + privilegeId +
                ", name='" + name + '\'' +
                '}';
    }
}
