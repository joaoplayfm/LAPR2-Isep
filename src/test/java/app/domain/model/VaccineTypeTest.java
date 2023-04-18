package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeTest {

    private VaccineType vt=new VaccineType(1234,"Covid","abc");


    @Test
    void getCode() {
        int result= vt.getCode();
        Assertions.assertEquals(1234, result);
    }

    @Test
    void getDesignation() {
        String result= vt.getDesignation();
        Assertions.assertEquals("Covid", result);

    }

    @Test
    void getWhoId() {
        String result= vt.getWhoId();
        Assertions.assertEquals("abc", result);
    }

    @Test
    void invalidDesignation() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new VaccineType(1234, "", "abc"), "Assertion failed." );

    }

    @Test
    void invalidCode() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new VaccineType(123, "Covid", "abc"), "Assertion failed." );

    }



}