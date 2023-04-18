package app.ui.console;

import app.controller.RegisterVaccinationCenterController;
import app.domain.model.*;
import app.domain.shared.DataValidation;
import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import static app.domain.shared.Constants.COORDINATOR_DEFAULT;
import static app.domain.shared.Constants.VACCINE_TYPE_DEFAULT;

public class RegisterVaccinationCenterUI implements Runnable {

    private RegisterVaccinationCenterController vcController = new RegisterVaccinationCenterController();
    private boolean firstRun = true;
    private String name, email, website;
    private Address address;
    private int phoneNumber, faxNumber, slotDuration, maximumVaccinesPerSlot, vcTypeID;
    private WorkingHour openingHour, closingHour;
    private Employee coordinator;
    private DataValidation dv=new DataValidation();

    public void run() {
        if (firstRun) {
            VaccinationCenterType VCTYPE1 = new VaccinationCenterType(1, "Mass Vaccination Center");
            VaccinationCenterType VCTYPE2 = new VaccinationCenterType(2, "HealthCareCenter");
            vcController.saveVaccinationCenterType(VCTYPE1);
            vcController.saveVaccinationCenterType(VCTYPE2);
            firstRun = false;
        }

        vcTypeID = selectCenterType();
        VaccinationCenterType vcType = vcController.getVaccinationCenterTypeById(vcTypeID);
        name=enterName();
        address=enterAddress();
        phoneNumber=enterPhoneNumber();
        faxNumber=enterFaxNumber();
        email=enterEmail();
        website=enterWebsite();
        slotDuration=enterSlotDuration();
        maximumVaccinesPerSlot=enterMaximumVaccinesSlot();
        openingHour=enterOpeningHour();
        closingHour=enterClosingHour();

        vcController.registerVaccinationCenter(vcType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot);



       /* ArrayList <Employee> coordinatorList= vcController.getCenterCoordinatorList();
        coordinatorList=vcController.getCenterCoordinatorList();


        if(coordinatorList.isEmpty()){

            System.out.println("It is not possible to register the Center Coordinator. No center coordinator has been registered yet");
        } else {
            coordinator=selectCenterCoordinator();
            vcController.addCenterCoordinator(coordinator);
        }*/


        List<VaccineType> vaccineTypeList = new ArrayList<>();

        vaccineTypeList = vcController.getVaccineTypeList();

        int vaccineTypeCode;

        if (vaccineTypeList.isEmpty()) {

            System.out.println("It is not possible to register the vaccine type. No vaccine type has been registered yet");
        } else {
            vaccineTypeCode=selectVaccineType(vaccineTypeList);
            VaccineType vaccineType = vcController.getVaccineTypeByCode(vaccineTypeCode);
            vcController.addVaccineType(vaccineType);
        }

        System.out.print(vcController.getVc().toString());

        boolean dataConfirm=confirmData();
        boolean save;

        if(dataConfirm) {
            save=vcController.saveVaccinationCenter();
            if(save) {

                System.out.println("The vaccination center has been successfully registered");

            } else {
                System.out.println("Sorry, it was not possible to register the vaccination center");
            }
        }else {
            System.out.println("Vaccination center data were not recorded.");
        }
    }


    private int selectCenterType(){
        System.out.println("\nVaccination center type:");

        boolean success = false;
        int idTyped = 0;
        List<VaccinationCenterType> vcType = new ArrayList<VaccinationCenterType>();

        do {
            vcType = vcController.getVaccinationCenterTypes();
            for(int i=0;i<vcType.size();i++ ) {
                System.out.println(vcType.get(i).toString());
            }
            idTyped = Utils.readIntegerFromConsole("Please select the ID of the intended vaccination center type ");

            for(int i=0;i<vcType.size();i++ ) {
                if (vcType.get(i).getVcId() == idTyped) {
                    success = true;
                }
            }

            if(!success){
                System.out.println("the ID entered is not registered");
            }

        }while(!success);

        return idTyped;

    }

  /*  private Employee selectCenterCoordinator () {
        boolean success = false;
        coordinator=COORDINATOR_DEFAULT;
       ArrayList <Employee> coordinatorList= vcController.getCenterCoordinatorList();
        do{
            for(int i=0;i<coordinatorList.size();i++ ) {
                System.out.println(coordinatorList.get(i).toString());
            }
            int citezenCardTyped= Utils.readIntegerFromConsole("Please enter the citizen card of the intended center coordinator");

            for(int i=0;i<coordinatorList.size();i++ ) {

                if(coordinatorList.get(i).getCitizenCardNumber()==citezenCardTyped); {
                    coordinator=coordinatorList.get(i);
                    success=true;
                }

                if(!success){
                    System.out.println("the code entered is not registered");
                }
            }

        }while (!success);

        return coordinator;

    }

   */

    private int selectVaccineType (List<VaccineType>vaccineTypeList) {
        boolean success=false;
        int codeVaccineType=0000;
        vaccineTypeList=vcController.getVaccineTypeList();
        do{
            System.out.println("\nVaccine Type List");
            for(int i=0;i<vaccineTypeList.size();i++ ) {
                System.out.println(vaccineTypeList.get(i).toString());
            }
            codeVaccineType = Utils.readIntegerFromConsole("Please enter  the code of the intended vaccine type ");
            for(int i=0;i<vaccineTypeList.size();i++ ) {
                if (vaccineTypeList.get(i).getCode() == codeVaccineType) {
                    success = true;
                }
            }
            if(!success){
                System.out.println("the code entered is not registered");
            }
        }while (!success);
        return  codeVaccineType;
    }

