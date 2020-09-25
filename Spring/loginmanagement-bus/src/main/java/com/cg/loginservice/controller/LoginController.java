package com.cg.loginservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginservice.entity.Customer;
import com.cg.loginservice.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:4200")
	public Customer registerUser(@RequestBody Customer customer)throws Exception {
		String tmpUsername=customer.getUserName();
		if(tmpUsername!=null && !"".equals(tmpUsername) ) {
		Customer userObj=loginService.fetchUserByUsername(tmpUsername);
		
		if(userObj!=null)
		{
			return null;
		}
		}
		Customer userObj=null;
		userObj=loginService.addUser(customer);
		return userObj;
		
	}
	
	

	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public Customer checkLogin(@RequestBody Customer customer) throws Exception {
		String tmpUsername=customer.getUserName();
		String tmpPassword = customer.getPassword();
		Customer tmpcustomer=null;
		System.out.println("In login");
		if(tmpUsername!=null && tmpPassword!=null ) {
			tmpcustomer=loginService.fetchUserByUserNameandPassword(tmpUsername, tmpPassword);
		}
		if(tmpcustomer==null)
		{
			return null;
		}
		
		return tmpcustomer;
	}
	
	@GetMapping("/all")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Customer> getAll(){
		return this.loginService.fetchAll();
	}
	
}
