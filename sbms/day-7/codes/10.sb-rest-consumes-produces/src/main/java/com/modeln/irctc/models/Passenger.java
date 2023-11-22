package com.modeln.irctc.models;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Passenger {
	private String passengerName;
	private String fromStation;
	private String toStation;
	private LocalDate dateOfJourney;
	private String trainNo;
}