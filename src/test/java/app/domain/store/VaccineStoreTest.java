package app.domain.store;

import app.domain.model.Vaccine;
import app.domain.model.VaccineType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VaccineStoreTest {
VaccineStore store =new VaccineStore();

    Vaccine v1=new Vaccine(12122,"Pfizer","Pfizer",new VaccineType(14123,"Covid-19", ""));
    Vaccine v2=new Vaccine(1222,"Janssen","Jhonson",new VaccineType(47443,"Covid-19", ""));

    @Test
    void createVaccine() {

        assertNotNull(store.createVaccine(15522,"Abstrazeneca","Oxford",new VaccineType(57853,"Covid-19", "")));
    }

    @Test
    void validateVaccine() {
        boolean result=  store.validateVaccine(v1);
        Assertions.assertTrue(result);
    }

    @Test
    void saveVaccine() {
        boolean result=store.saveVaccine(v2);
        assertTrue(result);
    }
}