package com.modeln.irctc.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modeln.irctc.entities.Ticket;
import com.modeln.irctc.models.Passenger;
import com.modeln.irctc.repositories.TicketRepository;

@RestController
@RequestMapping("/irctc")
public class TicketRestController {
	@Autowired
	private TicketRepository ticketRepo;
	
	@PostMapping(value = "ticket/new", consumes = { "application/xml", "application/json" }, 
				produces = {"application/xml", "application/json" })
	public ResponseEntity<?> newTicketBooking(@RequestBody Passenger passenger) {
		// --logic to generate the ticket for passenger and to save in DB
		Ticket ticket = new Ticket();		
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTrainNo(passenger.getTrainNo());

		ticket.setTicketFare(1750f);

		LocalDate date = LocalDate.now();
		ticket.setDateOfBooking(date);

		ticket.setBookingStatus(new Random().nextBoolean() ? "CONFIRMED" : "WAITING");
		ticket.setPnr(generatePNR());
		
		ticketRepo.save(ticket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	private String generatePNR() {
		UUID uuid = UUID.randomUUID();
		String randomText = uuid.toString();
		randomText = randomText.replace("-", "");
		String pnr = randomText.substring(0, 6).toUpperCase();
		return pnr;
	}
	
	@DeleteMapping("/ticket/cancel/{pnr}")
	public ResponseEntity<String> deleteTicketByPnr(@PathVariable String pnr){
		if(ticketRepo.existsById(pnr)) {
			ticketRepo.deleteById(pnr);
			return new ResponseEntity<String>("Ticket Cancelled | Amount will be refunded in 2 business days", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Ticket with PNR: " + pnr, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/ticket/cancel/name/{pName}")
	public ResponseEntity<String> deleteTicketByName(@PathVariable String pName){
		List<Ticket> tickets = ticketRepo.findByPassengerName(pName);
		if(!tickets.isEmpty()) {
			ticketRepo.deleteByPassengerName(tickets.get(0).getPassengerName());
			return new ResponseEntity<String>("Ticket Cancelled | Amount will be refunded in 2 business days", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Matching Tickets found!!", HttpStatus.BAD_REQUEST);
		}
	}	
}
