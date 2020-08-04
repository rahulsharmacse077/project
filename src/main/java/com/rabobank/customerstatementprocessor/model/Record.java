package com.rabobank.customerstatementprocessor.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Record implements Serializable {

	private static final long serialVersionUID = 187008686604142882L;

	@JsonProperty("Reference")
	private int transactionReference;
	
	@JsonProperty("AccountNumber")
	private String accountNumber;
	
	@JsonProperty("Start Balance")
	private float startBalance;
	
	@JsonProperty("Mutation")
	private float mutation;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("End Balance")
	private float endBalance;

}
