package com.rabobank.customerstatementprocessor.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabobank.customerstatementprocessor.constants.AppConstants;
import com.rabobank.customerstatementprocessor.dao.RecordRepository;
import com.rabobank.customerstatementprocessor.model.ErrorRecord;
import com.rabobank.customerstatementprocessor.model.Record;
import com.rabobank.customerstatementprocessor.model.RecordResponse;
import com.rabobank.customerstatementprocessor.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;

	@Override
	public RecordResponse saveRecord(Record record) {
		RecordResponse recordResponse = new RecordResponse();
		String result = "";
		List<ErrorRecord> errorRecordList = new ArrayList<>();

		String endBal = String.valueOf(record.getEndBalance());
		Float sum = record.getStartBalance() + record.getMutation();

		boolean balanceCheck = new DecimalFormat("#.##").format(sum).equals(endBal);
		
		Record existRecord = recordRepository.getRecord(record.getTransactionReference());

		if (null != existRecord) {
			// Duplicate Reference & Correct Balance
			result = AppConstants.DUPLICATE_REFERENCE;
			errorRecordList.add(new ErrorRecord(record.getTransactionReference(), record.getAccountNumber()));

			if (!balanceCheck) {
				// Duplicate Reference & InCorrect Balance
				result = AppConstants.DUPLICATE_REFERENCE_INCORRECT_END_BALANCE;
				errorRecordList.add(new ErrorRecord(record.getTransactionReference(), record.getAccountNumber()));
			}
		} else {

			if (balanceCheck) {
				// No Duplicate Reference No Incorrect Balance
				result = AppConstants.SUCCESSFUL;
				recordRepository.saveRecord(record);
			} else {
				// No Duplicate Reference But Incorrect Balance
				result = AppConstants.INCORRECT_END_BALANCE;
				errorRecordList.add(new ErrorRecord(record.getTransactionReference(), record.getAccountNumber()));
			}

		}

		recordResponse.setResult(result);
		recordResponse.setErrorRecords(errorRecordList);

		return recordResponse;
	}

}
