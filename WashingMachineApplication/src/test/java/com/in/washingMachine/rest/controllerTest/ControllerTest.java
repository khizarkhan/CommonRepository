package com.in.washingMachine.rest.controllerTest;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;
import com.in.washingMachine.controller.Controller;
import com.in.washingMachine.process.Drying;
import com.in.washingMachine.process.Squeaking;
import com.in.washingMachine.process.Washing;
import com.in.washingMachine.rest.service.WashingMachineInitilizationService;
import com.in.washingMachine.rest.service.WashingMachineProgrameExecutionService;
import com.in.washingMachine.service.WashingMachineDryingService;
import com.in.washingMachine.service.WashingMachineFunctionService;
import com.in.washingMachine.service.WashingMachineSqueakingService;
import com.in.washingMachine.service.WashingMachineWashService;
import com.in.washingMachine.vo.WashingMachine;
import com.in.washingMachine.vo.programe.WashingMachineFunction;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WashingMachineProgrameExecutionService washingMachineExecuterService;

	@MockBean
	private WashingMachineInitilizationService washingMachineInitilizationService;
	
	
	@InjectMocks
	private WashingMachine washingMachine;
	

	   
	@Before
	public void setUp() {
		WashingMachineFunction washingMachineFunction = new WashingMachineFunction();
	    List<WashingMachineFunction> programs = getWashingMachineFunction(washingMachineFunction);
		given(washingMachineInitilizationService.getWashingMachine()).willReturn(washingMachine);
		washingMachine.setPrograms(programs);
	}
	

	private List<WashingMachineFunction> getWashingMachineFunction(WashingMachineFunction washingMachineFunction) {
		List<WashingMachineFunction> programs = new ArrayList<>();
		
		washingMachineFunction.setDrying(new Drying(10000L, 40, 10));
		washingMachineFunction.setSqueaking(new Squeaking(5000L, -1, 800));
		washingMachineFunction.setWashing(new Washing(20000L, 60, 30));
		programs.add(washingMachineFunction);
		return programs;
	}


	@Test
	public void testChoseTheWashingMachineFunctions() throws Exception {
		String urlTemplate = "/rest/program/"+0;
		mockMvc.perform(MockMvcRequestBuilders
				.get(urlTemplate)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineExecuterService, VerificationModeFactory.times(1)).setProgram(washingMachineInitilizationService.getWashingMachine().getPrograms().get(0));
		
	}

	@Test
	public void testGetCurrentStatusOfWashingMachine() throws Exception {
		
		String urlTemplate = "/rest/washingMachineState/";
		mockMvc.perform(MockMvcRequestBuilders
				.get(urlTemplate)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineExecuterService, VerificationModeFactory.times(1)).getStatus();
	}

	@Test
	public void testStartTheWashingMachine() throws Exception {
		String urlTemplate = "/rest/startWashingMachine/";
		mockMvc.perform(MockMvcRequestBuilders
				.get(urlTemplate)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineExecuterService, VerificationModeFactory.times(1)).startProgram();
	}

	@Test
	public void testStopTheWashingMachine() throws Exception {
		String urlTemplate = "/rest/stopWashingMachine/";
		mockMvc.perform(MockMvcRequestBuilders
				.get(urlTemplate)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineExecuterService, VerificationModeFactory.times(1)).stopProgram();
	}

}
