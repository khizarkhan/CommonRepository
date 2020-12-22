package com.in.washingMachine.rest.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in.washingMachine.rest.service.WashingMachineProgrameExecutionService;
import com.in.washingMachine.vo.programe.WashingMachineFunction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WashingMachineProgrameExecutionService.class})
public class WashingMachineProgrameExecutionServiceTest {

	WashingMachineFunction washingMachineFunction =null;
	@MockBean
	WashingMachineProgrameExecutionService washingMachineProgrameExecutionService;
	
	@Before
	public void setUp() {
		washingMachineFunction = new WashingMachineFunction();
	  }
	
	@Test
	public void startMachine() throws InterruptedException {
		Mockito.doNothing().when(washingMachineProgrameExecutionService).startProgram();
		washingMachineProgrameExecutionService.startProgram();
		  
	}
	
	@Test
	public void stopMachine() throws InterruptedException {
		Mockito.doNothing().when(washingMachineProgrameExecutionService).stopProgram();;
		washingMachineProgrameExecutionService.stopProgram();
		  
	}
	
	@Test
	public void getStatus() throws InterruptedException {
		given(washingMachineProgrameExecutionService.getStatus()).willReturn("Started");
		String status = washingMachineProgrameExecutionService.getStatus();
		assertNotNull(status);
		verify(washingMachineProgrameExecutionService, VerificationModeFactory
                .times(1))
                .getStatus();
		  
	}
	
	@Test
	public void setPrograme() throws InterruptedException {
		Mockito.doNothing().when(washingMachineProgrameExecutionService).stopProgram();
		washingMachineProgrameExecutionService.setProgram(washingMachineFunction);
		  
	}
	
	
}
