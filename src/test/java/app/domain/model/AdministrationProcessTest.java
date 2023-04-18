package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministrationProcessTest {

    AdministrationProcess adpTeste=new AdministrationProcess();



    @Test
    void saveAgeGroup() {
        AgeGroup a=new AgeGroup(18,21);
        AgeGroup b=null;

        assertTrue(adpTeste.addAgeGroup(a));
        assertTrue(!adpTeste.addAgeGroup(b)); // ! <- Not true
    }

    @Test
    void validateAgeGroup() {
        AgeGroup a=new AgeGroup(18,21);
        AgeGroup b=null;

        assertNotNull(a);
        assertTrue(adpTeste.validateAdministrationProcess(a));
        assertTrue(!adpTeste.validateAdministrationProcess(b)); // ! <- Not true
    }

    @Test
    void CreateAdministrationProcess() {

        List<Float> vaccineDosage=new ArrayList<Float>();
        List<Integer> timeIntervalDose=new ArrayList<Integer>();

        vaccineDosage.add(1.0F);
        timeIntervalDose.add(23);
        vaccineDosage.add(2.0F);
        timeIntervalDose.add(25);
        vaccineDosage.add(3.5F);
        timeIntervalDose.add(30);

                Boolean resultado=adpTeste.CreateAdministrationProcess(18,21,vaccineDosage, timeIntervalDose);
assertTrue(resultado);

    }
}