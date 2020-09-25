package com.cg.busdetails.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.busdetails.entity.Bus;
import com.cg.busdetails.service.BusService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
	BusService busService;

	// http://localhost:8888/bus/all
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Bus> getAllBuses() {
		return this.busService.getAllBuses();
	}

	// http://localhost:8888/bus/addbus
	@RequestMapping(value = "/addbus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bus addBus(@RequestBody Bus bus) {
		return this.busService.addBus(bus);
	}

	@RequestMapping(value = "/searchbus/{source}/{destination}", method = RequestMethod.GET)
	public List<Bus> getBusesBySourceDestination(@RequestParam String source,@RequestParam String destination ) {
		System.out.println("In Source and Destination");
		System.out.println(source+destination);
		return this.busService.searchBySourceDestination(source, destination);
	}
	
	@GetMapping(value = "/search/{busSource}/{busDestination}/{date_of_Journey}")
	public List<Bus> searchBus(@PathVariable String busSource ,@PathVariable String busDestination,@PathVariable String date_of_Journey) {
		LocalDate result=LocalDate.parse(date_of_Journey);
		System.out.println("temp result"+result);
		return this.busService.searchBusBySourceDestinationDate(busSource, busDestination,result);
	}

	// http://localhost:8888/bus/updatebus
	@RequestMapping(value = "/updatebus", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bus updateBus(@RequestBody Bus bus) {
		return this.busService.updateBus(bus);
	}

	// http://localhost:8888/bus/1
	@RequestMapping(value = "/{busId}", method = RequestMethod.DELETE)
	public void deleteBus(@PathVariable int busId) {
		this.busService.deleteBusById(busId);
	}
}
