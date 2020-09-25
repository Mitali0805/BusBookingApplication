package com.cg.busdetails.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.busdetails.dao.BusDao;
import com.cg.busdetails.entity.Bus;
import com.cg.busdetails.entity.Trip;

@Service
public class BusService {

	@Autowired
	BusDao busDao;

	public Bus addBus(Bus bus) {
		return this.busDao.save(bus);
	}

	public List<Bus> getAllBuses() {
		return this.busDao.findAll();
	}

	public Bus updateBus(Bus bus) {
		return this.busDao.save(bus);
	}

	public void deleteBusById(int busId) {
		this.busDao.deleteById(busId);
	}

	public List<Bus> searchBySourceDestination(String source, String destination) {
		List<Bus> collectedBusList = this.busDao.findAll();
		List<Bus> newList = new ArrayList<Bus>();
    	for (Bus bus : collectedBusList) {
			int flag=0;
			 List<Trip> tripList=new ArrayList<Trip>();
			for(Trip trip:bus.getTotalTrips()) {
				if (trip.getBusSource().equals(source) && trip.getBusDestination().equals(destination)) {
					tripList.add(trip);
					bus.setTotalTrips(tripList);
					flag=1;
				}
			}
			if(flag==1)
			newList.add(bus);
		}
		return newList;
	}
	
	public List<Bus> searchBusBySourceDestinationDate(String busSource, String busDestination, LocalDate date_of_Journey) {
		List<Bus> routeSearchList = searchBySourceDestination(busSource, busDestination);
		List<Bus> newList = new ArrayList<Bus>();
		for(Bus bus : routeSearchList) {
			List<Trip> tripList = new ArrayList<Trip>();
			int flag = 0;
			for(Trip trip : bus.getTotalTrips()) {
					if (date_of_Journey.equals(trip.getDate_of_Journey())) {
						tripList.add(trip);
						bus.setTotalTrips(tripList);
						flag = 1;
					}
				}
				if(flag == 1)
					newList.add(bus);
			}
			return newList;
			}
}
