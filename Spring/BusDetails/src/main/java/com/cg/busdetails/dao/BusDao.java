package com.cg.busdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.busdetails.entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer>{

}
