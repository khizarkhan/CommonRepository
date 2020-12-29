package com.in.washingMachine.rest.repository.test;



import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in.washingMachine.repository.WashingMachineRepository;
import com.in.washingMachine.vo.WashingMachine;



@RunWith(SpringRunner.class)
@SpringBootTest
public class WashingMachineRepositoryTest {

	@MockBean
	WashingMachineRepository rpository;
	
	
	WashingMachine washingMachine = null;
	
	@Before
	public void setUp() {
		washingMachine= new WashingMachine("Test", "started", "800");
	}
	
	@Test
	public void savetest() {
		given(rpository.save(washingMachine)).willReturn(washingMachine);
		WashingMachine washingMachineResponse = rpository.save(washingMachine);
		Assert.assertEquals(washingMachineResponse,washingMachine);
	}
	
	@Test
	public void findtest() {
		given(rpository.findById(1)).willReturn(washingMachine);
		WashingMachine washingMachineResponse = rpository.findById(1);
		Assert.assertEquals(washingMachineResponse,washingMachine);
	}
	
	
	@Test
	public void findAll() {
		List<WashingMachine> washingMachineList = new ArrayList<>();
		washingMachineList.add(washingMachine);
		given(rpository.findAll()).willReturn(washingMachineList);
		List<WashingMachine> washingMachineResponse = rpository.findAll();
		Assert.assertEquals(washingMachineResponse,washingMachineList);
	}
	
	

}
