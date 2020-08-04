package com.rabobank.customerstatementprocessor.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rabobank.customerstatementprocessor.dao.RecordRepository;
import com.rabobank.customerstatementprocessor.model.Record;

@Repository
public class RecordRepositoryImpl implements RecordRepository {

	private Map<Integer, Record> recordMap;

	@Override
	public Record getRecord(int transactionReference) {
		if (recordMap == null) {
			recordMap = new HashMap<>();
		}
		
		if(recordMap.containsKey(transactionReference)) {
			return recordMap.get(transactionReference);
		}
		return null;
	}
	
	@Override
	public void saveRecord(Record record) {
		if (recordMap == null) {
			recordMap = new HashMap<>();
		}
		recordMap.put(record.getTransactionReference(), record);
	}
 

}
