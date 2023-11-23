package com.modeln.irctc.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Ticket {
	private String passengerName;
	private String fromStation;
	private String toStation;	
	private LocalDate dateOfJourney;
	private String trainNo;
	
	@Id
	private String pnr;	
	private LocalDate dateOfBooking;
	private String bookingStatus;
	private Float ticketFare;
}