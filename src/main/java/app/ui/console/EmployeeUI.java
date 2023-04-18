package app.ui.console;

import app.controller.EmployeeController;
import app.domain.model.*;
import app.domain.shared.Constants;
import app.domain.shared.DataValidation;
import app.ui.console.utils.Utils;

import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class EmployeeUI implements Runnable {

    private EmployeeController ctrl = new EmployeeController();
    private boolean firstRun = true;
    private AuthUI authUI = new AuthUI();
    private Address address;
    private String name;
    private String email;
    private int phoneNumber, citizenCardNumber;
    private int ID;
    private Company company = new Company(Constants.PARAMS_COMPANY_DESIGNATION);
    private DataValidation validate = new DataValidation();

    /**
     * Method that shows the employee menu and read the data from the console
     */
    public void run() {

        String role = String.valueOf(Utils.showAndSelectOne(authUI.getMenuItemForRoles(), "Please select the intended role:"));

        firstRun = false;

        boolean success = false;
        List<Employee> lista = ctrl.getEmployeeList();
        System.out.println(lista.isEmpty());

        do {

            try {

                name = enterName();

                email = enterEmail();

                address = enterAddress();

                phoneNumber = enterPhoneNumber();

                citizenCardNumber = enterCitizenCardNumber();

                ctrl.registerEmployee(role, ID, name, email, address, phoneNumber, citizenCardNumber);


            } catch (Exception IllegalArgumentException) {

                System.out.println(IllegalArgumentException.getMessage());

                System.out.println("An error has occurred, please try to registering the employee again");
            }
            success = true;

        } while (!success);


        boolean dataConfirm = confirmData();

        boolean save;

        if (dataConfirm) {
            save = ctrl.saveEmployee(name, email, role);
            if (save) {
                System.out.println("The Employee has been successfully created");

            } else {
                System.out.println("Sorry, it was not possible to save the Employee ");
            }
        } else {
            System.out.println("Employee data were not recorded.");
        }
    }


    private boolean confirmData() {
        boolean checkData = false;
        boolean result = false;
        do {
            System.out.println("Please confirm the Employee data:");
            System.out.println(ctrl.getEmployee().toString());
            String typed = Utils.readLineFromConsole("Confirmation(type: OK or NOK)");


            if (typed.equalsIgnoreCase("OK")) {
                checkData = true;
                result = true;
            } else if (typed.equalsIgnoreCase("NOK")) {
                checkData = true;
                result = false;
            } else {
                System.out.println("Please type OK or NOK");
            }
        } while (!checkData);
        return result;
    }


    private Address enterAddress() {
        boolean checkEmployeeAddress;
        do {
            try {
                String addressTyped = Utils.readLineFromConsole("Enter the address (Format: STREET,HOUSENUMBER,CITY");
                String[] addressSplit = addressTyped.split(",");
                if (addressSplit.length != 3) {
                    throw new IllegalArgumentException("Please enter the addres in format: STREET, HOUSENUMBER,CITY");
                }
                checkEmployeeAddress = true;
                address = new Address(addressSplit[0], Integer.parseInt(addressSplit[1]), addressSplit[2]);
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeeAddress = false;
            }
        } while (!checkEmployeeAddress);

        return address;

    }

    private String enterName() {
        boolean checkEmployeeName;
        do {
            try {
                name = Utils.readLineFromConsole("Enter name:");
                validate.validateName(name);
                checkEmployeeName = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeeName = false;

            }
        } while (!checkEmployeeName);

        return name;
    }

    private String enterEmail() {
        boolean checkEmployeeEmail;
        do {
            try {
                email = Utils.readLineFromConsole("Enter email:");
                validate.validateEmail(email);
                checkEmployeeEmail = true;

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeeEmail = false;
            }

        } while (!checkEmployeeEmail);
        return email;
    }

    private int enterPhoneNumber() {
        boolean checkEmployeePhoneNumber;
        do {
            try {
                phoneNumber = Utils.readIntegerFromConsole("Enter phone number:");
                validate.validatePhoneFaxNumber(phoneNumber);
                checkEmployeePhoneNumber = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeePhoneNumber = false;
            }
        } while (!checkEmployeePhoneNumber);

        return phoneNumber;
    }

    private int enterCitizenCardNumber() {
        boolean checkEmployeeCitizenCardNumber;
        do {
            try {
                citizenCardNumber = Utils.readIntegerFromConsole("Enter citizen card number:");
                validate.validateCitizenCardNumber(citizenCardNumber);
                checkEmployeeCitizenCardNumber = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkEmployeeCitizenCardNumber = false;
            }
        } while (!checkEmployeeCitizenCardNumber);

        return citizenCardNumber;
    }
}

