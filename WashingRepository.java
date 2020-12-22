package com.in.washingMachine.repository;

import org.springframework.data.repository.CrudRepository;

import com.in.washingMachine.process.Washing;

/**
 * Created khizar khan
 */
public interface WashingRepository extends CrudRepository<Washing, Long> {
    Washing save(Washing washing);
}
