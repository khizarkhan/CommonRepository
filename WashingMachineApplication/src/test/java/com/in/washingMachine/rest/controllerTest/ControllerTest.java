package com.in.washingMachine.rest.controllerTest;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.washingMachine.controller.Controller;
import com.in.washingMachine.service.WashingMachineService;
import com.in.washingMachine.vo.WashingMachine;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WashingMachineService washingMachineService;

	@InjectMocks
	private WashingMachine washingMachine;

	@Test
	public void testCreateWashinhMachine() throws Exception {
		String urlTemplate = "/rest/creteWashingMachine/";
		WashingMachine washingMacine = new WashingMachine("Electroleac", "Started", "200");
		given(washingMachineService.createWashingMachine(washingMacine)).willReturn(washingMacine);
		mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new WashingMachine("Electroleac", "Started", "200")))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	public void testGetCurrentStatusOfWashingMachine() throws Exception {

		String urlTemplate = "/rest/washingMachineState/";
		mockMvc.perform(MockMvcRequestBuilders.get(urlTemplate).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineService, VerificationModeFactory.times(1)).getWashingMachineStatus();
	}

	@Test
	public void testStartTheWashingMachine() throws Exception {
		String urlTemplate = "/rest/startWashingMachine/";
		mockMvc.perform(MockMvcRequestBuilders.put(urlTemplate).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineService, VerificationModeFactory.times(1)).startWashingMachine();
	}

	@Test
	public void testStopTheWashingMachine() throws Exception {
		String urlTemplate = "/rest/stopWashingMachine/";
		mockMvc.perform(MockMvcRequestBuilders.put(urlTemplate).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		verify(washingMachineService, VerificationModeFactory.times(1)).stopWashingMachine();
	}

	public static byte[] asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsBytes(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
