package com.in.washingMachine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.washingMachine.process.Washing;
import com.in.washingMachine.repository.WashingRepository;
import com.in.washingMachine.service.WashingService;

/**
 * Created by khizar khan
 */
@Service
public class WashingServiceImpl implements WashingService {
    private final WashingRepository washingRepository;

    @Autowired
    public WashingServiceImpl(WashingRepository washingRepository) {
        this.washingRepository = washingRepository;
    }

    @Override
    public Washing save(Washing washing) {
        return washingRepository.save(washing);
    }
}
