package com.in.washingMachine.service;

import com.in.washingMachine.vo.WashingMachine;

public interface WashingMachineService {
	public WashingMachine createWashingMachine(WashingMachine washingMachine);
	public String startWashingMachine();
	public String stopWashingMachine();
	public String getWashingMachineStatus();

}
