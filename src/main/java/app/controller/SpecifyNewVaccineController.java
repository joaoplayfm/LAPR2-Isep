package app.controller;

import app.domain.model.*;

import java.util.List;

/**
 * It refers to the controller of the registration process of a new vaccine that implements methods to control the data flow of the vaccine and its administration process.
 */
public class SpecifyNewVaccineController {
    private App app;
    private Company company;
    private Vaccine v;
    private VaccineType vTselected;
    private AdministrationProcess vprocess;

    /**
     *Constructor of the Controller
     */
    public SpecifyNewVaccineController() {

        this.app=App.getInstance();
        this.company = app.getCompany();
        this.v=null;
        this.vTselected=null;

    }

    /**
     * Sets the vaccine type chosen by the UI
     * @param vTselected
     */
    public void setvTselected(VaccineType vTselected) {
        this.vTselected = vTselected;
    }

    /**
     * Gets The List of Vaccine Types stored in the class "VaccineTypeStore" obtained by the class company.
     * @return
     */

    public List<VaccineType> getVacccineTypesList()  {
    return company.getVaccineTypeStore().getVaccineTypeList();
    }

    /**
     * Method to initialize the process of creating a new vaccine
     * @param id
     * @param name
     * @param brand
     */
    public void createVaccine( int id, String name,String brand) throws IllegalArgumentException{


     v= company.getVaccineStore().createVaccine(id,name,brand,vTselected);
    }

    /**
     *Method to Save the Vaccine created
     * @return
     */
    public boolean saveVaccine(){
    return company.getVaccineStore().saveVaccine(v);
    }

    /**
     * Method to initialize the process of creating the Administration Process.
     * @param ageX
     * @param ageY
     * @param vaccineDosage
     * @param timeIntervalDose
     * @return
     */
    public boolean CreateAgeGrouVacinationProcess(int ageX, int ageY, List<Float> vaccineDosage, List<Integer> timeIntervalDose) {
        vprocess=v.getAdministrationProcess();
        return vprocess.CreateAdministrationProcess( ageX, ageY,  vaccineDosage,timeIntervalDose);

    }

    /**
     * Gets the Vaccine Created
     * @return
     */
    public Vaccine getV() {
        return v;
    }

    /**
     * Gets the Vaccine Type selected.
     * @return
     */
    public VaccineType getvTselected() {
        return vTselected;
    }

}
