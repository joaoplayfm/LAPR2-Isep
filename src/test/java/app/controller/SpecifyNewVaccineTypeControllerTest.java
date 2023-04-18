package app.controller;

import app.domain.model.VaccineType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecifyNewVaccineTypeControllerTest {
    SpecifyNewVaccineTypeController ctrl = new SpecifyNewVaccineTypeController();

    @Test
    void createVaccineType() {
        VaccineType vt=new VaccineType(1234,"Covid","abc");
        boolean result=ctrl.createVaccineType(1234, "Covid", "abc");
        Assertions.assertTrue(result);

    }
}