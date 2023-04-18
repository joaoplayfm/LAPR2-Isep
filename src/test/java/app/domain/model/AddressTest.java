package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AddressTest {
    @Test
    public void createValidAddress() {
        Address address1 = new Address("Rua da Boavista", 303, "Valongo");
        Assertions.assertNotNull(address1);
    }

    @Test
    public void invalidDoorNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Address("Rua da Boavista", -303, "Valongo"), "Assertion failed.");

    }

    @Test
    public void invalidStreet() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Address("", 303, "Valongo"), "Assertion failed.");

    }
    @Test
    public void invalidcity() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Address("Rua da Boavista", 303, ""), "Assertion failed.");

    }
}