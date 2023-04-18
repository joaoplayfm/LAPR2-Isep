package app.controller;

import app.domain.model.AdministrationProcess;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SpecifyNewVaccineControllerTest {
SpecifyNewVaccineController ctrl=new SpecifyNewVaccineController();

    @Test
    void setvTsel1ected()  {

        assertNull(ctrl.getvTselected());

        ctrl.setvTselected(new VaccineType(1122,"CD2","12"));

        assertNotNull(ctrl.getvTselected());
    }

    @Test
    void getVacccineTypesList() {

        //verify if the list is not null
        assertNotNull(ctrl.getVacccineTypesList());

        int expect=0;
        assertEquals(ctrl.getVacccineTypesList().size(),expect);
    }

    @Test
    void createVaccine() {
        VaccineType vtTeste=new VaccineType(1122,"CD2","12");
        Vaccine vteste= new Vaccine(1233,"CD","Pfizer",vtTeste);

        ctrl.setvTselected(vtTeste);
        ctrl.createVaccine(1233,"CD","Pfizer");


        assertNotNull(ctrl.getV());
       assertEquals(ctrl.getV().toString(),vteste.toString());

    }

    @Test
    void saveVaccine() {
        VaccineType vtTeste=new VaccineType(1122,"CD2","12");

        ctrl.setvTselected(vtTeste);
        ctrl.createVaccine(1233,"CD","Pfizer");

        assertTrue(ctrl.saveVaccine());
    }

    @Test
    void createAgeGrouVacinationProcess() {

        VaccineType vtTeste=new VaccineType(1122,"CD2","12");

        ctrl.setvTselected(vtTeste);
        ctrl.createVaccine(1233,"CD","Pfizer");

        List<Float> dosage=new ArrayList<Float>();
        List<Integer> interval=new ArrayList<Integer>();
        assertNotNull(ctrl.getV().getAdministrationProcess());
        assertTrue(ctrl.CreateAgeGrouVacinationProcess(18,21,dosage,interval));
    }

    @Test
    void getV() {
        VaccineType vtTeste=new VaccineType(1122,"CD2","12");

        ctrl.setvTselected(vtTeste);
        ctrl.createVaccine(1233,"CD","Pfizer");

        assertNotNull(ctrl.getV());
    }

    static class VaccineTest {
        VaccineType vtTeste=new VaccineType(1122,"CD2","12");
    Vaccine v=new Vaccine(123,"CD","Pfizer",vtTeste);
        @Test
        void getAdministrationProcess() {
            assertNotNull(v);
            assertEquals(v.getAdministrationProcess().getClass(), AdministrationProcess.class);
        }

        @Test
        void testToString() {
            assertEquals(" id: 123 Name: CD Brand: Pfizer Vaccine Type:1122 CD2",v.toString());
        }
    }
}