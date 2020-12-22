package com.in.washingMachine.service;

import com.in.washingMachine.vo.WashingMachine;

/**
 * Created by khizar khan
 */
public interface WashingMachineWashService {
    WashingMachine getFirst();
    WashingMachine save(WashingMachine washingMachine);
}
