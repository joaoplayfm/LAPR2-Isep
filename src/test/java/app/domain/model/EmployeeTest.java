package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @Test
    public void createValidEmployee() {

        Employee employee1 = new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321);
        Assertions.assertNotNull(employee1);
    }


    @Test
    public void employeeWithInvalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321), "Assertion failed");
    }

    @Test
    public void employeeWithInvalidEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321), "Assertion failed.");
    }

    @Test
    public void employeeWithInvalidAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321), "Assertion failed.");
    }

    @Test
    public void employeeWithInvalidPhoneNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321), "Assertion failed.");
    }

    @Test
    public void employeeWithInvalidCitizenCardNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Nurse(1, "Mariana", "mariana@isep.ipp.pt", new Address("Rua do isep", 25, "Porto"), 987654321, 87654321), "Assertion failed.");
    }
}