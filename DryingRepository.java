package com.in.washingMachine.repository;

import org.springframework.data.repository.CrudRepository;

import com.in.washingMachine.process.Drying;

/**
 * Created by khizar khan
 */
public interface DryingRepository extends CrudRepository<Drying, Long> {
    Drying save(Drying process);
}
