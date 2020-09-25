package com.cg.bookingservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String userName;
	private String email;
	private String gender;
	private String password;
	private String name;
	private String mobileNo;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(int customerId,String userName, String email, String gender, String password, String name, String mobileNo) {
		super();
		this.userName=userName;
		this.customerId = customerId;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.name = name;
		this.mobileNo = mobileNo;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
//	@OneToMany(mappedBy="customer",cascade= {CascadeType.ALL})
//	private List<TicketMaster> ticketMaster;
//	
//	@JsonManagedReference
//	public List<TicketMaster> getTicketMaster(){
//		return this.ticketMaster;
//	}
//	
//	public void setTicketMaster(List<TicketMaster> ticketMaster) {
//		this.ticketMaster=ticketMaster;
//	}
	
	
}
