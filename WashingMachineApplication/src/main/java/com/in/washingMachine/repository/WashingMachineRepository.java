package com.in.washingMachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.washingMachine.vo.WashingMachine;

import java.util.List;

/**
 * Created by khizar khan
 */
@Repository
public interface WashingMachineRepository extends JpaRepository<WashingMachine, Long> {
    List<WashingMachine> findAll();
    WashingMachine save(WashingMachine appliance);
	WashingMachine findById(int i);
    
}
