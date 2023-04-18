package app.domain.store;

import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

public class VaccineTypeStore {

    private List<VaccineType> vaccineTypeList;


    public VaccineTypeStore() {
        this.vaccineTypeList =  new ArrayList<VaccineType>();
    }

    /**
     * Method that create a new vaccine type
     * @param code
     * @param designation
     * @param whoId
     * @return returns a new vaccine type
     *
     */
    public VaccineType createVaccineType (int  code, String designation, String whoId) {
        return new VaccineType(code, designation, whoId);
    }

    /**
     * Method that validate a vaccine type
     * @param vt vaccine type
     * @return returns false or true
     */
    public boolean validateVaccineType (VaccineType vt) {
        if (vt == null)
            return false;
        return ! this.vaccineTypeList.contains(vt);
    }

    /**
     * MEthod that save a vaccine type
     * @param vt vaccine type
     * @return returns false or true
     */
    public boolean saveVaccineType (VaccineType vt) {
        if (!validateVaccineType(vt))
            return false;
        return this.vaccineTypeList.add(vt);
    }

    /**
     * Method that shows the list of vaccine types
     * @return returns the list of vaccine types
     */
    public List<VaccineType> getVaccineTypeList() {

        return vaccineTypeList;
    }

    /**
     * Method that shows a vaccine type by her code
     * @param code
     * @return returns the vaccine type by code
     */
    public VaccineType getVaccineTypeByCode(int code){
        for(int i=0;i<vaccineTypeList.size();i++ ){

            if(vaccineTypeList.get(i).getCode() == code)
                return  vaccineTypeList.get(i);

        }
        return null;
    }
}
