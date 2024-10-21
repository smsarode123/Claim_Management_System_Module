package com.insurance.claimmanagementservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.model.ClaimAssessment;
import com.insurance.claimmanagementservice.model.Incident_Details;

public interface ClaimService {

	Claim getSingleClaimService(int claimId);

	

	List<Claim> getAllClaim();

	void deleteClaimByClaimId(int claimId);


	Incident_Details saveIncidentDetails(Incident_Details incident_Details);

	List<Incident_Details> getAllIncident_Details();

	Incident_Details updateIncidentDetails(int incidentId, Incident_Details incident_Details);

	void deleteIncident_Details(int incidentId);

	Incident_Details getSingleIncident_Details(int incidentId);

	ClaimAssessment saveClaimAssessment(ClaimAssessment claimAssessment);

	List<ClaimAssessment> getAllClaimAssessment();

	ClaimAssessment getSingleClaimAssessment(int claimId);

	ClaimAssessment updateClaimAssessment(int claimId, ClaimAssessment clAssessment);

	void deleteClaimAssessment(int claimId);



	Claim updateClaim(Claim claim, int claimId);

	Claim saveClaimInformation(String claim, MultipartFile incidentphoto);


}
