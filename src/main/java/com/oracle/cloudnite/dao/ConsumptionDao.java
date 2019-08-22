package com.oracle.cloudnite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.cloudnite.model.Consumption;

public interface ConsumptionDao extends JpaRepository<Consumption, Long> {

}