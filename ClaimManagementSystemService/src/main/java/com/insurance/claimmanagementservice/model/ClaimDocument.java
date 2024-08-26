package com.insurance.claimmanagementservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClaimDocument {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int claimId;
	@Lob
	@Column(length = 999999999)
	private byte [] incidentImage;
}
