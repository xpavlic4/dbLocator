package com.focusmr.dblocator.client;

/**
 * Holds country code.
 */
@SuppressWarnings("unused")
public final class Country {

    private final String country;

    /**
     * Creates country.
     *
     * @param s country     string e.g. cz
     * @return country
     * @throws IllegalArgumentException if empty or null
     */
    public static Country from(String s) {
        if (null == s || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Country(s);
    }

    /**
     * Private constructor.
     *
     * @param country country definition
     */
    private Country(String country) {
        this.country = country;
    }

    /**
     * Gets country string.
     *
     * @return country string
     */
    public String getCountry() {
        return country;
    }

    /**
     * Redirects to string hash-code.
     *
     * @return hash-code
     */
    @Override
    public int hashCode() {
        return country.hashCode();
    }

    /**
     * Returns whether country fields equal.
     *
     * @param o country
     * @return the same as object
     */
    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && ((Country) o).getCountry().equals(getCountry());
    }

    /**
     * To String.
     *
     * @return country representation
     */
    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                '}';
    }
}
