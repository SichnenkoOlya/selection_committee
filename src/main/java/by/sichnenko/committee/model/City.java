package by.sichnenko.committee.model;

/**
 * The City class
 */
public class City {
    private long cityId;
    private long countryId;
    private String name;

    /**
     * Get the id of the city
     *
     * @return id of the city
     */
    public long getCityId() {
        return cityId;
    }

    /**
     * Set the city's id
     *
     * @param cityId id of the city
     */
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    /**
     * Get the country's id
     *
     * @return country id
     */
    public long getCountryId() {
        return countryId;
    }

    /**
     * Set the country's id
     *
     * @param countryId id of the country
     */
    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    /**
     * Get the city's name
     *
     * @return name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the city
     *
     * @param name name of the city
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        int result = 7;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (int) cityId;
        result = prime * result + (int) countryId;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        City city = (City) object;
        return (name == null ? city.getName() == null : name.equals(city.getName()))
                && cityId == city.getCityId() && countryId == city.getCountryId();
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
