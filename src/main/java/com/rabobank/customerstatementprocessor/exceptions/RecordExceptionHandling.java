package com.rabobank.customerstatementprocessor.exceptions;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rabobank.customerstatementprocessor.model.RecordResponse;

@ControllerAdvice
public class RecordExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<RecordResponse> handleException(Exception ex) {
		RecordResponse recordResponseError = new RecordResponse();
		recordResponseError.setResult("INTERNAL_SERVER_ERROR");
		recordResponseError.setErrorRecords(new ArrayList<>());
		return new ResponseEntity(recordResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		RecordResponse recordResponseError = new RecordResponse();
		recordResponseError.setResult("INTERNAL_SERVER_ERROR");
		recordResponseError.setErrorRecords(new ArrayList<>());
		return new ResponseEntity(recordResponseError, HttpStatus.BAD_REQUEST);
	}

}
