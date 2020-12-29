package com.in.washingMachine.rest.serviceTest;

import static org.mockito.BDDMockito.given;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in.washingMachine.service.WashingMachineService;
import com.in.washingMachine.vo.WashingMachine;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WashingMachineServiceImplTest.class})
public class WashingMachineServiceImplTest {

	
	@MockBean
	WashingMachineService washingMachineService;
	
	
	
	@Test
	public void startMachine() throws InterruptedException {
		given(washingMachineService.startWashingMachine()).willReturn("started");
		String status = washingMachineService.startWashingMachine();
		Assert.assertEquals(status,"started");
		  
	}
	
	@Test
	public void stopMachineTest(){
		given(washingMachineService.stopWashingMachine()).willReturn("stoped");
		String status = washingMachineService.stopWashingMachine();
		Assert.assertEquals(status,"stoped");
		  
	}
	
	
	@Test
	public void getStatusTest(){
		given(washingMachineService.getWashingMachineStatus()).willReturn("stoped");
		String status = washingMachineService.getWashingMachineStatus();
		Assert.assertEquals(status,"stoped");
		  
	}
	
	@Test
	public void createWashingMachineTest(){
		WashingMachine washingMachine = new WashingMachine("Whirlpool", "started", "200");
		given(washingMachineService.createWashingMachine(washingMachine)).willReturn(washingMachine);
		Assert.assertEquals(washingMachine,washingMachineService.createWashingMachine(washingMachine));
		  
	}
	
	
}
