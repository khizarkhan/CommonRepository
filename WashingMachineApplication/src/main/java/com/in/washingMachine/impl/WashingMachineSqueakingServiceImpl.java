package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.process.Squeaking;
import com.in.washingMachine.repository.SqueakingRepository;
import com.in.washingMachine.service.WashingMachineSqueakingService;

/**
 * Created by khizar khan
 */
@Service
public class WashingMachineSqueakingServiceImpl implements WashingMachineSqueakingService {
    private final SqueakingRepository squeakingRepository;

    @Autowired
    public WashingMachineSqueakingServiceImpl(SqueakingRepository squeakingRepository) {
        this.squeakingRepository = squeakingRepository;
    }

    @Override
    public Squeaking save(Squeaking squeaking) {
        return squeakingRepository.save(squeaking);
    }
}
