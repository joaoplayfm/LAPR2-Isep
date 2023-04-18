package app.domain.store;

import app.controller.App;
import app.domain.model.Address;
import app.domain.model.Company;
import app.domain.model.SnsUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserStoreTest {

    @Test
    void createSnsUser() {
        Address address1 = new Address("Rua da Boavista", 303, "Valongo");
        SnsUserStore store = new SnsUserStore();
        store.CreateSnsUser("914916567", "123456789", "12345678",new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 13);
        store.saveSnsUser();
        Assertions.assertFalse(store.validateSnsUser(store.getSnsUser()));
    }


    @Test
    void validateSnsUser() {
        Address address1 = new Address("Rua da Boavista", 303, "Valongo");
        SnsUserStore store = new SnsUserStore();
        store.CreateSnsUser("914916567", "123456789", "12345678",new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 13);
        Assertions.assertTrue(store.validateSnsUser(store.getSnsUser()));
    }

    @Test
    void saveSnsUser() {
        Address address1 = new Address("Rua da Boavista", 303, "Valongo");
        SnsUserStore store = new SnsUserStore();
        store.CreateSnsUser("914916567", "123456789", "12345678",new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 13);
        Assertions.assertTrue(store.saveSnsUser());
    }

    @Test
    void addUser() {
        Address address1 = new Address("Rua da Boavista", 303, "Valongo");
        SnsUserStore store = new SnsUserStore();
        store.CreateSnsUser("914916567", "123456789", "12345678",new Date(), "joao.sg18@gmail.com", "Joao",address1, 'M', 13);
        store.saveSnsUser();
        Company company = App.getInstance().getCompany();
        Assertions.assertFalse(store.addUser(company));
    }

}