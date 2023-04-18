package app.domain.model;

public class OrgRole {

    private int roleId;
    private String roleDescription;


    /**
     * OrgRole full constructor
     * @param roleId
     * @param roleDescription
     */
    public OrgRole(int roleId, String roleDescription) {
        this.roleId = roleId;
        this.roleDescription = roleDescription;
    }

    /**
     * Method that returns the roleID of the OrgRole
     *
     * @return return the roleID of the OrgRole
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Method that returns the description of the OrgRole
     *
     * @return return the description of the OrgRole
     */
    public String getDescription() {

        return roleDescription;
    }

    @Override
    public String toString() {
        return String.format( "ID: %s    Employee role: %s", roleId,roleDescription);
    }
}
