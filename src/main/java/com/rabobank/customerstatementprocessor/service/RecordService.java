package com.rabobank.customerstatementprocessor.service;

import com.rabobank.customerstatementprocessor.model.Record;
import com.rabobank.customerstatementprocessor.model.RecordResponse;

public interface RecordService {

	RecordResponse saveRecord(Record record);

}
