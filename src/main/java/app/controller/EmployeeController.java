package app.controller;

import app.domain.model.*;
import app.domain.store.EmployeeStore;

import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.model.UserRole;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EmployeeController {


    private Employee employee;
    private EmployeeStore employeestore = new EmployeeStore();
    private UserStore userStore = new UserStore();
    private App app;
    private Company company;
    private EmployeeStore employeeStore;
    private UserRole roleDes;

    public EmployeeController (){
        this(App.getInstance().getCompany());
    }


    public EmployeeController(Company company) {
        this.company=company;
        this.employee=null;
    }

    /**
     * Method that register an employee
     * @param role
     * @param ID
     * @param name
     * @param email
     * @param address
     * @param phoneNumber
     * @param citizenCardNumber
     * @return
     */
    public boolean registerEmployee(String role, int ID, String name,String email, Address address, int phoneNumber, int citizenCardNumber) {
        this.employee = this.company.getEmployeeStore().createEmployee(role, ID, name, email, address, phoneNumber, citizenCardNumber);

        return this.company.getEmployeeStore().validateEmployee(employee);
    }

    
    /**
     * Method that save an employee
     //* @param role
     //* @param name
     //* @param email
     * @return
     */
    public boolean saveEmployee(String name, String email, String role) {
        String password = GeneratePassword.getPassword();
        System.out.println("Password:"+ password);
        this.company.getAuthFacade().addUserWithRole(name, email, password, role);
        return this.company.getEmployeeStore().saveEmployee(employee);

    }


    /**
     * Method that returns the role of the employee by his ID
     * @param roleID
     * @return returns the role of the employee
     */
    public Optional<UserRole> getId(String roleID) {
        Optional<UserRole> roleId = company.getrStore().getById(roleID);
        return roleId;
    }

    /**
     * @param role role of employees
     * @return list of employees with a given role
     */
    public ArrayList<Employee> getListOfEmployeesWithRoleC (String role){
        return company.getListOfEmployeesWithRole(role);
    }

    /**
     * @return employee
     */
    public Employee getEmployee() {
        return this.employee;
    }

    public List <Employee> getEmployeeList() {
        return this.company.getEmployeeStore().getEmployeeList();
    }

}
