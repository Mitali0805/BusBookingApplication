package com.cg.loginservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginservice.dao.Login;
import com.cg.loginservice.entity.Customer;

@Service
public class LoginService {

	@Autowired
	private Login loginDao;
	
//	public Customer validateUser(Customer customer) {
//		
//		
//		Customer dummy=this.loginDao.findByuserName(customer.getUserName());
//		
//		if(dummy.getPassword().equals(customer.getPassword())) {
//			
//			return null;			
//			
//		}else {
//			System.out.println("In else Validator");
//			return addUser(customer);
//			
//		}
//	}
//	
//	public Customer checkUser(Customer customer) {
//		  
//		Customer dummy=this.loginDao.findAll().stream().filter(x->x.getUserName().equals(customer.getUserName())).findAny().get();
//		if(dummy.getPassword().equals(customer.getPassword())) {
//			return dummy;
//		}else {
//			return null;
//		}
//	}

	
	public Customer fetchUserByUsername(String username) {
		return loginDao.findByuserName(username);
		
	}

	
	public Customer fetchUserByUserNameandPassword(String username,String password) {
		return loginDao.findByuserNameAndPassword(username, password);
		
	}
	
	public Customer addUser(Customer customer) {
		return this.loginDao.save(customer);
		
	}


	public List<Customer> fetchAll() {
		return this.loginDao.findAll();
	}

}
