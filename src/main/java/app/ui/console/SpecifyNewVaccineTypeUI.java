package app.ui.console;
import app.controller.SpecifyNewVaccineTypeController;
import app.domain.model.*;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecifyNewVaccineTypeUI implements Runnable{
    private SpecifyNewVaccineTypeController vtypeController= new SpecifyNewVaccineTypeController();
    private int code;
    private String designation;
    private String whoId;
    private List <VaccineType> vaccineTypeList=new ArrayList<>();


    public void run() {
        boolean success = false;
        System.out.println("Specify a new vaccine type");

        do {
            try {
                code = Utils.readIntegerFromConsole("Enter the vaccine type code");
                designation = Utils.readLineFromConsole("Enter the vaccine type designation");
                whoId = Utils.readLineFromConsole("Enter the vaccine type whoID");

            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());

                System.out.println("An error has occurred, please try specify the  new vaccine type again");

            }

            success = true;
        } while (!success);

        boolean create = vtypeController.createVaccineType(code, designation, whoId);

        if (!create) {
            System.out.println("It was not possible to create the new vaccine type");

        } else {

            boolean dataConfirm = confirmData();
            boolean save;

            if (dataConfirm) {
                save = vtypeController.saveVaccineType();
                if (save) {
                    System.out.println("The vaccine type has been successfully created");
                } else {
                    System.out.println("Sorry, it was not possible to create the vaccine");
                }
            } else {
                System.out.println("Vaccine type data were not recorded.");
            }
        }
    }


        private boolean confirmData(){
            boolean check_typed = false;
            boolean result=false;
            do{
                System.out.println("Please confirm the vaccine type data");
                System.out.println(vtypeController.getVt().toString());
                String typed = Utils.readLineFromConsole("Confirmation(type: OK or NOK)");


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

    }

