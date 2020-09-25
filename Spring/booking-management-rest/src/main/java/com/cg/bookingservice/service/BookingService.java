package com.cg.bookingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookingservice.dao.BookingDao;
import com.cg.bookingservice.entity.TicketMaster;
import com.cg.bookingservice.entity.Trip;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	
	public TicketMaster addTicket(TicketMaster ticketMaster) {
		
		return this.dao.save(ticketMaster);
	}

	public TicketMaster getTicket(Integer ticketId) {
		
		return this.dao.findAll().stream().filter(x->x.getTicketId()==ticketId).findAny().get();
	}

	public void deleteTicket(int ticketId) {
	    this.dao.deleteById(ticketId);
		
	}

//	public List<TicketMaster> getAllTickets(int customerId) {
//		
//		return this.dao.findAll().stream().filter(x->x.getCustomer().getCustomerId()==customerId).collect(Collectors.toList());
//	}

	public List<TicketMaster> showAllTickets(){
		return this.dao.findAll();
	}

	public List<TicketMaster> getTicketByUserId(int userId) {
	
		return this.dao.findAll().stream().filter(x->x.getUserId()==userId).collect(Collectors.toList());
	}
	
	public List<Trip> getTripByUserId(int userId){
		List<TicketMaster> ticketMaster=getTicketByUserId(userId);
		List<Trip> trip=new ArrayList<Trip>();
		for(int i=0;i<ticketMaster.size();i++) {
			trip.add(ticketMaster.get(i).getTrip());
		}
		return trip;
	}
}
