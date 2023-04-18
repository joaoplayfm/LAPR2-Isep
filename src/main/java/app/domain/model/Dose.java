package app.domain.model;

/**
 * the dose class represents interval time of a vaccine and your vaccine  dosage
 */
public class Dose {

    private float vaccineDosage;
    private int timeIntervalDose;

    /**
     *  Doses Construtor.
     * @param vaccineDosage
     * @param timeIntervalDose
     */
    public Dose(float vaccineDosage, int timeIntervalDose) {
        this.vaccineDosage = vaccineDosage;
        this.timeIntervalDose = timeIntervalDose;

    }

    /**
     * Gets the value  of Vaccine dosage.
     * @return
     */
    public float getVaccineDosage() {
        return vaccineDosage;
    }

    /**
     *Gets the value  of time Interval.
     * @return
     */
    public int getTimeIntervalDose() {
        return timeIntervalDose;
    }

    /**
     *Set the value  of Vaccine Dosage.
     * @return
     */
    public void setVaccineDosage(float vaccineDosage) {
        this.vaccineDosage = vaccineDosage;
    }
    /**
     *sets the value  of time Interval.
     * @return
     */
    public void setTimeIntervalDose(int timeIntervalDose) {
        this.timeIntervalDose = timeIntervalDose;
    }

    /**
     * Obtains in text format the information needed for a Dose.
     * @return
     */
    public String toString(){
        return "Dosage:"+ vaccineDosage+"ml, "+"interval time:"+timeIntervalDose+" day.";
    }
}
