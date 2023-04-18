package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrgRoleTest {


    @Test
    void createValidRole(){
        OrgRole role1 = new OrgRole(1,"nurse");
        Assertions.assertNotNull(role1);
    }


}