package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserTest {
    Address address1 = new Address("Rua da Boavista", 303, "Valongo");
    SnsUser sn1 = new SnsUser("914916567", "123456789", "12345678", new Date(), "joao.sg18@gmail.com", "Joao", address1, 'M', 12);

    @Test
    void getPhoneNumber(){
        String result = sn1.getPhoneNumber();
        Assertions.assertEquals("914916567", result);
    }

    @Test
    void getEmail(){

        String result = sn1.getEmail();
        Assertions.assertEquals("joao.sg18@gmail.com", result);
    }

    @Test
    void getSnsNumber(){

        String result = sn1.getSnsNumber();
        Assertions.assertEquals("123456789", result);
    }

    @Test
    void invalidPhoneNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new SnsUser("914916567", "123456789", "12345678", new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 12));
    }

    @Test
    void invalidCC(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new SnsUser("914916567", "123456789", "12345678", new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 12));
    }

    @Test
    void invalidSnsNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new SnsUser("914916567", "1234567898", "12345678", new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 13));
    }

    @Test
    void invalidBirthDate(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new SnsUser("914916567", "123456789", "12345678", new Date(2023,Calendar.APRIL, 11), "joao.sg18@gmail.com", "Joao",address1, 'M', 13));
    }

    @Test
    void invalidSex(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new SnsUser("914916567", "123456789", "12345678", new Date(), "joao.sg18@gmail.com", "Joao",address1, 'm', 13));
    }


}