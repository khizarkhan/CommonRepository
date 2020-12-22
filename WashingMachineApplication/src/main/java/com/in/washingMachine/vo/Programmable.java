package com.in.washingMachine.vo;

import java.util.List;

import com.in.washingMachine.vo.programe.WashingMachineFunction;

/**
 * Created by khizar khan
 */
public interface Programmable {
    List<WashingMachineFunction> getPrograms();
}
