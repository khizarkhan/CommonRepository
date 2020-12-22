package com.in.washingMachine.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.process.Drying;
import com.in.washingMachine.process.Squeaking;
import com.in.washingMachine.process.Washing;
import com.in.washingMachine.service.*;
import com.in.washingMachine.vo.WashingMachine;
import com.in.washingMachine.vo.programe.WashingMachineFunction;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineInitilizationService {
    private final Logger LOGGER = LoggerFactory.getLogger(WashingMachineInitilizationService.class);

    private final WashingMachineWashService washingMachineWashService;
    private final WashingMachineFunctionService washingMachineFunctionService;
    private final WashingService washingService;
    private final WashingMachineSqueakingService washingMachineSqueakingService;
    private final WashingMachineDryingService washingMachineDryingService;

    private WashingMachine washingMachine;

    @Autowired
    public WashingMachineInitilizationService(WashingMachineWashService washingMachineService, WashingMachineFunctionService programService, WashingService washingService, WashingMachineSqueakingService squeakingService, WashingMachineDryingService dryingService) {
        this.washingMachineWashService = washingMachineService;
        this.washingMachineFunctionService = programService;
        this.washingService = washingService;
        this.washingMachineSqueakingService = squeakingService;
        this.washingMachineDryingService = dryingService;
    }

    @PostConstruct
    public void init(){
        LOGGER.info("Washing Machine initializing...");

        washingMachine = washingMachineWashService.getFirst();
        if (washingMachine == null) {
            LOGGER.warn("Washing Machine not found in database. Init new...");

            washingMachine = newInstance();
        }
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }

    private WashingMachine newInstance() {
        WashingMachine wm = new WashingMachine();
        wm.setModel("ABC22133");
        wm.setSerial("SN-1234567890-123");
        wm.setPrograms(Arrays.asList(
                washingMachineFunctionService.save(cottonProgram()),
                washingMachineFunctionService.save(colorProgram()),
                washingMachineFunctionService.save(syntheticProgram())
        ));

        return washingMachineWashService.save(wm);
    }

    private WashingMachineFunction cottonProgram() {
        WashingMachineFunction cotton = new WashingMachineFunction();
        cotton.setWashing(washingService.save(new Washing(250L, 800, 3000)));
        cotton.setSqueaking(washingMachineSqueakingService.save(new Squeaking(90L, -1, 20)));
        cotton.setDrying(washingMachineDryingService.save(new Drying(90000L, 1000, 40)));

        return cotton;
    }

    private WashingMachineFunction colorProgram() {
        WashingMachineFunction color = new WashingMachineFunction();
        color.setWashing(washingService.save(new Washing(2L, 400, 3000)));
        color.setSqueaking(washingMachineSqueakingService.save(new Squeaking(50000L, -100, 800000)));
        color.setDrying(washingMachineDryingService.save(new Drying(10L, 4560, 1000)));

        return color;
    }

    private WashingMachineFunction syntheticProgram() {
        WashingMachineFunction synthetic = new WashingMachineFunction();
        synthetic.setWashing(washingService.save(new Washing(20000L, 60, 30)));
        synthetic.setSqueaking(washingMachineSqueakingService.save(new Squeaking(4000L, -1, 1000)));
        synthetic.setDrying(washingMachineDryingService.save(new Drying(8000L, 40, 10)));

        return synthetic;
    }
}
