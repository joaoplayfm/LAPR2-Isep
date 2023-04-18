package app.domain.store;

import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

public class OrgRolesStore {
    private List<OrgRole> orgRolesList = new ArrayList();

    static boolean already_added = false;

    private static final OrgRole ROLE_1= new OrgRole(1, "Receptionist");
    private static final OrgRole ROLE_2= new OrgRole(2, "Nurse");
    private static final OrgRole ROLE_3= new OrgRole(3, "Coordinator");


    /**
     * Method to add the organization roles
     */
    public void addOrgRole(OrgRole role){
        orgRolesList.add(role);
    }


    /**
     * Method that shows the list of the organization roles
     * @return returns the organization roles
     */
    public List<OrgRole> getOrgRolesList() {
        return this.orgRolesList;
    }

    /**
     * Method that shows the organization roles by the id
     * @param roleId
     * @return
     */
    public OrgRole getOrgRoleById(int roleId) {
        for (int i = 0; i < this.orgRolesList.size(); ++i) {
            if (((OrgRole) this.orgRolesList.get(i)).getRoleId() == roleId) {
                return (OrgRole) this.orgRolesList.get(i);
            }
        }
        return null;
    }


}
