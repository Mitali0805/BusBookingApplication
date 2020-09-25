package com.cg.bookingservice.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name = "BusTrip_Details")

public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tripId")
	private Integer tripId;
	
	@Column(name = "busType")
	private String busType;
	
	@Column(name = "busSource")
	private String busSource;
	
	@Column(name = "busDestination")
	private String busDestination;
	
	@Column(name = "busRate")
	private Integer busRate;
	
	@Column(name = " busStatus")
	private Boolean busStatus;
	
	@JsonFormat(pattern = "yyyy-MM-dd" , shape = Shape.STRING)
	@Column(name = "date_of_Journey")
	private LocalDate date_of_Journey;
	
	
	
 public Trip() {
 }
	
	
	public Trip(Integer tripId, String busType, String busSource, String busDestination, Integer busRate, Boolean busStatus,
			LocalDate date_of_Journey) {
	super();
	this.tripId = tripId;
	this.busType = busType;
	this.busSource = busSource;
	this.busDestination = busDestination;
	this.busRate = busRate;
	this.busStatus = busStatus;
	this.date_of_Journey = date_of_Journey;
}


	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusSource() {
		return busSource;
	}

	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}

	public Integer getBusRate() {
		return busRate;
	}

	public void setBusRate(Integer busRate) {
		this.busRate = busRate;
	}

	public Boolean getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(Boolean busStatus) {
		this.busStatus = busStatus;
	}

	public LocalDate getDate_of_Journey() {
		return date_of_Journey;
	}

	public void setDate_of_Journey(LocalDate date_of_Journey) {
		this.date_of_Journey = date_of_Journey;
	}


	@ManyToOne
	@JoinColumn(name = "busId")
	private Bus bus;
	
	@JsonBackReference
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
