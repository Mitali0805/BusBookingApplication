package com.cg.busdetails.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Bus")

public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	
	private String busName;
	private int totalSeats;
	private int busRating;
	
public Bus() {
	
}
	
	public Bus(int busId, String busName, int totalSeats, int busRating) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.totalSeats = totalSeats;
		this.busRating = busRating;
	}
	

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBusRating() {
		return busRating;
	}

	public void setBusRating(int busRating) {
		this.busRating = busRating;
	}


	@OneToMany(mappedBy = "bus",cascade = {CascadeType.ALL})
	private List<Trip> totalTrips;
	
	@JsonManagedReference
	public List<Trip> getTotalTrips() {
		return totalTrips;
	}

	public void setTotalTrips(List<Trip> totalTrips) {
		this.totalTrips = totalTrips;
	}

	
}

	