package com.componentProcessing.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentService {
	
	@Id
	private  int id;
	private  Long cardNumber;
	private  int cvv;
	private  double amount;
	
}
