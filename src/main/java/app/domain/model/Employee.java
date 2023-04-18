package app.domain.model;

import app.domain.store.EmployeeStore;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

import static app.domain.shared.Constants.*;

/**
 * Class that represent an employee
 */
public abstract class Employee {
    /**
     * name of the employee
     */
    private String name;

    /**
     * email of the employee
     */
    private String email;

    /**
     * address of the employee
     */
    private Address address;

    /**
     * phone number of the employee
     */
    private int phoneNumber;

    /**
     * citizen card number of the employee
     */
    private int citizenCardNumber;

    /**
     * ID of the employee
     */
    private static int ID= 00000000000 ;

    /*
=======


    /**
>>>>>>> ceaee854e2f7fb7e293a650ec18bb4b9211414cc
     * Employee empty constructor

    public Employee() {
        this.name = NAME_DEFAULT;
        this.address = ADDRESS_DEFAULT;
        this.phoneNumber = PHONE_NUMBER_DEFAULT;
        this.citizenCardNumber = CITIZEN_CARD_DEFAULT;
    }

     */


    /**
     * Employee full constructor
     *
     * @param name
     * @param email
     * @param address
     * @param phoneNumber
     * @param citizenCardNumber
     */
    public Employee(int ID, String name, String email, Address
            address, int phoneNumber, int citizenCardNumber) {
        GenerateID(ID);
        setName(name);
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setCitizenCardNumber(citizenCardNumber);

    }

    public int GenerateID(int ID) {

        ID = -(~ID);

        return ID;
    }

    /**
     * Method that returns the name of the employee
     *
     * @return return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the email of the employee
     *
     * @return return the email of the employee
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that returns the address of the employee
     *
     * @return return the address of the employee
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method that returns the phone number of the employee
     *
     * @return return the phone number of the employee
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that returns the citizen card number of the employee
     *
     * @return return the citizen card number of the employee
     */
    public int getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Method that modifies the name of the employee
     *
     * @param name new name of the employee
     */
    public void setName(String name) {

            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("The name can't be null or empty!");
            } else {
                this.name = name;
            }
    }

    /**
     * Method that modifies the email of the employee
     *
     * @param email new email of the employee
     */
    public void setEmail(String email) {

            Email email1 = new Email(email);
            this.email= email1.getEmail();
    }

    /**
     * Method that modifies the address of the employee
     * 0
     *
     * @param address new address of the employee
     */
    public void setAddress(Address address) {

            this.address = address;
    }

    /**
     * Method that modifies the phone number of the employee
     *
     * @param phoneNumber new phone number of the employee
     */
    public void setPhoneNumber(int phoneNumber) {

            if (phoneNumber < 100000000 || phoneNumber > 999999999) {
                throw new IllegalArgumentException("The phone number need to have 9 digits!");
            }
            this.phoneNumber = phoneNumber;
    }

    /**
     * Method that modifies the citixen card number of the employee
     *
     * @param citizenCardNumber new citizen card number of the employee
     */
    public void setCitizenCardNumber(int citizenCardNumber) {

            if (citizenCardNumber < 10000000 || citizenCardNumber > 99999999) {
                throw new IllegalArgumentException("The citizen card number need to have 8 digits!");
            }
            this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Method that shows the textual description of an employee
     *
     * @return returns the textual description of an employee
     */
    @Override
    public String toString() {

        return String.format("\nEmployee\nID: %d\nName: %s\nEmail: %s\nAddress: %s\nPhone Number: %d\nCitizen Card Number: %d", ID, getName(), getEmail(), getAddress(), getPhoneNumber(), getCitizenCardNumber());
    }


}
