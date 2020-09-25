package com.cg.bookingservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookingservice.entity.TicketMaster;

@Repository
public interface BookingDao extends JpaRepository<TicketMaster, Integer> {

}
