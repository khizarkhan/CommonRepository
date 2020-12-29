package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.repository.WashingMachineRepository;
import com.in.washingMachine.service.WashingMachineService;
import com.in.washingMachine.vo.WashingMachine;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineServiceImpl implements WashingMachineService {
   
	@Autowired
	WashingMachineRepository wasingmachineRepo;

	@Override
	public String startWashingMachine() {
		WashingMachine washingMachine=getWashigMachine();
		washingMachine.setState("started");
		return wasingmachineRepo.save(washingMachine).getState();
	}

	private WashingMachine getWashigMachine() {
		return wasingmachineRepo.findById(1);
		
	}

	@Override
	public String stopWashingMachine() {
		WashingMachine washingMachine=getWashigMachine();
		washingMachine.setState("stoped");
		return wasingmachineRepo.save(washingMachine).getState();
	}

	@Override
	public String getWashingMachineStatus() {
		WashingMachine washingMachine=getWashigMachine();
		return washingMachine.getState();
	}

	@Override
	public WashingMachine createWashingMachine(WashingMachine washingMachine) {
		return wasingmachineRepo.save(washingMachine);
		
	}

   
}
