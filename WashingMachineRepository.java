package com.in.washingMachine.repository;

import org.springframework.data.repository.CrudRepository;

import com.in.washingMachine.vo.WashingMachine;

import java.util.List;

/**
 * Created by khizar khan
 */
public interface WashingMachineRepository extends CrudRepository<WashingMachine, Long> {
    List<WashingMachine> findAll();
    WashingMachine save(WashingMachine appliance);
}
