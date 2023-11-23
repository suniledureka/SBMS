package com.modeln.irctc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.irctc.entities.Ticket;

import jakarta.transaction.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, String> {

	List<Ticket> findByPassengerName(String pName);
	@Transactional
	void deleteByPassengerName(String passengerName);

}
