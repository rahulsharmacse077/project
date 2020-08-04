package com.rabobank.customerstatementprocessor.dao;

import com.rabobank.customerstatementprocessor.model.Record;

public interface RecordRepository {

	Record getRecord(int transactionReference);

	void saveRecord(Record record);

}
