package com.rabobank.customerstatementprocessor.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabobank.customerstatementprocessor.model.Record;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecordController.class)
public class CustomerStatementProcessorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void validateCustomerStatement() throws Exception {
		String uri = "/customerStatement";
		Record record = new Record();
		record.setTransactionReference(194261);
		record.setAccountNumber("NL91RABO0315273637");
		record.setDescription("Clothes from Jan Bakker");
		record.setStartBalance(21.6f);
		record.setMutation(-41.83f);
		record.setEndBalance(-20.23f);
		
		String inputJson = new ObjectMapper().writeValueAsString(record);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content("[" + inputJson + "]")).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
