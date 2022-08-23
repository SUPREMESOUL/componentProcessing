package com.componentProcessing.Exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	
	private Date timestamp;
	private String message;
	private String details;
}
