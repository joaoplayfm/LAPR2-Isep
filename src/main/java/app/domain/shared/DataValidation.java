package app.domain.shared;


public class DataValidation {

    /**
     * Methot that validates a name
     * if the name is null or shorter than 5 chars throws an exception
     * @param name
     */
    public void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException("Invalid name, it cannot be shorter than 5 chars");
        }
    }

    /**
     * Method that validates a  phone/fax number
     * if the phone number is not 9 digits, an exception is thrown
     * @param phoneNumber
     */

    public void validatePhoneFaxNumber(int phoneNumber) {
        if (phoneNumber < 100000000 || phoneNumber > 999999999) {
            throw new IllegalArgumentException("Invalid phone number,  it needs to be 9 digits number");
        }
    }

    public void validateEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }



    /**
     * Method that validates a website
     * if website is null or doesn't contain "www." or "." , an exception is thrown
     * @param website
     */

    public void validateWebsite(String website) {
        if (website == null || website.trim().isEmpty() || !website.contains("www.") || !website.contains(".")) {
            throw new IllegalArgumentException("Invalid website address");
        }

    }

    /**
     * Method that validates the slot duration (vaccine administration process)
     * if the slot duration is less than 1 and longer than 60 an exception is thrown
     * @param slotDuration
     */

    public void validateSlotDuration(int slotDuration) {
        if (slotDuration< 1) {
            throw new IllegalArgumentException("Invalid slot duration, it cannot be less than 1");
        }
    }

    /**
     * Method that  validates the maximum vaccines per slot (vaccine administration process)
     *  if the slot duration is less than 1 and longer than 1000 an exception is thrown
     * @param maximumVaccinesPerSlot
     */


    public void validateMaximumVaccinesPerSlot(int maximumVaccinesPerSlot) {
        if (maximumVaccinesPerSlot < 1) {
            throw new IllegalArgumentException("Invalid maximum vaccines per slot, it cannot be  less than 1");
        }

    }


    public void validateCitizenCardNumber(int citizenCardNumber) {
        if (citizenCardNumber < 10000000 || citizenCardNumber > 99999999) {
            throw new IllegalArgumentException("The citizen card number need to have 8 digits!");
        }
    }
}
