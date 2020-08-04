package com.rabobank.customerstatementprocessor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabobank.customerstatementprocessor.dao.impl.RecordRepositoryImpl;
import com.rabobank.customerstatementprocessor.model.Record;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordRepositoryTest {

	RecordRepositoryImpl recordRepository;
	
	@Before
	public void setup(){
		recordRepository = new RecordRepositoryImpl();
	}
	
	@Test
	public void saveRecordTest() {
		Record record = buildRecord();
		recordRepository.saveRecord(record);
		assertThat(recordRepository.getRecords().size()).isEqualTo(1);
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
