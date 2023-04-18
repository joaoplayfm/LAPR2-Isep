package app.ui.console;

import app.controller.EmployeeController;
import app.domain.model.Employee;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;


/**
 * list the employees with a given role
 */
public class ListEmployeesUI implements Runnable{

    private static ArrayList<Employee> arrayToShow = new ArrayList<>();

    public void run(){

        EmployeeController employeeController = new EmployeeController();

        String id = Utils.readLineFromConsole("Enter the role of the employees that you want to list\n" +
                "role: receptionist\n" +
                "role: nurse\n" +
                "role: coordinator\n" +
                "role: administrator\n");

        if (!id.equalsIgnoreCase(Constants.ROLE_RECEPTIONIST) && !id.equalsIgnoreCase(Constants.ROLE_ADMIN) && !id.equalsIgnoreCase(Constants.ROLE_NURSE) && !id.equalsIgnoreCase(Constants.ROLE_COORDINATOR))
            throw new IllegalArgumentException("You should introduce one of the roles above");

            arrayToShow = employeeController.getListOfEmployeesWithRoleC(id.toUpperCase(Locale.ROOT));

        if (arrayToShow.isEmpty()) {
            throw new IllegalArgumentException("We cannot list employees that don´t exist");
        }

        System.out.println("List of employees with a role "+id+":\n");
        for (Employee e : arrayToShow){
            System.out.println(e.toString());
        }



    }

}
