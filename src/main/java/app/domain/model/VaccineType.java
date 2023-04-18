package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class VaccineType {

    private int code;
    private String designation;
    private String whoId;

    public int getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public String getWhoId() {
        return whoId;
    }

    public VaccineType (int code, String designation, String whoId) {
        checkCodeRules(code);
        checkDesignationRules(designation);
        this.code = code;
        this.designation = designation;
        this.whoId = whoId;
    }
    private void checkCodeRules(int code) {
        if (code == 0)
            throw new IllegalArgumentException("Code cannot be blank.");
        int length = String.valueOf(code).length();
        if ( (length < 4) || (length > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
    }
    private void checkDesignationRules(String designation){
        if (designation == null || designation.trim().isEmpty() || designation.length()>40) {
            throw new IllegalArgumentException("Invalid designation, it cannot be empty and has, at maximum, 40 chars");
        }
    }

public String toString(){
return this.code+" Designation: "+ this.designation;

}
}

