package app.domain.store;

import app.domain.model.Address;
import app.domain.model.Employee;
import app.domain.model.Receptionist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeStoreTest {

    EmployeeStore employeeStore = new EmployeeStore();
    Employee employee1 = new Receptionist(1,"Maria Carneiro","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654321,87654321);
    Employee employee2 = new Receptionist(2,"Maria Ferreira","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654321,87654324);
    Employee employee3 = new Receptionist(3,"Maria Ferreira","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654322,87654322);
    Employee employee4 = new Receptionist(4,"Maria Carneiro","maria@isep.pt", new Address("Rua do Isep",65, "Porto"),987654324,87654324);


    @Test
    void validateEmployee() {
        boolean result = employeeStore.validateEmployee(employee1);
        Assertions.assertTrue(result);
    }

    @Test
    void saveEmployeeCheckDuplicatesEqualPhoneNumber() {
        employeeStore.saveEmployee(employee1);
        boolean result = employeeStore.saveEmployee(employee2);
        Assertions.assertTrue(result);

    }

    @Test
    void saveEmployeeCheckDuplicatesEqualCitizenCardNumber() {
        employeeStore.saveEmployee(employee1);
        boolean result = employeeStore.saveEmployee(employee3);
        Assertions.assertTrue(result);

    }


    @Test
    void saveEmployeeCheckDuplicatesEqualName() {
        employeeStore.saveEmployee(employee1);
        boolean result = employeeStore.saveEmployee(employee4);
        Assertions.assertTrue(result);

    }

    @Test
    void saveEmployeeTrue() {
        employeeStore.saveEmployee(employee1);
        boolean result = employeeStore.saveEmployee(employee2);
        Assertions.assertTrue(result);

    }
}