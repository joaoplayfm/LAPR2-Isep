
package app.ui.console;
import app.controller.SpecifyNewVaccineController;
import app.controller.SpecifyNewVaccineTypeController;
import app.domain.model.VaccineType;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

class SpecifyNewVaccineUI implements Runnable {

SpecifyNewVaccineController ctrl;
    SpecifyNewVaccineTypeController ctrl2; //to Teste
    public SpecifyNewVaccineUI() {
        this.ctrl = new SpecifyNewVaccineController();
        this.ctrl2= new SpecifyNewVaccineTypeController(); // to teste
        ctrl2.createVaccineType(1423,"COVID-19","ll"); //to Teste
        ctrl2.saveVaccineType(); //to Teste
    }

    @Override
    public void run() {

        boolean correct;

        ctrl.setvTselected((VaccineType) Utils.showAndSelectOne(getVacccineTypes(), "please, select Vaccine Type"));


        String name, brand;
        int id;

        System.out.println("CREATE VACCINE");

do {
    try {
        id = Utils.readIntegerFromConsole("Lot:");
        name = Utils.readLineFromConsole("Name: ");
        brand = Utils.readLineFromConsole("Brand: ");

        createVaccine(id, name, brand);
        correct=true;
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        correct=false;
    }

}while (!correct);

        System.out.println(ctrl.getV().toString());

        String option;
        do {

            int ageX, ageY, vdose;
            List<Float> vaccineDosage = new ArrayList<Float>();
            List<Integer> intervalTimeDose = new ArrayList<Integer>();
            System.out.println("\n \nAdministration Procces: AGE GROUPS CREATION AND DOSES");
            ageX = Utils.readIntegerFromConsole(" age from:");
            ageY = Utils.readIntegerFromConsole("until: ");
            vdose = Utils.readIntegerFromConsole("Vaccine Doses:");

            for (int i = 0; i < vdose; i++) {
                System.out.println("Dose nº" + (i+1));
                vaccineDosage.add(Utils.readFloatFromConsole("VaccineDosage:"));
                intervalTimeDose.add(Utils.readIntegerFromConsole("Interval's Day:"));
            }
            createVaccinationProcess(ageX, ageY, vaccineDosage, intervalTimeDose);

            do {
                option = Utils.readLineFromConsole("other Group? (y/n)");
            } while (!option.equals("y") && !option.equals("n"));


        } while (option.equals("y"));

        System.out.println(ctrl.getV().toString());
        System.out.println(ctrl.getV().getAdministrationProcess().toString());

        option = null;
        do {
            option = Utils.readLineFromConsole("Save Vaccine?(y/n)");
        } while (!option.equals("y") && !option.equals("n"));

        if (option.equals("y")) {
            saveVaccine();
            System.out.println("the Vaccine was saved. ");
        }else {
            System.out.println("the Vaccine was not saved. ");
        }


    }
    public List<VaccineType> getVacccineTypes(){
        return ctrl.getVacccineTypesList();

    }
    public void createVaccine(int id, String name, String brand )throws IllegalArgumentException{

        ctrl.createVaccine(id,name,brand);
    }
    public void saveVaccine() {
    ctrl.saveVaccine();
    }
    public void createVaccinationProcess(int ageX, int  ageY, List<Float> vaccineDosage, List<Integer>intervalTimeDose){
        ctrl.CreateAgeGrouVacinationProcess(ageX,ageY,vaccineDosage,intervalTimeDose);
    }




}