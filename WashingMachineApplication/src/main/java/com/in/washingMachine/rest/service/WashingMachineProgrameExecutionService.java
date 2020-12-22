package com.in.washingMachine.rest.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.in.washingMachine.process.Drying;
import com.in.washingMachine.process.Squeaking;
import com.in.washingMachine.process.Washing;
import com.in.washingMachine.util.MachineState;
import com.in.washingMachine.vo.programe.WashingMachineFunction;


/**
 * @author khizar khan
 *
 */
@Service
@Scope("singleton")
public class WashingMachineProgrameExecutionService {
    private final Logger LOGGER = LoggerFactory.getLogger(WashingMachineProgrameExecutionService.class);

   
    private WashingMachineFunction program;
    private StringBuffer status = new StringBuffer(MachineState.WAITING.toString());
    private Date operationEnd;
    private Date programEnd;
    private Boolean isRunning = new Boolean(false);
   
    

    public void startProgram() throws InterruptedException {
        
            if (!isRunning) {
                isRunning=true;
                status = new StringBuffer(MachineState.RUNNING.toString());

                Washing washing = program.getWashing();
                Squeaking squeaking = program.getSqueaking();
                Drying drying = program.getDrying();

                programEnd = new Date(System.currentTimeMillis() +
                        washing.getDuration() +
                        squeaking.getDuration() +
                        drying.getDuration()
                );

               
        }
    }

    public void stopProgram() {
        
           if (isRunning) {
                isRunning=false;
                status = new StringBuffer(MachineState.STOPPED.toString());
            }
        } 
    

    public void setProgram(WashingMachineFunction washingMachineFunction) {
        this.program = washingMachineFunction;
    }

    public String getStatus() {
       

        
            if (isRunning && operationEnd != null && programEnd != null) {

                return status.toString() + getTimeEstimationsSting();
            }

            return status.toString();
        
    }

    private String getTimeEstimationsSting() {
        Date now = new Date();

        return ",\n\t\toperation estimation: " + getMinutesAndSecondsString(now, operationEnd) +
                ",\n\t\tprogram estimation: " + getMinutesAndSecondsString(now, programEnd);
    }

    private String getMinutesAndSecondsString(Date now, Date end) {
        long l = end.getTime() - now.getTime();
        if (l <= 0) return "00:00";

        long minutes = TimeUnit.MILLISECONDS.toMinutes(l);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(l);
        return minutes + ":" + seconds;
    }

	
}
