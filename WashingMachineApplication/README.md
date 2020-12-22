### Requirment
Write code  to controll the WashingMachine

### Implementation
Application is using the spring boot servises to building the applications, there are mainly 5 servises start,stop,state, functions, set programe.
start service is being used to start the washing machine it calles the startProgram() method to execute the task.
Stop Service is being used to stop the washing machine it calles the stopProgram() method to execute the task.
State  Service is being used to stop the washing machine it calles the getStatus() method to execute the task.
Set Programe Service is being used to set the  the washing machine  programe it calles the setProgram method to execute the task.


## Technology used
Application uses the mvn to build the project.
Application is using JPA for the persistance layer.
Application is using the Spring boot to build the servises.
Application is using mockito to test the application.
Application is using the h2 db for database.
log4j for logging the log.



### How to import and run in eclipse

1) Open Eclipse
2) Click File > Import
3) Type Maven in the search box under Select an import source:
4) Select Existing Maven Projects
5) Click Next
6) Click Browse and select the folder that is the root of the Maven project (probably contains the pom.xml file)
7) Click Next
8) Click Finish
9) Right click on project go to Run As, select mvn install.
10)Right click on WashingMachineBootStarp.java Select Run as java programe.

### How to run and install using spring CLI.

`$ mvn spring-boot:run`


### Swegger API Details

`http://localhost:8080/swagger-ui.html#/`


`GET /rest/program/{number}` - Set the washing machine programe

`GET /rest/machineFunctions` - View all appliance programs: shows all programs descriptions

`GET /rest/startWashingMachine` - Start the washing machine

`GET /rest/washingMachineState` - Show the state of washing Machine

`GET /rest/stopWashingMachine` - Stop the washing machine


