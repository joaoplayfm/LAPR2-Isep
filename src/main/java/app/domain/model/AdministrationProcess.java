package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *It represents  The Administration Process of a vaccine.
 */
public class AdministrationProcess {
    private List<AgeGroup> group;

    /**
     * Contructor of Administration Process.
     */
    public AdministrationProcess() {
        this.group = new ArrayList<AgeGroup>();
    }

    /**
     *  method to save the Age Group in the List of Administration Process.
     * @param age
     * @return
     */
    public boolean addAgeGroup(AgeGroup age) {
        if (!validateAdministrationProcess(age))
            return false;
        return this.group.add(age);

    }

    /** method to validate the Age Group
     * @param age
     * @return
     */
    public boolean validateAdministrationProcess(AgeGroup age) {
        if (age == null)
            return false;

        return !this.group.contains(age);
    }

    /**
     * Method to register and Create  a new Age Group and doses.
     *
     * @param ageX
     * @param ageY
     * @param vaccineDosage
     * @param timeIntervalDose
     * @return
     */

    public boolean CreateAdministrationProcess(int ageX, int ageY, List<Float> vaccineDosage, List<Integer> timeIntervalDose) {
        AgeGroup ageSave = new AgeGroup(ageX, ageY);

        for (int i = 0; i < vaccineDosage.size(); i++) {
            ageSave.addDoses(new Dose(vaccineDosage.get(i), timeIntervalDose.get(i)));
        }

        return addAgeGroup(ageSave);
    }


    public List<AgeGroup> getGroup() {
        return group;
    }

    /**
     * Obtains in text format the information needed of all Administration Process.
     * @return
     */
    @Override
    public String toString() {
        String string = "";

            string += group.toString() + "\n";

        return string;
    }


}