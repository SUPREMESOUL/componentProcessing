package com.componentProcessing.Models;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProcessResponse {
	@Id
	private int requestId;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private Date dateOfDelivery;
	

}

