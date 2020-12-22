The task is design the washing machine application.Application has the API to start the machine stop the machine and set the machine programes.
Application is using the spring boot to build the API, and Mockito for Junit.




###How to install and run

`$ mvn spring-boot:run`


### Swegger API Details

`http://localhost:8080/swagger-ui.html#/`


`GET /rest/program/{number}` - Set the washing machine programe

`GET /rest/machineFunctions` - View all appliance programs: shows all programs descriptions

`GET /rest/startWashingMachine` - Start the washing machine

`GET /rest/washingMachineState` - Show the state of washing Machine

`GET /rest/stopWashingMachine` - Stop the washing machine


