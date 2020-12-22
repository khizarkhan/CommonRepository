package com.in.washingMachine.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.washingMachine.rest.service.WashingMachineInitilizationService;
import com.in.washingMachine.rest.service.WashingMachineProgrameExecutionService;
import com.in.washingMachine.vo.programe.WashingMachineFunction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Created by khizar khan
 */
@RestController
@RequestMapping(value = "/rest")
@Api(value = "Washing Machine REST Control", description = "Operations to controll the washing Machine")
public class Controller {
    private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private  WashingMachineProgrameExecutionService washingMachineExecuterService;
   
   @Autowired
   private WashingMachineInitilizationService washingMachineInitilizationService;

	
    
    @ApiOperation(value = "Washing Machine Programe setup", response = String.class)
    @RequestMapping(value = "/program/{number}", method = RequestMethod.GET)
    public String choseTheWashingMachineFunctions(@PathVariable final Integer number) {

        try {
            List<WashingMachineFunction> washingMachineFunctions = washingMachineInitilizationService.getWashingMachine().getPrograms();
            washingMachineExecuterService.setProgram(washingMachineFunctions.get(number));

        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("No such Function is available");
        }

        return "Washing Machine Function " + number + "is set";
    }

    @ApiOperation(value = "View Washing Machine Functions", response = String.class)
    @RequestMapping(value = "/machineFunctions", method = RequestMethod.GET)
    public String getAllAvailableFunctionsOfMachine() {
        List<WashingMachineFunction> programs = washingMachineInitilizationService.getWashingMachine().getPrograms();

        if (programs.isEmpty()) return "No Functions set";

        StringBuilder programsDescription = new StringBuilder();
        int index = 0;

        for (WashingMachineFunction program : programs) {
            programsDescription
                    .append("\n").append(index++).append(": ")
                    .append(program.toString());
        }

        return programsDescription.toString();
    }
    

    @ApiOperation(value = "View appliance state", response = String.class)
    @RequestMapping(value = "/washingMachineState", method = RequestMethod.GET)
    public String getCurrentStatusOfWashingMachine() {
        LOGGER.info("Request to get washingMachineState");
        return washingMachineExecuterService.getStatus();
    }

    @ApiOperation(value = "Start Washing Machine", response = String.class)
    @RequestMapping(value = "/startWashingMachine", method = RequestMethod.GET)
    public String startTheWashingMachine() throws InterruptedException {
        try {
            washingMachineExecuterService.startProgram();
        } catch (NullPointerException e) {
            return "Washing machine function set up";
        }
        return "Started";
    }

    @ApiOperation(value = "Stop Washing Machine", response = String.class)
    @RequestMapping(value = "/stopWashingMachine", method = RequestMethod.GET)
    public String stopTheWashingMachine() {
        washingMachineExecuterService.stopProgram();
        return "Stopped";
    }

  

 
}
