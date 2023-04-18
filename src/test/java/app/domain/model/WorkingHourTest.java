package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkingHourTest {

    @Test
    void creatValidHour() {
        WorkingHour wH1=new WorkingHour(9,30);
        Assertions.assertNotNull(wH1);
    }

    @Test
    void getMinutes() {
        WorkingHour wH1=new WorkingHour(9,30);
        int result=wH1.getMinutes();
        Assertions.assertEquals(30,result);
    }

    @Test
    void invalidHours() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new WorkingHour(24,30), "Assertion failed.");

    }

    @Test
    void invalidMinutes() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new WorkingHour(00,62), "Assertion failed.");
    }


    @Test
    void compareToHoursFirstEarly() {
        WorkingHour wH1=new WorkingHour(9,30);
        WorkingHour wH2=new WorkingHour(10,30);
        int result= wH1.compareTo(wH2);
        Assertions.assertEquals(-1, result);

    }

    @Test
    void compareToHoursSecondEarly() {
        WorkingHour wH1=new WorkingHour(11,30);
        WorkingHour wH2=new WorkingHour(10,30);
        int result= wH1.compareTo(wH2);
        Assertions.assertEquals(1, result);

    }

    @Test
    void compareToHoursEquals() {
        WorkingHour wH1=new WorkingHour(10,30);
        WorkingHour wH2=new WorkingHour(10,30);
        int result= wH1.compareTo(wH2);
        Assertions.assertEquals(0, result);

    }

}