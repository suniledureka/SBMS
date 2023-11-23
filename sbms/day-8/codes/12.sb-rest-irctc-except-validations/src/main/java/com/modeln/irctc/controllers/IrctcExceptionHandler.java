package com.modeln.irctc.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.modeln.irctc.exceptions.TicketNotFoundException;
import com.modeln.irctc.models.ApiError;

@RestControllerAdvice
public class IrctcExceptionHandler {
	/*
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<?> handleTicketNotFoundException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	*/
	
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<?> handleTicketNotFoundException(Exception ex) {
		ApiError error = new ApiError();
		//error.setType(ex.getClass().getSimpleName());
		error.setType(ex.getClass().getName());
		error.setMessage(ex.getMessage());
		error.setTime(LocalDateTime.now());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationFailureException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		List<String> errorMessages = fieldErrors.stream().map(error -> error.getField()+" - "+ error.getDefaultMessage())
														 .collect(Collectors.toList());
		return new ResponseEntity<List<String>>(errorMessages, HttpStatus.BAD_REQUEST);
	}
}
