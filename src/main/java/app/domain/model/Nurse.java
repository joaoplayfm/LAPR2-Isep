package app.domain.model;

import pt.isep.lei.esoft.auth.domain.model.Email;

public class Nurse extends Employee{
    /**
     * Employee full constructor
     *
     * @param name
     * @param email
     * @param address
     * @param phoneNumber
     * @param citizenCardNumber
     */
    public Nurse(int ID, String name, String email, Address address, int phoneNumber, int citizenCardNumber) {
        super(ID,name, email, address, phoneNumber, citizenCardNumber);
    }


}
