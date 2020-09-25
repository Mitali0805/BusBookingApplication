package com.cg.bookingservice.feignproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bookingservice.entity.Bus;

@FeignClient(name = "Bus-microservice")
//configure calls for load balance
@RibbonClient(name = "Bus-microservice")
public interface BusDetailsServiceProxy {

	
	@GetMapping("/bus/all")
	public List<Bus> getAllBuses();

	@GetMapping("/searchbus/{source}/{destination}")
	public List<Bus> searchBySourceDestination(@RequestParam String source, @RequestParam String destination);

	@PostMapping("/setseats/{noOfSeats")
	public void setSeats(Integer noOfSeats);

	
}
