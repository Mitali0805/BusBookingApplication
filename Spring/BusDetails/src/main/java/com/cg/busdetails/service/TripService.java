package com.cg.busdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.busdetails.dao.TripDao;
import com.cg.busdetails.entity.Bus;
import com.cg.busdetails.entity.Trip;



@Service
public class TripService {
	@Autowired
	private TripDao tripDao;
	
	public Trip addTrip(Trip trip) {
		return this.tripDao.save(trip);
	}
	
	public List<Trip> getAllTrips() {
        return this.tripDao.findAll();
    }
	
	public Trip getTripById(int tripId) {
		return this.tripDao.findBytripId(tripId);
	}
	
	public Bus getBusByTripId(int tripId) {
		return this.tripDao.findBytripId(tripId).getBus();
	}
}