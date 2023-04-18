package app.controller;

import app.domain.model.Address;
import app.domain.model.Company;
import app.domain.model.GeneratePassword;
import app.domain.store.SnsUserStore;

import java.util.Date;

/**
 * Controller of the UserStory : Register a new SnsUser
 */
public class SnsUserController {

    private Company company;
    private SnsUserStore store;

    /**
     * Constructor of the class, gets an instance of the company class
     */
    public SnsUserController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of the class, receives an instance of the company class
     *
     * @param company instance of Company
     */
    public SnsUserController(Company company) {
        this.company = company;
        store = company.getSnsUserList();

    }

    /**
     * Creates a new Sns User instance, firstly creates a instance of SnsUserStore and then call the method of this instance that creates the SnsUser instance
     *
     * @param phoneNumber unique phone number that belongs to Sns User
     * @param snsNumber sns number of the Sns User
     * @param citizenNumber citizen card number of the Sns User
     * @param birthDate birthay date of the Sns User
     * @param email email of the Sns User
     * @param name name of the Sns User
     * @param address address of the Sns User
     * @param sex sex of the Sns User
     */
    public void createSnsUser(String phoneNumber, String snsNumber, String citizenNumber, Date birthDate, String email, String name, Address address, char sex, int  age) {
        store.CreateSnsUser(phoneNumber, snsNumber, citizenNumber, birthDate, email, name, address, sex, age);
    }

    /**
     * @return String that represents the SnsUser instance
     */
    public String getSnsUser() {
        return store.getSnsUser().toString();
    }

    /**
     * Calls the method of the instance of SnsUserStore that saves the SnsUser instance in the ArrayList, after saving Calls the method of the instance of SnsUserStore that adds an new user to the system
     *
     * @return success of the operation
     */
/*    public boolean saveSnsUser() {
        boolean saved = false;
        saved = store.saveSnsUser();
        store.addUser(this.company);
        return saved;
    }*/
    public boolean saveSnsUser(String role, String name,String email) {

        String password = GeneratePassword.getPassword();
        System.out.println("Password:"+password);

        if (company.getSnsUserList().saveSnsUser()) {
            return company.getAuthFacade().addUserWithRole(name, email, password,role);
        }
        return false;
    }










































}
