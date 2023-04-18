package app.domain.shared;

import app.domain.model.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_NURSE = "NURSE";
    public static final String ROLE_COORDINATOR = "COORDINATOR";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_SNS_USER = "SNS USER";

    public static final String FILE = "SnsUserInformation\\notification.txt";

    public static final int PASSWORD_LENGTH = 7;

    public static final int PHONE_NUMBER_DIGITS = 9;
    public static final int CC_LENGTH = 8;
    public static final int SNS_LENGHT = 9;
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 100;

    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";

    public static final int CODE_DEFAULT = 1111;

    public static final String DESIGNATION_DEFAULT="No designation";

    public static final String WHO_ID_DEFAULT = "No who id defined";

    public static final String NAME_DEFAULT = "NOT DEFINED";
    public  static final String EMAIL_DEFAULT = "notdefined@company.pt";
    public static final WorkingHour HOUR_DEFAULT = new WorkingHour(0,0);
    public static final String WEBSITE_DEFAULT= "www.notdefined.pt";
    public static final  String ROLE_DEFAULT = "No role";
    public static final int ROLEID_DEFAULT=99;
    public static final Address ADDRESS_DEFAULT = new Address("street",1,"city");
    public static final int PHONE_NUMBER_DEFAULT=111111111;
    public static final int CITIZEN_CARD_DEFAULT=11111111;
    public static final int MAXIMUM_PER_SLOT_DEFAULT=1;
    public static final int SLOT_DEFAULT=1;
public static final int ID_DEFAULT = 0;

    public static final Employee COORDINATOR_DEFAULT = new Coordinator(ID_DEFAULT,NAME_DEFAULT, EMAIL_DEFAULT, ADDRESS_DEFAULT,PHONE_NUMBER_DEFAULT,CITIZEN_CARD_DEFAULT);
    public static final VaccineType VACCINE_TYPE_DEFAULT = new VaccineType(9999, "noDesignation", "noWHold");
}
