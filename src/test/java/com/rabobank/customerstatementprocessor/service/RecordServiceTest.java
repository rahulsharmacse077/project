package com.rabobank.customerstatementprocessor.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabobank.customerstatementprocessor.model.Record;
import com.rabobank.customerstatementprocessor.model.RecordResponse;
import com.rabobank.customerstatementprocessor.service.impl.RecordServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTest {
	
	@Mock
	RecordServiceImpl recordServiceImpl;
	
	@Test
	public void saveRecordTest() {
		RecordResponse recordResponse = new RecordResponse();
		recordResponse.setResult("SUCCESSFULL");
		
		Record record = buildRecord();
		
		Mockito.when(recordServiceImpl.saveRecord(record)).thenReturn(recordResponse);
		
		RecordResponse actual = recordServiceImpl.saveRecord(record);
		
		assertThat(actual.getResult()).isEqualTo("SUCCESSFULL");
	}
	
	@Test
	public void saveRecordTest_With_Incorrect_End_Balance() {
		RecordResponse recordResponse = new RecordResponse();
		recordResponse.setResult("INCORRECT_END_BALANCE");
		
		Record record = buildRecord();
		record.setStartBalance(22f);
		
		Mockito.when(recordServiceImpl.saveRecord(record)).thenReturn(recordResponse);
		
		RecordResponse actual = recordServiceImpl.saveRecord(record);
		
		assertThat(actual.getResult()).isEqualTo("INCORRECT_END_BALANCE");
	}
	
	@Test
	public void saveRecordTest_With_Duplicate_Reference() {
		RecordResponse recordResponse = new RecordResponse();
		recordResponse.setResult("SUCCESSFULL");
		
		Record record = buildRecord();
		Record record1 = buildRecord();
		
		Mockito.when(recordServiceImpl.saveRecord(record)).thenReturn(recordResponse);
		recordResponse.setResult("DUPLICATE_REFERENCE");
		Mockito.when(recordServiceImpl.saveRecord(record1)).thenReturn(recordResponse);
		
		RecordResponse actual = recordServiceImpl.saveRecord(record1);
		
		assertThat(actual.getResult()).isEqualTo("DUPLICATE_REFERENCE");
	}
	
	@Test
	public void saveRecordTest_With_Duplicate_Reference_AND_Incorrect_end_balance() {
		RecordResponse recordResponse = new RecordResponse();
		recordResponse.setResult("SUCCESSFULL");
		
		Record record = buildRecord();
		Record record1 = buildRecord();
		record1.setStartBalance(22f);
		
		Mockito.when(recordServiceImpl.saveRecord(record)).thenReturn(recordResponse);
		recordResponse.setResult("DUPLICATE_REFERENCE_INCORRECT_END_BALANCE");
		Mockito.when(recordServiceImpl.saveRecord(record1)).thenReturn(recordResponse);
		
		RecordResponse actual = recordServiceImpl.saveRecord(record1);
		
		assertThat(actual.getResult()).isEqualTo("DUPLICATE_REFERENCE_INCORRECT_END_BALANCE");
	}
	
	
	private Record buildRecord() {
		Record record = new Record();
		record.setTransactionReference(194261);
		record.setAccountNumber("NL91RABO0315273637");
		record.setDescription("Clothes from Jan Bakker");
		record.setStartBalance(21.6f);
		record.setMutation(-41.83f);
		record.setEndBalance(-20.23f);
		return record;
	}

}
