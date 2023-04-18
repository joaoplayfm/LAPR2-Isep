package app.domain.model;


import app.domain.store.*;
import app.domain.store.SnsUserStore;

import app.domain.store.VaccineStore;
import app.domain.store.VaccineTypeStore;


import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;
import pt.isep.lei.esoft.auth.domain.store.UserRoleStore;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private VaccineTypeStore vTypeS;
    private VaccineStore vS;
    private final SnsUserStore snsUserList;
    private UserStore userStore =new UserStore();
    private VaccinationCenterTypeStore vcTypeStore = new VaccinationCenterTypeStore();
    private VaccinationCenterStore vcStore = new VaccinationCenterStore();
    private EmployeeStore eStore = new EmployeeStore();
    private UserRoleStore rStore = new UserRoleStore();


    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.snsUserList = new SnsUserStore();
        this.vTypeS=new VaccineTypeStore();
        this.vS=new VaccineStore();

    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


    public UserRoleStore getrStore() {
        return rStore;
    }

    public EmployeeStore getEmployeeStore(){
        return eStore;
    }

    public VaccinationCenterStore getVaccinationCenterStore () {
        return  vcStore;
    }


    public VaccinationCenterTypeStore getVaccinationCenterTypeStore(){
        return vcTypeStore;

    }

    public VaccineStore getVaccineStore(){
    return vS;
    }

    public VaccineTypeStore getVaccineTypeStore(){
    return vTypeS;
    }

    /**
     * @return the list of sns user in the System
     */
    public SnsUserStore getSnsUserList() {
        return this.snsUserList;
    }


    public UserStore getUserStore (){
        return userStore;
    }

    public List <UserDTO> getUserList(){
        return authFacade.getUsers();
    }
    public List <UserDTO> getUserListWithRole(String role){
        return authFacade.getUsersWithRole(role);
    }


    /**
     * A method to get a list of employees with a given role
     * @param role a role of the employee
     * @return employeesWithRole
     */
    public ArrayList<Employee> getListOfEmployeesWithRole(String role) {

        List<UserDTO> list = getUserListWithRole(role);
        ArrayList<Employee> employeesWithRole = new ArrayList<>();

        for (UserDTO u : list) {
            employeesWithRole.add(getEmployeeByEmail(u.getId()));
        }
        return employeesWithRole;
    }


    /**
     * A method to find in emloyeeList and return the employee with the given email
     * @param mail email of employee
     * @return employee
     */
    public Employee getEmployeeByEmail(String mail) {

        for (Employee e : eStore.getEmployeeList()) {
            String em = e.getEmail();

            if (em.equals(mail)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Employee with this email doesn´t exist");
    }


    /*public ArrayList <Employee> getCenterCoordinatorList (String ROLE_3) {
        return EmployeeStore.getEmployeesByRole(ROLE_3);
    }
    */

}
