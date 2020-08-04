package com.rabobank.customerstatementprocessor.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordResponse implements Serializable{

	private static final long serialVersionUID = -7770685680569668982L;
	
	private String result;
	private List<ErrorRecord> errorRecords;

}
