package com.cg.busdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.busdetails.entity.Bus;
import com.cg.busdetails.entity.Trip;
import com.cg.busdetails.service.TripService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	private TripService tripService;

	@RequestMapping(value = "/addtrip", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Trip addTrip(@RequestBody Trip trip) {
		return this.tripService.addTrip(trip);
	}
	
	// http://localhost:8888/bus/all
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public List<Trip> getAllTrips() {
			return this.tripService.getAllTrips();
		}
		
		@PostMapping("/updateTrip")
		public Trip updateBusTrip(@RequestBody Trip trip) {
			Bus bus=this.tripService.getBusByTripId(trip.getTripId());
			trip.setBus(bus);
			return this.tripService.addTrip(trip);					
		}

		@GetMapping(value = "/searchTrip/{tripId}")
		public Trip getTripById(@PathVariable int tripId){
			return this.tripService.getTripById(tripId);
		}
		

		@GetMapping(value = "/searchBus/{tripId}")
		public Bus getBusByTripId(@PathVariable int tripId){
			return this.tripService.getBusByTripId(tripId);
		}
}

