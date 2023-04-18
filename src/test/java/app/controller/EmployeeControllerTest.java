package app.controller;

import app.domain.model.Address;
import app.domain.model.Employee;
import app.domain.model.Receptionist;
import app.domain.model.VaccineType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    EmployeeController eController = new EmployeeController();

    @Test
    void registerEmployee() {

        Employee employee =new Receptionist(1,"Maria Carneiro","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654321,87654321);
        boolean result=eController.registerEmployee("Receptionist",1,"Maria Carneiro","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654321,87654321);
        Assertions.assertTrue(result);

    }


}