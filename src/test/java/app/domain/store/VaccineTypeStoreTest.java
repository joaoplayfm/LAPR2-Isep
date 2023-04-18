package app.domain.store;
import app.domain.model.VaccineType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class VaccineTypeStoreTest {

    VaccineTypeStore store=new VaccineTypeStore();
    VaccineType v1=new VaccineType(1234,"Covid","abc");
    VaccineType v2=new VaccineType(1234,"Covid","abc");
    VaccineType v3=new VaccineType(1255,"Gripe","abc");


    @Test
    void validateVaccineType() {
        boolean result=store.validateVaccineType(v1);
        Assertions.assertTrue(result);
    }



    @Test
    void saveVaccineType() {
        boolean result=store.saveVaccineType(v1);
        Assertions.assertTrue(result);
    }

    @Test
    void getVaccineTypeList() {
        store.saveVaccineType(v1);
        store.saveVaccineType(v3);
        List<VaccineType> result = store.getVaccineTypeList();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void getVaccineTypeByCode() {
        store.saveVaccineType(v1);
        store.saveVaccineType(v3);
        List<VaccineType> result = store.getVaccineTypeList();
        VaccineType results=store.getVaccineTypeByCode(1234);
        Assertions.assertEquals(v1,results);

    }
}