package com.cg.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.loginservice.entity.Customer;

public interface Login extends JpaRepository<Customer, Integer> {

	
	public Customer findByuserName(String userName);
	
	 public  Customer findByuserNameAndPassword(String username,String password );
}
