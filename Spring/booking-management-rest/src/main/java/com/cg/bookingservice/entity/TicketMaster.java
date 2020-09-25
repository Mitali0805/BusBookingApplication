package com.cg.bookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="TICKETMASTER")
public class TicketMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	private Integer noOfSeats;
	private Integer userId;
	private Integer totalFare;
	
	public TicketMaster() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TicketMaster(Integer ticketId, Integer noOfSeats, Integer userId,Integer totalFare) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.userId=userId;
		this.totalFare = totalFare;
		
	}


	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}
	
	@OneToOne
	@JoinColumn(name = "tripId")
	private Trip trip;
	
	@JsonBackReference
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
//	@ManyToOne
//	@JoinColumn(name = "customerId")
//	private Customer customer;
//	
//	@JsonBackReference
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
}
