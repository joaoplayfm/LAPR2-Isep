package app.domain.model;

import static app.domain.shared.Constants.*;
import static app.domain.shared.Constants.SLOT_DEFAULT;


/**
 * It represents a vaccination center to respond to a certain pandemic
 */
public abstract class VaccinationCenter {

    /**
     * Vaccination center parameters
     */

    private String name;
    private Address address;
    private int phoneNumber;
    private String email;
    private int faxNumber;
    private String website;
    private int slotDuration;
    private WorkingHour openingHour;
    private WorkingHour closingHour;
    private int maximumVaccinesPerSlot;
    private VaccinationCenterType vaccinationCenterType;
    private VaccineType vaccineType;
    private Employee centerCoordinator;


    /**
     * Vaccination center full constructor
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param website
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerSlot
     * @param vaccinationCenterType
     * @param vaccineType
     * @param centerCoordinator
     */

    public VaccinationCenter (VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType,Employee centerCoordinator){

        this.vaccinationCenterType=vaccinationCenterType;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.faxNumber=faxNumber;
        this.website=website;
        this.slotDuration=slotDuration;
        try{
            this.openingHour=openingHour;
            this.closingHour=closingHour;
            if(openingHour.compareTo(closingHour)==1 || openingHour.compareTo(closingHour)==0 ) {
                throw new IllegalArgumentException("The opening hour must be less than the closing hour.");
            }
        }catch (Exception IllegalArgumentException){
            System.out.println(IllegalArgumentException.getMessage());
        }
        this.maximumVaccinesPerSlot=maximumVaccinesPerSlot;
        this.vaccineType=vaccineType;
        this.centerCoordinator=centerCoordinator;
    }


    /**
     * Vaccination Center constructor without center coordinator and vaccine type
     * It assumes the coordinator and vaccine type by default
     * @param vaccinationCenterType
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param website
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerSlot
     */

    public VaccinationCenter (VaccinationCenterType vaccinationCenterType,String name, Address address, int phoneNumber, String email,int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot) {

        this.vaccinationCenterType=vaccinationCenterType;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.faxNumber=faxNumber;
        this.website=website;
        this.slotDuration=slotDuration;
        try{
            this.openingHour=openingHour;
            this.closingHour=closingHour;
            if(openingHour.compareTo(closingHour)==1 || openingHour.compareTo(closingHour)==0 ) {
                throw new IllegalArgumentException("The opening hour must be less than the closing hour.");
            }
        }catch (Exception IllegalArgumentException){
            System.out.println(IllegalArgumentException.getMessage());
        }
        this.maximumVaccinesPerSlot=maximumVaccinesPerSlot;
        this.vaccineType=VACCINE_TYPE_DEFAULT;
        this.centerCoordinator=COORDINATOR_DEFAULT;

    }

    /**
     * Vaccination Center constructor without center coordinator
     * It assumes the center coordinator by default
     * @param vaccinationCenterType
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param website
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerSlot
     * @param vaccineType
     */

    public VaccinationCenter (VaccinationCenterType vaccinationCenterType,String name, Address address, int phoneNumber, String email,int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType) {

        this.vaccinationCenterType=vaccinationCenterType;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.faxNumber=faxNumber;
        this.website=website;
        this.slotDuration=slotDuration;
        try{
            this.openingHour=openingHour;
            this.closingHour=closingHour;
            if(openingHour.compareTo(closingHour)==1 || openingHour.compareTo(closingHour)==0 ) {
                throw new IllegalArgumentException("The opening hour must be less than the closing hour.");
            }
        }catch (Exception IllegalArgumentException){
            System.out.println(IllegalArgumentException.getMessage());
        }
        this.maximumVaccinesPerSlot=maximumVaccinesPerSlot;
        this.vaccineType=vaccineType;
        this.centerCoordinator=COORDINATOR_DEFAULT;
    }

