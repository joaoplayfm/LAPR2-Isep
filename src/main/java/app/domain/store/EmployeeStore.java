package app.domain.store;

import app.domain.model.*;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.Email;
import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.model.UserRole;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmployeeStore {

    /**
     * List of employees
     */
    private List<Employee> employeeList = new ArrayList<>();
    private AuthFacade auth = new AuthFacade();

    private UserRole role;

    public EmployeeStore() {

        this.employeeList = new ArrayList<Employee>();
    }


    /**
     * Method that create an employee
     *
     * @param roleDesc
     * @param ID
     * @param name
     * @param email
     * @param address
     * @param phoneNumber
     * @param citizenCardNumber
     * @return
     */
    public Employee createEmployee(String roleDesc, int ID, String name, String email, Address address, int phoneNumber, int citizenCardNumber) {
        if (roleDesc.equals(Constants.ROLE_NURSE)) {
            return new Nurse(ID, name, email, address, phoneNumber, citizenCardNumber);
        } else if (roleDesc.equals(Constants.ROLE_RECEPTIONIST)) {
            return new Receptionist(ID, name, email, address, phoneNumber, citizenCardNumber);
        } else
            return new Coordinator(ID, name, email, address, phoneNumber, citizenCardNumber);
    }

    /**
     * Method to verify if the employee already exists on the list of employees
     *
     * @param employee
     * @return returns true if exist and false if doesn't exist
     */
    public boolean validateEmployee(Employee employee) {
        if (employee == null)
            return false;
        return !this.employeeList.contains(employee);
        /*for (Employee employee1 : employeeList) {
            if ( employee1.equals(employee) ) {
=======

        for (Employee employee1 : employeeList) {
            if (!employee1.equals(employee)) {

>>>>>>> ceaee854e2f7fb7e293a650ec18bb4b9211414cc
                return true;
            }
        }
         */
    }

    /**
     * Method that save the employee
     *
     * @param employee
     * @return
     */
    public boolean saveEmployee(Employee employee) {
 ;
        if (!validateEmployee(employee))
            return false;
        return this.employeeList.add(employee);

    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }



}