    private boolean confirmData(){
        boolean check_typed = false;
        boolean result=false;
        do{
            String typed = Utils.readLineFromConsole("Please confirm the vaccination center data (type: OK or NOK)");
            if(typed.equalsIgnoreCase("OK")){
                check_typed = true;
                result= true;
            }else if(typed.equalsIgnoreCase("NOK")){
                check_typed = true;
                result=false;
            }else{
                System.out.println("Please type OK or NOK");
            }
        }while(!check_typed);
        return result;
    }

    private String enterName (){
        boolean checkVcName;
        do {
            try {
                name = Utils.readLineFromConsole("Enter the Vaccination Center name");
                dv.validateName(name);
                checkVcName=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkVcName=false;

            }
        }while(!checkVcName);

        return name;

    }

    private Address enterAddress(){
        boolean checkVcAddress;
        do{
            try {
                String addressTyped = Utils.readLineFromConsole("Enter the address (Format: STREET,HOUSENUMBER,CITY");
                String[] addressSplit = addressTyped.split(",");
                if (addressSplit.length != 3) {
                    throw new IllegalArgumentException("Please enter the addres in format: STREET, HOUSENUMBER,CITY");
                }
                checkVcAddress=true;
                address = new Address(addressSplit[0], Integer.parseInt(addressSplit[1]), addressSplit[2]);
            }catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkVcAddress=false;
            }
        }while (!checkVcAddress);

        return address;

    }

    private int enterPhoneNumber(){
        boolean checkPhoneNumber;
        do {
            try {
                phoneNumber = Utils.readIntegerFromConsole("Enter the vaccination center phone number");
                dv.validatePhoneFaxNumber(phoneNumber);
                checkPhoneNumber=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkPhoneNumber = false;
            }
        }while (!checkPhoneNumber);

        return phoneNumber;
    }

    private int enterFaxNumber(){
        boolean checkFaxNumber;
        do {
            try {
                faxNumber = Utils.readIntegerFromConsole("Enter the vaccination center fax number");
                dv.validatePhoneFaxNumber(faxNumber);
                checkFaxNumber = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkFaxNumber = false;
            }

        }while (!checkFaxNumber);
        return faxNumber;
    }

    private String enterEmail() {
        boolean checkVcEmail;
        do {
            try {
                email = Utils.readLineFromConsole("Enter the vaccination center email");
                dv.validateEmail(email);
                checkVcEmail = true;

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkVcEmail = false;
            }

        } while (!checkVcEmail);
        return email;
    }

    private String enterWebsite() {
        boolean checkVcWebsite;
        do {
            try {
                website = Utils.readLineFromConsole("Enter the vaccination center website");
                dv.validateWebsite(website);
                checkVcWebsite = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkVcWebsite = false;
            }

        } while (!checkVcWebsite);
        return website;
    }

    private int enterSlotDuration() {
        boolean checkSlot = true;
        do {
            try {
                slotDuration = Utils.readIntegerFromConsole("Enter the slot duration in minutes");
                dv.validateSlotDuration(slotDuration);
                checkSlot = true;

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkSlot = false;
            }
        } while (!checkSlot);
        return slotDuration;
    }

    private int enterMaximumVaccinesSlot() {
        boolean checkMaxVaccines = true;
        do {
            try {
                maximumVaccinesPerSlot = Utils.readIntegerFromConsole("Enter the maximum vaccines per slot");
                dv.validateMaximumVaccinesPerSlot(maximumVaccinesPerSlot);
                checkMaxVaccines = true;

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkMaxVaccines = false;
            }
        } while (!checkMaxVaccines);
        return maximumVaccinesPerSlot;
    }

    private WorkingHour enterOpeningHour() {
        boolean checkOpeningHour = true;
        do {
            try {
                String openingHourTyped = Utils.readLineFromConsole("Enter vaccination center opening hour. Format: HH:MM");
                String[] openingHourSplit = openingHourTyped.split(":");
                openingHour = new WorkingHour(Integer.parseInt(openingHourSplit[0]), Integer.parseInt(openingHourSplit[1]));
                checkOpeningHour = true;
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkOpeningHour = false;
            }

        } while (!checkOpeningHour);

        return openingHour;
    }


    private WorkingHour enterClosingHour() {
        boolean checkClosingHour=true;
        do {
            try {
                String closingHourTyped = Utils.readLineFromConsole("Enter vaccination center closing hour. Format: HH:MM");
                String[] closingHourSplit = closingHourTyped.split(":");
                closingHour = new WorkingHour(Integer.parseInt(closingHourSplit[0]), Integer.parseInt(closingHourSplit[1]));
                checkClosingHour = true;
                if (openingHour.compareTo(closingHour) == 1 || openingHour.compareTo(closingHour) == 0) {
                    throw new IllegalArgumentException("The opening hour must be less than the closing hour.");
                }
            }catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                checkClosingHour = false;

            }
        } while (!checkClosingHour);

        return closingHour;
    }

}




