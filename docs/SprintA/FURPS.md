# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_



| Function         | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
|------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| __Security__     | All those who wish to use the application must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits<br/> <br/> Restriction of data: <br>•	The SNS user to use the application must be authenticated with an SNS user number and password and access user personal data. <br/>•	The nurse can check the list of SNS users that are present in the vaccination center and has access to some SNS user's data such as a name, health condition and a type of the vaccine to be administered. <br/>•	The receptionist can only make a list of SNS users who are ready to take a vaccine introducing their SNS user numbers and check if the user has a marked date for their vaccination <br/>•	The administrator is responsible for configuring and managing the core information required for this application to be operated daily by SNS users, nurses, receptionists, etc.<br/> • The system should log the SNS user out if they are no longer using the app. |
| __Reporting__    | The center coordinator drives the vaccination process, sees statistics and graphs, generates reports                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |     |
| __Help__         | The user Manual must be delivered with the application.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| __Printing__     | To SNS user: <br/>•	Shows the availability status of the day chosen by the user <br/>•	Informs the user about vaccination place, day, and time<br/>•	Sends SMS with the information about the appointment.<br/>•	Sends SMS or Email notifying the user that his/her recovery period has ended.<br/>•	Prints the EU Digital certificate.<br/> <br/>To receptionist:<br/> •	System shows the date vaccine is scheduled for, name and number of the user.<br/> •	System shows a list of users waiting to take the vaccine and information about the waiting room   <br/><br/>To nurse: <br/> •	The system shows the date vaccine is scheduled for, the name and number of the user, their health condition, vaccination history and the scheduled type of the vaccine.                                                                                                                                                                                                                                                              |
| __Localization__ | The application must support, at least, the Portuguese and the English languages. Be accessible in all the country.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
	


## Usability 

###Adequacy of the interface for different types of users

-The application will be used by nurses, SNS users, receptionist, coordinator centers and administrative.

## Performance



## Supportability


## +

### Design Constraints


-The application is developed in Java Language 


### Implementation Constraints

-Tests should be implemented using the Junit  5 framework.
-The JaCoCo plugin should be used to generate the coverage report.


### Interface Constraints

-The application Graphical Interface is to be developed in JavaFX 11



### Physical Constraints

