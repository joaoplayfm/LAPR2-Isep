package app.domain.store;
import app.domain.model.VaccinationCenterType;
import java.util.ArrayList;
import java.util.List;

/**
 * It represents the Vaccination Center Types Store
 */
public class VaccinationCenterTypeStore {



    private List<VaccinationCenterType> vaccinationCenterTypeList = new ArrayList<VaccinationCenterType>();

    public VaccinationCenterTypeStore() {
        this.vaccinationCenterTypeList =  new ArrayList<VaccinationCenterType>();

    }

    public VaccinationCenterType createVaccinationCenterType(int id, String designation) {
        return new VaccinationCenterType(id, designation);
    }

    /**
     * Method to add the vaccination centers types to a list
     */

    public void addVcType (VaccinationCenterType vcType) {
        vaccinationCenterTypeList.add(vcType);

    }

    /**
     * Method to get the list of the existing vaccination center types
     * @return Vaccination Center Types List
     */


    public List<VaccinationCenterType> getVaccinationCenterTypeList() {

        return vaccinationCenterTypeList;
    }


    /**
     * Methodo to get a vaccination center type through the id code
     * @param vtId is the id code of a vaccination center type
     * @return vaccination center type or returns null if it doesn't find the intended type
     */

    public VaccinationCenterType getVaccinationCenterTypeById(int vtId){

        for(int i=0;i<vaccinationCenterTypeList.size();i++ ) {
            if (vaccinationCenterTypeList.get(i).getVcId() == vtId) {
                return vaccinationCenterTypeList.get(i);
            }
        }
        return null;
    }


}


