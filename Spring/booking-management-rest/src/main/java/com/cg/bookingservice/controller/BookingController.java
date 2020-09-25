package com.cg.bookingservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookingservice.entity.Bus;
import com.cg.bookingservice.entity.TicketMaster;
import com.cg.bookingservice.entity.Trip;
import com.cg.bookingservice.feignproxy.BusDetailsServiceProxy;
import com.cg.bookingservice.service.BookingService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BookingController {


	// Depenedency of proxy
	@Autowired
	private BusDetailsServiceProxy busService;
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bus/all")
	public List<Bus> fetachAllBuses(){
		return this.busService.getAllBuses();
	}
	
	@GetMapping(value = "/searchbus/{source}/{destination}")
	public List<Bus> getBusesBySourceDestination(@RequestParam String source,@RequestParam String destination) {
		System.out.println("In Source and Destination");
		return this.busService.searchBySourceDestination(source, destination);
	}

	
	@PostMapping("/bookticket")
	public TicketMaster bookTicket(@RequestBody TicketMaster ticketMaster) {
		return this.bookingService.addTicket(ticketMaster);
//		if(ticketMaster.getTrip().getBus().getTotalSeats()!=0) {
//			this.busService.setSeats(ticketMaster.getNoOfSeats());
//		return this.bookingService.addTicket(ticketMaster);
//		}else
//		return null;
		
	}
	
	
	@GetMapping("/getTicket/{ticketId}")
	public TicketMaster getTicket(@PathVariable int ticketId) {
		return this.bookingService.getTicket(ticketId);
	}
	
	@DeleteMapping("/removeTicket/{ticketId}")
	public void removeTicket(@PathVariable int ticketId) {
		this.bookingService.deleteTicket(ticketId);
	}
	
//	@GetMapping("/showAllTickets/{customerId}")
//	public List<TicketMaster> showAllTicketsByCustomerId(@PathVariable int customerId){
//		return this.bookingService.getAllTickets(customerId);
//	}
	
	@GetMapping("/showAllTickets")
	public List<TicketMaster> showAllTickets(){
		return this.bookingService.showAllTickets();
	}
	
	@GetMapping("/getTicketByUserId/{userId}")
	public List<TicketMaster> getTicketByUserId(@PathVariable int userId){
		System.out.println("inTicketUserId");
		return this.bookingService.getTicketByUserId(userId);
	}
	
	@GetMapping("/getTripByUserId/{userId}")
	public List<Trip> getTripByUserId(@PathVariable int userId){
		return this.bookingService.getTripByUserId(userId);
	}
}
