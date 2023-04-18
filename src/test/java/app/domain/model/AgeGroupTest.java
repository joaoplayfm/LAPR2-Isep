package app.domain.model;

import app.domain.model.AgeGroup;
import app.domain.model.Dose;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgeGroupTest {

    AgeGroup age=new AgeGroup(18,21);
    Dose dosetest=new Dose(23.3f,31);
Dose dosetest2=new Dose(12f,9);

@org.junit.jupiter.api.Test
     void setDoses() {

        assertTrue(age.addDoses(dosetest));
    }

    @org.junit.jupiter.api.Test
    void getVaccineDose() {

        age.addDoses(dosetest);
        age.addDoses(dosetest2);

        int expect= 2;
        assertEquals(age.getVaccineDose(),expect);
    }
}