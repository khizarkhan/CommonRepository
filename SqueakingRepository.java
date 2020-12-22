package com.in.washingMachine.repository;

import org.springframework.data.repository.CrudRepository;

import com.in.washingMachine.process.Squeaking;

/**
 * Created by khizar khan
 */
public interface SqueakingRepository extends CrudRepository<Squeaking, Long> {
    Squeaking save(Process Squeaking);
}
