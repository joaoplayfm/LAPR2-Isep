package app.domain.store;

import app.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class VaccinationCenterStoreTest {
    VaccinationCenterStore storeVc=new VaccinationCenterStore();
    VaccinationCenter vc1 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste1", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
    VaccinationCenter vc2 = new MassVaccinationCenter(new VaccinationCenterType(2, "HealthCareCenter"), "Centro Teste2", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
    VaccinationCenter vc3 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221559, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
    VaccinationCenter vc4 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221557, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);



    @Test
    void validateVaccinationCenter() {
        boolean result=storeVc.validateVaccinationCenter(vc1);
        Assertions.assertTrue(result);
    }


    @Test
    void saveVaccinationCenterCheckDuplicatesEqualPhoneNumber() {
        storeVc.saveVaccinationCenter(vc1);
        boolean result= storeVc.saveVaccinationCenter(vc2);
        Assertions.assertFalse(result);
    }

    @Test
    void saveVaccinationCenterCheckDuplicatesEqualName() {
        storeVc.saveVaccinationCenter(vc3);
        boolean result= storeVc.saveVaccinationCenter(vc4);
        Assertions.assertFalse(result);
    }

    @Test
    void saveVaccinationCenterTrue() {
        storeVc.saveVaccinationCenter(vc1);
        boolean result= storeVc.saveVaccinationCenter(vc3);
        Assertions.assertTrue(result);
    }


    @Test
    void getVaccinationCenterListcheckIfListIsNotEmpty() {
        storeVc.saveVaccinationCenter(vc1);
        storeVc.saveVaccinationCenter(vc2);
        List<VaccinationCenter> result = storeVc.getVaccinationCenterList();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void getVaccinationCenterListcheckIfListIsEmpty() {
        List<VaccinationCenter> result = storeVc.getVaccinationCenterList();
        Assertions.assertTrue(result.isEmpty());
    }

}