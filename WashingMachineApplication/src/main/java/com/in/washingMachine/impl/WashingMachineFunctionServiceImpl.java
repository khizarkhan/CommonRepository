package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.repository.ProgramRepository;
import com.in.washingMachine.service.WashingMachineFunctionService;
import com.in.washingMachine.vo.programe.WashingMachineFunction;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineFunctionServiceImpl implements WashingMachineFunctionService {
    private final ProgramRepository programRepository;

    @Autowired
    public WashingMachineFunctionServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public WashingMachineFunction save(WashingMachineFunction program) {
        return programRepository.save(program);
    }
}
