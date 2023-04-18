package app.domain.store;

import app.domain.model.Address;
import app.domain.model.Company;
import app.domain.model.SnsUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that represents an List of all the sns user's in the system
 */
public class SnsUserStore {

    private final List<SnsUser> array;
    private SnsUser snsUser;

    /**
     * Constructor of the class it creates an empty list to be filled with objects of sns user
     */
    public SnsUserStore() {
        this.array = new ArrayList<>();
    }

    /**
     * This method creates a new sns user object by calling one of his constructor depending on if the sex is specified or not
     *  @param phoneNumber unique phone number that belongs to Sns User
     * @param snsNumber sns number of the Sns User
     * @param citizenNumber citizen card number of the Sns User
     * @param birthDate birthay date of the Sns User
     * @param email email of the Sns User
     * @param name name of the Sns User
     * @param address address of the Sns User
     * @param sex sex of the Sns User
     * @return
     */
    public void CreateSnsUser(String phoneNumber, String snsNumber, String citizenNumber, Date birthDate, String email, String name, Address address, char sex, int age) {
        if (sex == 'M' || sex == 'F') {
            this.snsUser = new SnsUser(phoneNumber, snsNumber, citizenNumber, birthDate, email, name, address, sex, age);
        } else {
            this.snsUser = new SnsUser(phoneNumber, snsNumber, citizenNumber, birthDate, email, name, address, sex, age);
        }
    }

    /**
     * Checks if a instance of object Sns User is valid. An instance of a sns user is valid if it is not null, if dont already exists or if the email and phone number of the instance are not unique
     *
     * @param snsUser instance of object Sns User
     * @return a boolean value that represents if the instance of object Sns User is valid
     */
    public boolean validateSnsUser(SnsUser snsUser) {
        return snsUser != null && !contains(snsUser) && !exists(snsUser);
    }

    /**
     * Checks if the SnsUser snsUser already exists in the system, it checks if the email or the phone number are unique
     *
     * @param snsUser instance of object Sns User
     * @return a boolean value that represents if the Sns User already exists in the system
     */
    private boolean exists(SnsUser snsUser) {
        for (SnsUser c : array) {
            return c.getEmail().equals(snsUser.getEmail()) || c.getPhoneNumber().equals(snsUser.getPhoneNumber());
        }
        return false;
    }

    /**
     * Saves the instance of object Sns User in the ArrayList, before adding the sns user it is verified if the instance of sns user is valid
     *
     * @return boolean value that represents the success of the operation
     */
    public boolean saveSnsUser() {
        if (validateSnsUser(this.snsUser)) {
            array.add(this.snsUser);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the instance of the Class sns user already exists in the ArrayList
     *
     * @param snsUser SnsUser instance that is going to be checked
     * @return boolean value that represents the success of the operation
     */
    public boolean contains(SnsUser snsUser) {
        return this.array.contains(snsUser);
    }

    /**
     * Adds user to the system by calling the SnsUser instance method
     *
     * @return boolean value that represents the success of the operation
     */
    public boolean addUser(Company company) {
        return snsUser.addUser(company);
    }

    /**
     * @return the instance of sns user
     */
    public SnsUser getSnsUser() {
        return snsUser;
    }

}