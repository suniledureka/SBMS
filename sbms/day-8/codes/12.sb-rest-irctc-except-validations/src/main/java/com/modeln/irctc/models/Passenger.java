package com.modeln.irctc.models;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Passenger {
	@NotBlank(message = "Name is required")
	private String passengerName;
	
	@NotEmpty(message = "fromStation is required")
	@Size(min = 3, message = "fromStation should be min 3 chars")
	private String fromStation;
	
	@NotNull(message = "toStation is required")
	private String toStation;	
	
	private LocalDate dateOfJourney;
	
	@Length(min = 5, max = 6, message = "trainNo should be min 5 - 6 chars length")
	private String trainNo;

}