package by.sichnenko.committee.model;

/**
 * The Country class
 */
public class Country {
    private long countryId;
    private String name;

    /**
     * Get country's id
     *
     * @return country id
     */
    public long getCountryId() {
        return countryId;
    }

    /**
     * Set id for the country
     *
     * @param countryId country id
     */
    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    /**
     * Get county name
     *
     * @return country name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for the country
     *
     * @param name country's name
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
        Country country = (Country) o;
        return countryId == country.countryId &&
                (name == null ? country.getName() == null : name.equals(country.getName()));
    }

    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + name.hashCode();
        result = prime * result + (int) countryId;
        return result;
    }


    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
