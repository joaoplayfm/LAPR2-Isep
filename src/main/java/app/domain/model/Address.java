package app.domain.model;

public class Address {
    private String street;
    private int houseNumber;
    private String city;

    /**
     * It represents the address data
     * @param street
     * @param number
     * @param city
     */

    public Address(String street, int number, String city ){
        setStreet(street);
        setHouseNumber(number);
        setCity(city);
    }

    /**
     * method to change and validate the street
     * If the street is null throws an exception
     * @param street
     */
    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid street name");
        }
        this.street = street;
    }

    /**
     * Method to change and validate the house number
     * If the house number is less than 1 or bigger than 9999 throws an exception
     * @param houseNumber
     */

    public void setHouseNumber(int houseNumber) {
        if (houseNumber< 1 || houseNumber > 9999) {
            throw new IllegalArgumentException("Invalid house number");
        }
        this.houseNumber = houseNumber;
    }


    /**
     * Method to change and validate city
     * If the city is null throws an exception
     * @param city
     */
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid city address");
        }
        this.city = city;
    }

    /**
     * Obtains in text format the address information
     * @return Textual and visible representation of address
     */

    public String toString () {
        return String.format("%s, %d, %s", street, houseNumber, city);
    }
}
