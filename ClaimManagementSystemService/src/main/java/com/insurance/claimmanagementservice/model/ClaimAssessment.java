package com.insurance.claimmanagementservice.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClaimAssessment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int claimId;
	private float claimAmount;
	private Date claimDate;
}
