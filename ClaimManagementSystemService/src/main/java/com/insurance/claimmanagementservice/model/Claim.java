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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int claimId;
	private String claimentName;
	private long claimentContactNumber;
	private String policyNumber;
	private String claimType;
	private String claimStatus;
	private Date claimDate;
	private Date dateOfIncident;
	private Date dateOfClaimClosure;
}
