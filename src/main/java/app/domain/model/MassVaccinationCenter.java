package app.domain.model;


/**
 * It represents a Mass Vaccination Center to respond to a certain pandemic
 *
 */

public class MassVaccinationCenter extends VaccinationCenter{
    /**
     * Mass Vaccination Center full constructor
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

    public MassVaccinationCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType, Employee centerCoordinator) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot, vaccineType, centerCoordinator);
    }

    /**
     * Mass Vaccination Center constructor without center coordinator and vaccine type
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

    public MassVaccinationCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot);
    }

    /**
     * Mass Vaccination Center constructor without center coordinator
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

    public MassVaccinationCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, VaccineType vaccineType) {
        super(vaccinationCenterType, name, address, phoneNumber, email, faxNumber, website, slotDuration, openingHour, closingHour, maximumVaccinesPerSlot, vaccineType);
    }

    /**
     * Mass Vaccinatin Center constructor without vaccine type
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

    public MassVaccinationCenter(VaccinationCenterType vaccinationCenterType, String name, Address address, int phoneNumber, String email, int faxNumber, String website, int slotDuration, WorkingHour openingHour, WorkingHour closingHour, int maximumVaccinesPerSlot, Employee centerCoordinator) {
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