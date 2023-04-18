package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * It refers to the register vaccination center controller that implements methods to control the flow of the vaccination center data
 */
public class RegisterVaccinationCenterController {
    private App app;
    private Company company;
    private VaccinationCenter vc;
    private VaccinationCenterType vcType;
    private VaccineType vaccineType;


    public RegisterVaccinationCenterController () {
        this(App.getInstance().getCompany());
    }

    public RegisterVaccinationCenterController(Company company) {
        this.app=App.getInstance();
        this.company = app.getCompany();
    }


    /**
     * Method to register a new vaccination center
     * @param vcType
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param website
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerShot
     */

    public boolean registerVaccinationCenter (VaccinationCenterType vcType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerShot) {
        this.vc = this.company.getVaccinationCenterStore().registerVaccinationCenter(vcType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerShot);
       return this.company.getVaccinationCenterStore().validateVaccinationCenter(vc);
    }

    /**
     * Method to get the vaccination center type by the ID code
     * @param vcID identifies the type of vaccination center
     * @return vaccination center type ID
     */


    public VaccinationCenterType getVaccinationCenterTypeById (int vcID) {
        vcType=this.company.getVaccinationCenterTypeStore().getVaccinationCenterTypeById(vcID);
        return vcType;
    }

    /**
     * Method to add the vaccination center type to vaccination center data
     * @param vcType refers to vaccination center type
     */

    public void saveVaccinationCenterType (VaccinationCenterType vcType) {
        this.company.getVaccinationCenterTypeStore().addVcType(vcType);
    }


    /**
     * Method to confirm that a vaccination center was saved with success
     * @return true if the vaccination center was successfully saved
     */
    public boolean saveVaccinationCenter(){

        return this.company.getVaccinationCenterStore().saveVaccinationCenter(vc);
    }

    /**
     * Method to get the vaccination center types list
     * @return vaccination center type list
     */


    public List<VaccinationCenterType> getVaccinationCenterTypes(){
        return this.company.getVaccinationCenterTypeStore().getVaccinationCenterTypeList();
    }

    /**
     * Method to get the vaccine type list
     * @return vaccine type list
     */

    public List<VaccineType> getVaccineTypeList(){
        return company.getVaccineTypeStore().getVaccineTypeList();
    }

    /**
     * Method to add the responsible center coordinator to vaccination center data
     * @param cc refers to center coordinator
     */

    public void addCenterCoordinator(Employee cc){
        vc.setCenterCoordinator(cc);
    }

   /*  public ArrayList<Employee>getCenterCoordinatorList(){
        return company.getCenterCoordinatorList("coordinator");
     }

    */

    /**
     * Method to get the vaccine type through the code
     * @param code of vaccine type
     * @return vaccine type
     */

    public VaccineType getVaccineTypeByCode(int code){
        return this.vaccineType=company.getVaccineTypeStore().getVaccineTypeByCode(code);

    }

    /**
     * Method to add the vaccine type (pandemic) to vaccination center data
     * @param vaccineType
     */

    public void addVaccineType(VaccineType vaccineType) {

        this.vc.setVaccineType(vaccineType);
    }

    /**
     * Method to get the vaccine type list
     * @return vaccine type list
     */

    public List<VaccineType> getVaccineTypes(){
        return company.getVaccineTypeStore().getVaccineTypeList();
    }

    /**
     * Method to obtain information from the vaccination center to be registered
     * @return vaccination center
     */

    public VaccinationCenter getVc() {
        return this.vc;
    }

    public List <VaccinationCenter> vaccinationCenterList (){
        return this.company.getVaccinationCenterStore().getVaccinationCenterList();
    }

}
