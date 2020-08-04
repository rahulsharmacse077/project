package com.rabobank.customerstatementprocessor.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rabobank.customerstatementprocessor.dao.RecordRepository;
import com.rabobank.customerstatementprocessor.model.Record;

@Repository
public class RecordRepositoryImpl implements RecordRepository {

	private Map<Integer, Record> recordMap;

	@Override
	public Optional<Record> getRecord(int transactionReference) {
		if (recordMap == null) {
			recordMap = new HashMap<>();
		}
		return Optional.ofNullable(recordMap.get(transactionReference));
	}
	
	@Override
	public void saveRecord(Record record) {
		if (recordMap == null) {
			recordMap = new HashMap<>();
		}
		recordMap.put(record.getTransactionReference(), record);
	}
	
	public Map<Integer, Record> getRecords(){
		return recordMap;
	}
 

}
