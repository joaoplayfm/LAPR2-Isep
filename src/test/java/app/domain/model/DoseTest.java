package app.domain.model;

import app.domain.model.Dose;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoseTest {
    Dose teste = new Dose(5.5F, 21);

    @Test
    void getVaccineDosage() {
        float except = 5.5F;
        assertEquals(teste.getVaccineDosage(), except);
    }

    @Test
    void getTimeIntervalDose() {
        int except = 21;
        assertEquals(teste.getTimeIntervalDose(), except);
    }
}
