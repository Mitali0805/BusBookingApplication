package com.cg.busdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.busdetails.entity.Trip;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {

	public Trip findBytripId(Integer tripId);
}
