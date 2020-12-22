package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.repository.WashingMachineRepository;
import com.in.washingMachine.service.WashingMachineWashService;
import com.in.washingMachine.vo.WashingMachine;

import java.util.List;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineWashServiceImpl implements WashingMachineWashService {
    private final WashingMachineRepository washingMachineRepository;

    @Autowired
    public WashingMachineWashServiceImpl(WashingMachineRepository washingMachineRepository) {
        this.washingMachineRepository = washingMachineRepository;
    }

    @Override
    public WashingMachine getFirst() {
        List<WashingMachine> all = washingMachineRepository.findAll();
        return all.size() == 0 ? null : all.get(0);
    }

    @Override
    public WashingMachine save(WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }
}
