package com.insurance.claimmanagementservice.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	@Lob
	@Column(length = 999999999)
	private byte [] incidentImage;
	
    @OneToOne(cascade = CascadeType.ALL)
	private Incident_Details incident;
    
    @OneToMany(cascade = CascadeType.ALL) 
	private List<ClaimAssessment> claimassessment;
	
}
