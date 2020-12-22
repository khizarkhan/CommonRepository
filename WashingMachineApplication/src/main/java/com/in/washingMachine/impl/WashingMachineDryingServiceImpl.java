package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.process.Drying;
import com.in.washingMachine.repository.DryingRepository;
import com.in.washingMachine.service.WashingMachineDryingService;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineDryingServiceImpl implements WashingMachineDryingService {
    private final DryingRepository dryingRepository;

    @Autowired
    public WashingMachineDryingServiceImpl(DryingRepository dryingRepository) {
        this.dryingRepository = dryingRepository;
    }

    @Override
    public Drying save(Drying drying) {
        return dryingRepository.save(drying);
    }
}
