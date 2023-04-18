package app.domain.model;

/**
 * It represents a Health Care Center that administers a vaccine type to respond to a certain pandemic
 */
public class HealthCareCenter extends VaccinationCenter{

    /**
     * Health Care Center full constructor
     * Probably new attributes will be added in the next sprints
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
     * @param centerCoordinator
     */

    public HealthCareCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType, Employee centerCoordinator) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot, vaccineType, centerCoordinator);
    }

    /**
     *  Health Care Center constructor without center coordinator and vaccine type
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

    public HealthCareCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot);
    }

    /**
     * Health Care Center constructor without center coordinator
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param faxNumber
     * @param slotDuration
     * @param openingHour
     * @param closingHour
     * @param maximumVaccinesPerSlot
     * @param vaccinationCenterType
     * @param vaccineType
     */

    public HealthCareCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot, vaccineType);
    }

    /**
     * Health Care Center constructor without vaccine type
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
     * @param centerCoordinator
     */

    public HealthCareCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, Employee centerCoordinator) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot, centerCoordinator);
    }

    /**
     *Obtains in text format the information needed for a Vaccination Center registration
     * @return Textual and visible representation of the vaccination center
     */

    @Override
    public String toString() {
        return super.toString();

    }




}
