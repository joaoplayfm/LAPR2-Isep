package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenterType;
import app.domain.model.VaccineType;

import java.util.List;

public class SpecifyNewVaccineTypeController {
    private Company company;
    private VaccineType vt;

    public SpecifyNewVaccineTypeController () {

        this(App.getInstance().getCompany());
    }
    public SpecifyNewVaccineTypeController(Company company) {
        this.company = company;
        this.vt = null;
    }
    public boolean createVaccineType(int code, String designation, String whoId) {
        this.vt = this.company.getVaccineTypeStore().createVaccineType(code, designation, whoId);
        return this.company.getVaccineTypeStore().validateVaccineType(vt);
    }
    public boolean saveVaccineType() {

        return this.company.getVaccineTypeStore().saveVaccineType(vt);

    }

    public VaccineType getVt() {
        return vt;
    }

    public List<VaccineType> getVaccineTypeList(){
        return company.getVaccineTypeStore().getVaccineTypeList();
    }





}
