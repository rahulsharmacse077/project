package com.rabobank.customerstatementprocessor.dao;

import java.util.Optional;

import com.rabobank.customerstatementprocessor.model.Record;

public interface RecordRepository {

	Optional<Record> getRecord(int transactionReference);

	void saveRecord(Record record);

}
