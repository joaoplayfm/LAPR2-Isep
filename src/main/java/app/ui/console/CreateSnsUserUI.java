package app.ui.console;

import app.controller.SnsUserController;

import app.domain.model.Address;
import app.domain.model.SnsUser;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateSnsUserUI implements Runnable{
    private SnsUserController ctrl;
    private SnsUserController controller;
    private final List<String> sexes;
    Date birthDate;
    String phoneNumber, snsNumber, citizenNumber,  email, name;
    Address address;
    char sex;
    private final SnsUser snsUser = new SnsUser();
    private AuthUI authUI = new AuthUI();
    private boolean firstRun = true;

    public CreateSnsUserUI() {
        this.ctrl = new SnsUserController();
        this.sexes = new ArrayList<>();
        this.controller = new SnsUserController();
    }

    @Override
    public void run() {

        String role = String.valueOf(Utils.showAndSelectOne(authUI.getMenuItemForRoles(), "Please select the intended role:"));

        firstRun = false;

        boolean success = false;

        sexes.add("Male");
        sexes.add("Female");
        sexes.add("Other");
        boolean cont;
        do {

            try {

                address = enterAddress();
                name = enterName();
                email = enterEmail();
                phoneNumber = enterPhoneNumber();
                citizenNumber = enterCitizenNumber();
                snsNumber = enterSnsNumber();
                birthDate = enterBirthDate();
                int sexIndex = Utils.showAndSelectIndex(sexes, "Please choose your sex\n");
                sex = ' ';
                if (sexIndex == 0) {
                    sex = 'M';
                } else if (sexIndex == 1) {
                    sex = 'S';
                }
                controller.createSnsUser(phoneNumber, snsNumber, citizenNumber, birthDate, email, name, address, sex, snsUser.getAge());

            } catch (Exception IllegalArgumentException) {

                System.out.println(IllegalArgumentException.getMessage());

                System.out.println("An error has occurred, please try to registering the employee again");
            }
            success = true;

        } while (!success);


        boolean save;

        save = ctrl.saveSnsUser(role, name, email);
        if (save) {

            // authFacade.doLogin(email,password);
            System.out.println("The Sns User has been successfully created");
        } else {
            System.out.println("Sorry, it was not possible to save the Sns User ");
        }
        cont = Utils.confirm("The following Sns User was created do you want to save? \n (s/n)? \n" + ctrl.getSnsUser());

        if (cont) {


            System.out.println("The sns user was saved with succsess");
        }
    }

    private Address enterAddress(){
        boolean checkEmployeeAddress;
        do{
            try {
                String addressTyped = Utils.readLineFromConsole("Enter the address (Format: STREET,HOUSENUMBER,CITY");
                String[] addressSplit = addressTyped.split(",");
                if (addressSplit.length != 3) {
                    throw new IllegalArgumentException("Please enter the addres in format: STREET, HOUSENUMBER,CITY");
                }
                checkEmployeeAddress=true;
                address = new Address(addressSplit[0], Integer.parseInt(addressSplit[1]), addressSplit[2]);
                snsUser.setAddress(address);
            }catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeeAddress=false;
            }
        }while (!checkEmployeeAddress);

        return address;
    }

    private String enterName (){
        boolean checkSnsUserName;
        do {
            try {
                name = Utils.readLineFromConsole("Enter name:");
                snsUser.setName(name);
                checkSnsUserName=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserName=false;

            }
        }while(!checkSnsUserName);

        return name;
    }

    private String enterEmail() {
        boolean checkSnsUserEmail;
        do {
            try {
                email = Utils.readLineFromConsole("Enter email:");
                snsUser.setEmail(email);
                checkSnsUserEmail = true;

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserEmail = false;
            }

        } while (!checkSnsUserEmail);
        return email;
    }

    private String enterPhoneNumber(){
        boolean checkSnsUserPhoneNumber;
        do {
            try {
                phoneNumber = String.valueOf(Utils.readIntegerFromConsole("Enter phone number(9 digits):"));
                snsUser.setPhoneNumber(Integer.parseInt(phoneNumber));
                checkSnsUserPhoneNumber=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserPhoneNumber = false;
            }
        }while (!checkSnsUserPhoneNumber);

        return phoneNumber;
    }

    private String enterCitizenNumber(){
        boolean checkSnsUserCitizenCardNumber;
        do {
            try {
                citizenNumber = String.valueOf(Utils.readIntegerFromConsole("Enter citizen card number(8 digits):"));
                snsUser.setCitizenNumber(Integer.parseInt(citizenNumber));
                checkSnsUserCitizenCardNumber=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserCitizenCardNumber= false;
            }
        }while (!checkSnsUserCitizenCardNumber);

        return citizenNumber;
    }

    private String enterSnsNumber(){
        boolean checkSnsUserSnsNumber;
        do {
            try {
                snsNumber = String.valueOf(Utils.readIntegerFromConsole("Enter sns number number(9 digits):"));
                snsUser.setSnsNumber(Integer.parseInt(snsNumber));
                checkSnsUserSnsNumber=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserSnsNumber= false;
            }
        }while (!checkSnsUserSnsNumber);

        return snsNumber;
    }

    private Date enterBirthDate(){
        boolean checkSnsUserBirthDate;
        do {
            try {
                birthDate = Utils.readDateFromConsole("Enter bith date(dd-mm-yyyy):");
                snsUser.setBirthDate(birthDate, snsUser.setAge(birthDate));
                checkSnsUserBirthDate=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSnsUserBirthDate= false;
            }
        }while (!checkSnsUserBirthDate);

        return birthDate;
    }

    }

