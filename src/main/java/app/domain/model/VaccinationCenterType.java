package app.domain.model;

public class VaccinationCenterType {
    private int vcId;
    private String designation;

    public VaccinationCenterType (int vcId, String designation) {
        this.vcId=vcId;
        this.designation=designation;
    }


    public int getVcId() {
        return vcId;
    }

    public String getDesignation() {
        return designation;
    }

    public String toString (){

        return String.format("ID: %s    Vaccination Center Type: %s", vcId, designation);

    }
}

