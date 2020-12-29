package com.in.washingMachine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.washingMachine.service.WashingMachineService;
import com.in.washingMachine.vo.WashingMachine;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Created by khizar khan
 */
@RestController
@RequestMapping(value = "/rest")
@Api(value = "Washing Machine REST Control", description = "Operations pertaining to Washing Machine")
public class Controller {
    private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private  WashingMachineService washingMachineService;
   
   
    @ApiOperation(value = "View appliance state", response = String.class)
    @RequestMapping(value = "/washingMachineState", method = RequestMethod.GET)
    public String getCurrentStatusOfWashingMachine() {
        LOGGER.info("Request to get washingMachineState");
        return washingMachineService.getWashingMachineStatus();
    }

    
    
    @ApiOperation(value = "Create Washing Machine", response = String.class)
    @RequestMapping(value = "/creteWashingMachine", method = RequestMethod.POST)
    public WashingMachine startTheWashingMachine(@RequestBody WashingMachine washingMachine) throws InterruptedException {
      return washingMachineService.createWashingMachine(washingMachine);
        }

    @ApiOperation(value = "Stop Washing Machine", response = String.class)
    @RequestMapping(value = "/stopWashingMachine", method = RequestMethod.PUT)
    public String stopTheWashingMachine() {
    	washingMachineService.stopWashingMachine();
        return "Stopped";
    }
    
    @ApiOperation(value = "Start Washing Machine", response = String.class)
    @RequestMapping(value = "/startWashingMachine", method = RequestMethod.PUT)
    public String startTheWashingMachine() {
    	washingMachineService.startWashingMachine();
        return "Started";
    }

  

 
}
