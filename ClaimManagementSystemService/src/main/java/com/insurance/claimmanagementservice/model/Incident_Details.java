package com.insurance.claimmanagementservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Incident_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incidentId;
	private String incidentLocation;
	private long incidentInvolvePersons;
	}
