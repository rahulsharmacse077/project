package com.rabobank.customerstatementprocessor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.customerstatementprocessor.model.Record;
import com.rabobank.customerstatementprocessor.model.RecordResponse;
import com.rabobank.customerstatementprocessor.service.RecordService;

@RestController
@RequestMapping("/customerStatement")
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@PostMapping
	public ResponseEntity<List<RecordResponse>> validateCustomerStatement(@RequestBody Record[] records){
		List<RecordResponse> recordResponseList = new ArrayList<>();
		
		for(Record record : records) {
			RecordResponse recordResponse = recordService.saveRecord(record);
			recordResponseList.add(recordResponse);
		}
		
		return new ResponseEntity<>(recordResponseList, HttpStatus.OK);
	}

}
