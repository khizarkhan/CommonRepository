package com.in.washingMachine.repository;

import org.springframework.data.repository.CrudRepository;

import com.in.washingMachine.vo.programe.WashingMachineFunction;

/**
 * Created by khizar khan
 */
public interface ProgramRepository extends CrudRepository<WashingMachineFunction, Long> {
    WashingMachineFunction save(WashingMachineFunction program);
}