    /**
     * Vaccination Center constructor without vaccine type
     *  It assumes the vaccine type by default
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param website
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerSlot
     * @param vaccinationCenterType
     * @param centerCoordinator
     */

    public VaccinationCenter (VaccinationCenterType vaccinationCenterType,String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot,Employee centerCoordinator) {
        this.vaccinationCenterType=vaccinationCenterType;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.faxNumber=faxNumber;
        this.website=website;
        this.slotDuration=slotDuration;
        try{
            this.openingHour=openingHour;
            this.closingHour=closingHour;
            if(openingHour.compareTo(closingHour)==1 || openingHour.compareTo(closingHour)==0 ) {
                throw new IllegalArgumentException("The opening hour must be less than the closing hour.");
            }
        }catch (Exception IllegalArgumentException){
            System.out.println(IllegalArgumentException.getMessage());
        }
        this.maximumVaccinesPerSlot=maximumVaccinesPerSlot;
        this.vaccineType=VACCINE_TYPE_DEFAULT;
        this.centerCoordinator=centerCoordinator;
    }

    /**
     * Obtains the Vaccination Center Type
     * @return Vaccination Center Type1
     */
    public VaccinationCenterType getVaccinationCenterType() {
        return vaccinationCenterType;
    }

    /**
     * Method to get the responsible coordinator of the vaccination center
     * @return center coordinator (employee)
     */

    public Employee getCenterCoordinator() {
        return centerCoordinator;
    }

    /**
     * Method to get the name of the vaccination center
     * @return vaccionation center name
     */

    public String getName() {
        return name;
    }

    /**
     * Method to get the phone number of the vaccination center
     * @return phone number
     */

    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to get the pandemic vaccine type
     * @return vaccine type
     */

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    /**
     *Obtains in text format the information needed for a Vaccination Center registration
     * @return Textual and visible representation of the vaccination center
     */


    @Override
    public String toString() {

        return String.format("Vaccination Center Registration \n %s \n Name: %s \n Adress: %s \n Phone Number: %d \n E-mail: %s \n Fax Number: %d \n Website: %s \n Slot Duration: %d \n Maximum Vaccines Per Slot %d \n Center Coordinator:  %s \n Vaccine type(Pandemic): %s \n ", vaccinationCenterType.toString(), name, address, phoneNumber, email, faxNumber, website, slotDuration, maximumVaccinesPerSlot, centerCoordinator.toString(), vaccineType.toString());

    }

    /**
     *Method that modifies the coordinator of one vaccination center
     * @param centerCoordinator
     */
    public void setCenterCoordinator(Employee centerCoordinator) {
        this.centerCoordinator = centerCoordinator;
    }

    /**
     * Method that modifies the vaccine type
     * @param vaccineType
     */

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }


    /**
     * Method that modifies  the vaccination center name
     *
     * @param name
     */
    public void setName(String name) { this.name=name;}

    /**
     * Method that modifies  the vaccination center address
     * @param address
     */

    public void setAddress(Address address) {
            this.address = address;
    }

    /**
     * Method that modifies the vaccination center phone number
     * @param phoneNumber
     */

    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}

    public void setEmail(String email) {this.email = email;
    }

    /**
     * Method that modifies the vaccination center fax number
     * @param faxNumber
     */

    public void setFaxNumber(int faxNumber) {this.faxNumber = faxNumber;
    }

    /**
     * Method that modifies the vaccination center website
     * @param website
     */

    public void setWebsite(String website) {this.website = website;}

    /**
     * Method that modifies the slot duration (vaccine administration process)
     * @param slotDuration
     */

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;}

    /**
     * Method that modifies the maximum vaccines per slot (vaccine administration process)
     * @param maximumVaccinesPerSlot
     */
w

    public void setMaximumVaccinesPerSlot(int maximumVaccinesPerSlot) {this.maximumVaccinesPerSlot = maximumVaccinesPerSlot;}
}
