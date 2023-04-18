package app.domain.store;

import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
  *The class represents the list de vaccine  stored  in the app.
 */
public class VaccineStore {

public List<Vaccine> vaccineList;

    /**
     *Constructor of VaccineStore
     */
    public VaccineStore() {
        this.vaccineList = new ArrayList<Vaccine>();
    }

    /**
     * Method to create a new vaccine.
     * @param id
     * @param name
     * @param brand
     * @param vt
     * @return
     */
    public Vaccine createVaccine(int id, String name, String brand, VaccineType vt)throws IllegalArgumentException {

        return new Vaccine(id, name, brand, vt);
    }

    /**
     * Method to validate a vaccine.
     * @param v
     * @return
     */
    public boolean validateVaccine (Vaccine v) {

        if (v == null)
            return false;
        return ! this.vaccineList.contains(v);
    }

    /**
     * The method consists in saving the created vaccine for the list.
     * @param v
     * @return
     */
    public boolean saveVaccine (Vaccine v) {
        if (!validateVaccine(v))
            return false;
        return this.vaccineList.add(v);
    }

}
