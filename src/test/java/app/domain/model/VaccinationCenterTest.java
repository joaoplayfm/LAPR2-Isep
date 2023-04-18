package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterTest {
    @Test
    void createValidVaccinationCenter (){
        VaccinationCenter vc1 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
        Assertions.assertNotNull(vc1);
    }

    @Test
    void getName() {
        VaccinationCenter vc1 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
        String result=vc1.getName();
        Assertions.assertEquals("Centro Teste",result);
    }

    @Test
    void getPhoneNumber() {
        VaccinationCenter vc1 = new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30);
        int phoneNumber=vc1.getPhoneNumber();
        Assertions.assertEquals(224221558,phoneNumber);

    }


    @Test
    void InvalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void InvalidAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",-25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void invalidPhoneNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 222, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }


    @Test
    void invalidEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "testeipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void invalidFaxNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 11111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }


    @Test
    void invalidWebsite() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void invalidSlotDuration() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",80, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void invalidSlotDuration2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",-1, new WorkingHour(9,30), new WorkingHour(18, 30), 30), "Assertion failed." );
    }

    @Test
    void invalidMaximumVaccinesPerSlot() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(9,30), new WorkingHour(18, 30), -30), "Assertion failed." );

    }

    @Test
    void invalidMaximumVaccinesPerSlot2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",-45, new WorkingHour(9,30), new WorkingHour(18, 30), 333333), "Assertion failed." );

    }

    @Test
    void InvalidOpeningAndClosingHours() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new MassVaccinationCenter(new VaccinationCenterType(1, "HealthCareCenter"), "Centro Teste", new Address("Rua de Teste",25,"Valongo"), 224221558, "teste@ipp.pt", 111111111, "www.ola.pt",45, new WorkingHour(18,30), new WorkingHour(9, 30), 30), "Assertion failed." );
    }
}