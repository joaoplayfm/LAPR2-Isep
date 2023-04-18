package app.domain.model;

import org.apache.commons.lang3.StringUtils;
import pt.isep.lei.esoft.auth.AuthFacade;

import app.domain.shared.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Class that represents an Sns User
 */
public class SnsUser {

    private String phoneNumber;
    private String snsNumber;
    private String citizenNumber;
    private Date birthDate;
    private String email;
    private String name;
    private Address address;
    private String sex;
    private int age;

    public SnsUser() {

    }

    /**
     * Constructor of the Sns User specifying the sex of the Sns User, it calls methods in order to validate the parameters
     * @param phoneNumber unique phone number that belongs to Sns User
     * @param snsNumber sns number of the Sns User
     * @param citizenNumber citizen card number of the Sns User
     * @param birthDate birthay date of the Sns User
     * @param email email of the Sns User
     * @param name name of the Sns User
     * @param address address of the Sns User
     * @param sex sex of the Sns User
     */
    public SnsUser(String phoneNumber, String snsNumber, String citizenNumber, java.util.Date birthDate, String email, String name, Address address, char sex, int age) {
        setAddress(address);
        setBirthDate(birthDate, setAge(birthDate));
        setName(name);
        setCitizenNumber(Integer.parseInt(citizenNumber));
        setEmail(email);
        setPhoneNumber(Integer.parseInt(phoneNumber));
        setSnsNumber(Integer.parseInt(snsNumber));

        this.phoneNumber = phoneNumber;
        this.snsNumber = snsNumber;
        this.citizenNumber = citizenNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.name = name;
        this.address = address;
        this.age = age;
        if (sex == 'M') {
            this.sex = "Male";
        } else {
            if (sex == 'F') {
                this.sex = "Female";
            } else {
                throw new IllegalArgumentException("Sex must be 'M' or 'F' ");
            }
        }

    }

    public void setName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("The name can't be null or empty!");
            } else {
                this.name = name;
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());

        }
    }

    public void setEmail(String email) {
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Code cannot be blank.");

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (!pat.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid Email.");
        }
    }

    public void setAddress(Address address) {
        try {
            this.address = address;
        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());
        }

    }

    public void setPhoneNumber(int phoneNumber) {
        try {
            if (phoneNumber < 100000000 || phoneNumber > 999999999) {
                throw new IllegalArgumentException("The phone number need to have 9 digits!");
            }
            this.phoneNumber = String.valueOf(phoneNumber);
        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());

        }
    }

    public void setCitizenNumber(int citizenNumber) {
        try {
            if (citizenNumber < 10000000 || citizenNumber > 99999999) {
                throw new IllegalArgumentException("The Citizen Number need to have 8 digits!");
            }
            this.citizenNumber = String.valueOf(citizenNumber);

        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());

        }
    }

    public void setSnsNumber(int snsNumber) {
        try {
            if (snsNumber < 100000000 || snsNumber > 999999999) {
                throw new IllegalArgumentException("The Sns Number need to have 9 digits!");
            }
            this.snsNumber = String.valueOf(snsNumber);

        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());

        }
    }

    /**
     * Receives the birthdate as an instance of Date class, converts the instance for an instance of LocalDate and uses the Class Period to calculate the time difference between the today's date and the birthdate received by parameter
     *
     * @param birthDate Date instance to calculate time until today's Date
     * @return integer that represents the time difference in years
     */
    public int setAge(Date birthDate) {
        LocalDate date = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Transition from object Date to object LocalDate retrieved from https://www.baeldung.com/java-date-to-localdate-and-localdatetime
        return Period.between(date, LocalDate.now()).getYears();
    }


    public void setBirthDate(Date birthDate, int age){
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth Date cannot be null");
        }
        if (age < Constants.MIN_AGE) {
            throw new IllegalArgumentException("Birth Date cannot be in the future");
        }
        if (age > Constants.MAX_AGE) {
            throw new IllegalArgumentException("Age cannot be more than 100");
        }
    }

    /**
     * @return a string with the format = "SNS USER--> " + "phoneNumber= " + phoneNumber + ", cc= " + citizenNumber + ", sns= " + snsNumber + ", address= " + address + ", birthDate= " + birthDate + ", sex= " + sex + ", email= " + email + ", name= " + name;
     */
    public String toString() {
       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
       String date = dateFormat.format(this.birthDate.getTime());

        return "\n|SNS USER| \n" +
                "phoneNumber --> " + phoneNumber + "\ncc--> " + citizenNumber + "\nsns--> " + snsNumber + "\naddress--> " + address + "\nbirthDate--> " + birthDate + "\nsex--> " + sex + "\nemail--> " + email + "\nname--> " + name;
    }

    /**
     * @return String representing the phone number of the sns user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return String representing the email of the sns user
     */
        public String getEmail() {
            return email;
        }

    /**
     * @return string that represents sns number of the sns user
     */
        public String getSnsNumber(){
            return snsNumber;
        }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }


    public int getAge() {
        return age;
    }

    /**
     * Adds a new user to the system with the role of the client using the getPassword method to create the user's password
     *
     * @return a boolean value representing the success of the operation
     */
            public boolean addUser(Company company) {
                AuthFacade auth = company.getAuthFacade();
                String password = GeneratePassword.getPassword();
                boolean success = auth.addUserWithRole(this.name, this.email, password, Constants.ROLE_SNS_USER);
                if (success) {
                    Email.sendPasswordNotification(this.name, this.email, password);

                }
                return success;
            }

    }

