package app.ui.console;


import app.domain.model.VaccinationCenter;
import app.domain.model.Employee;
import app.domain.model.VaccinationCenter;


import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register an employee ", new EmployeeUI()));
        options.add(new MenuItem("List employees with a given role ", new ListEmployeesUI()));
        options.add(new MenuItem("Create a new Vaccine ", new SpecifyNewVaccineUI()));
        options.add(new MenuItem("Register a new vaccination center", new RegisterVaccinationCenterUI()));
        options.add(new MenuItem("Specify a new vaccine type", new SpecifyNewVaccineTypeUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );



    }
}
