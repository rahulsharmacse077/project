package com.rabobank.customerstatementprocessor.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorRecord implements Serializable {

	private static final long serialVersionUID = -3008510232654068720L;

	private int reference;
	private String accountNumber;

}
