package app.domain.store;

import app.domain.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief It represents a store responsible for create a vaccination center, validate and save it in a Vaccination Center List
 */
public class VaccinationCenterStore {


    private List< VaccinationCenter > vaccinationCenterList = new ArrayList<>();

    public VaccinationCenterStore() {

        this.vaccinationCenterList =  new ArrayList<VaccinationCenter>();
    }

    /**
     * Method to instanciate a new vaccination center object
     * If vaccination center type equals 1 it instanciates a mass vaccination center
     * If vaccination center type equals 2 it instanciates a health care center
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
     * @return
     */

    public VaccinationCenter registerVaccinationCenter(VaccinationCenterType vcType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerShot){

        if(vcType.getVcId()==1) {
            return new MassVaccinationCenter(vcType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerShot);
        }else {
            return new HealthCareCenter(vcType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerShot);
        }
    }

    /**
     * Method to validate a vaccination center object
     * @param vc represents the vaccination center object
     * @return if the vaccination center object is null returns false, else returns true
     */


    public boolean validateVaccinationCenter(VaccinationCenter vc){
        if (vc == null)
            return false;
        return ! this.vaccinationCenterList.contains(vc);
    }


    /**
     * Method to confirm that the vaccination center object was saved in a vaccination center list
     * @param vc
     * @return true if the center was saved successfully
     */


    public boolean saveVaccinationCenter(VaccinationCenter vc){
        if (!validateVaccinationCenter(vc) || checkDuplicates(vc))
            return false;
        addVaccinationCenter(vc);
        return true;
    }

    /**
     * Method to add the created vaccine center to a vaccination center list
     * @param vc
     */

    private void addVaccinationCenter(VaccinationCenter vc){

        this.vaccinationCenterList.add(vc);

    }


    /**
     * Method to get the list of vaccination centers with the vaccination center objects that have been created
     * @return vaccinationCenterList
     */

    public List<VaccinationCenter> getVaccinationCenterList() {

        return vaccinationCenterList;
    }

    /**
     * Method to get a vaccination center information by its vaccination type id
     * @param vcTypeId represents the id code of vaccine type
     * @return vaccination center of the intended type
     */

    public VaccinationCenter getVaccinaTionCenterByvcId(int vcTypeId){
        for(int i=0;i<vaccinationCenterList.size();i++ ) {
            if (vaccinationCenterList.get(i).getVaccinationCenterType().getVcId() == vcTypeId) {
                return vaccinationCenterList.get(i);
            }
        }
            return null;
    }

    /**
     * Method to check of the vaccination center created is not yet present in the vaccination centers list
     * @param vc represents the vaccination center
     * @return true if it finds a duplicate name or phone number of vaccination center
     */

    private boolean checkDuplicates(VaccinationCenter vc){
        for(int i=0;i<vaccinationCenterList.size();i++ ) {
            if (vaccinationCenterList.get(i).getName().trim().equalsIgnoreCase((vc.getName().trim()))) {
                return true;
            } else if (vaccinationCenterList.get(i).getPhoneNumber()==vc.getPhoneNumber()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "VaccinationCenterStore{" +
                "vaccinationCenterList=" + vaccinationCenterList +
                '}';
    }
}
