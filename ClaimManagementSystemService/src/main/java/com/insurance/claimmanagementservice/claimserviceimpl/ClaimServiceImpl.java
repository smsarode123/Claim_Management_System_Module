package com.insurance.claimmanagementservice.claimserviceimpl;

import java.io.IOException;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.claimmanagementservice.exception.InvalidClaimAssessmentIdException;
import com.insurance.claimmanagementservice.exception.InvalidClaimIdException;
import com.insurance.claimmanagementservice.exception.InvalidIncidentIdException;
import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.model.ClaimAssessment;
import com.insurance.claimmanagementservice.model.Incident_Details;
import com.insurance.claimmanagementservice.repository.ClaimAssessmentRepository;
import com.insurance.claimmanagementservice.repository.ClaimRepository;
import com.insurance.claimmanagementservice.repository.Incident_DetailsRepository;
import com.insurance.claimmanagementservice.service.ClaimService;


@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository repository;
	
	@Autowired
	private Incident_DetailsRepository inRepository;
	
	@Autowired
	private ClaimAssessmentRepository claimAssessmentRepository;

	@Override

	public Claim getSingleClaimService(int claimId) {
		Optional<Claim> claim = repository.findById(claimId);

		if (claim.isPresent()) {

			return claim.get();
		} else {
			throw new InvalidClaimIdException("Customer id " + claimId + " is not valid");
		}

	}

	

	public List<Claim> getAllClaim() {

		List<Claim> claim = repository.findAll();

		return claim;

	}

	@Override
	public void deleteClaimByClaimId(int claimId) {
		Optional<Claim> claimRef = repository.findById(claimId);

		if (claimRef.isPresent()) {
			repository.deleteById(claimId);
		} else {
			throw new InvalidClaimIdException("Customer id " + claimId + " is not valid");

		}
		
	}

	@Override

	public Incident_Details saveIncidentDetails(Incident_Details incident_Details) {
		
		return inRepository.save(incident_Details);
	}

	@Override
	public List<Incident_Details> getAllIncident_Details() {
		
		return inRepository.findAll();
	}

	@Override
	public Incident_Details updateIncidentDetails(int incidentId, Incident_Details incident_Details) {
		
		
		Optional<Incident_Details> inDetails = inRepository.findById(incidentId);
		
		
		if(inDetails.isPresent()) {
			
			incident_Details.setIncidentId(incidentId);
			
			return inRepository.save(incident_Details);
		}
	else {
		
		throw new InvalidIncidentIdException("Incident Id:- " + incidentId + "  Is Not Present For Update Operation");
	  }
		
	}

	@Override
	public void deleteIncident_Details(int incidentId) {
       Optional<Incident_Details> incident_Details = inRepository.findById(incidentId);
		
		if(incident_Details.isPresent()) {
			
			inRepository.deleteById(incidentId);
		}
		
		
		
		else {
			
			throw new InvalidIncidentIdException("Incident Id:- " + incidentId + "  Is Not Present For Delete Operation");
		  }

	}

	@Override
	public Incident_Details getSingleIncident_Details(int incidentId) {
		
		Optional<Incident_Details> incident_Details = inRepository.findById(incidentId);
		
		if(incident_Details.isPresent()) {
			
			return incident_Details.get();
		}
		
		
		
		else {
			
			throw new InvalidIncidentIdException("Incident Id:- " + incidentId + "  Is Not Present For Update Operation");
		  }
	}

	@Override
	public ClaimAssessment saveClaimAssessment(ClaimAssessment claimAssessment) {
		
		return claimAssessmentRepository.save(claimAssessment);
	}

	@Override
	public List<ClaimAssessment> getAllClaimAssessment() {
		
		return claimAssessmentRepository.findAll();
	}

	@Override
	public ClaimAssessment getSingleClaimAssessment(int claimId) {
		
		Optional<ClaimAssessment> claimAssessment = claimAssessmentRepository.findById(claimId);
		
		if(claimAssessment.isPresent()) {
			
			return claimAssessment.get();
		}
		
		else {
			
			throw new InvalidClaimAssessmentIdException("Incident Id:- " + claimId + "  Is Not Present ");
		}
	
		
		
	}

	@Override
	public ClaimAssessment updateClaimAssessment(int claimId, ClaimAssessment clAssessment) {
		
		Optional<ClaimAssessment> claimAssessment = claimAssessmentRepository.findById(claimId);
		
		if(claimAssessment.isPresent()) {
			
		clAssessment.setClaimId(claimId);
		
		return claimAssessmentRepository.save(clAssessment);
		}
		else {
			throw new InvalidClaimAssessmentIdException("Incident Id:- " + claimId + "  Is Not Present For Update Operation");
		}
	}

	@Override
	public void deleteClaimAssessment(int claimId) {
		
		Optional<ClaimAssessment> claimAssessment = claimAssessmentRepository.findById(claimId);
		 if(claimAssessment.isPresent()) {
			 
			 claimAssessmentRepository.deleteById(claimId);
			 
			 
		 }else {
			
			 throw new InvalidClaimAssessmentIdException("Incident Id:- " + claimId + "  Is Not Present For Delete Operation");
		}
		
	}

	
	

	public Claim updateClaim(Claim claim, int claimId) {
	 Optional<Claim> claimRef=repository.findById(claimId);
	 
	 if(claimRef.isPresent()) {
		 return repository.save(claim);
	 }
	 else {
		  throw new InvalidClaimIdException(" Claim Id" + claimId + " is not valid");
	 }
	}

	@Override
	public Claim saveClaimInformation(String claim, MultipartFile incidentphoto) {
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		 
		Claim claimdata=new Claim();
		
		try {
			claimdata=mapper.readValue(claim, Claim.class);
			
		    claimdata.setIncidentImage(incidentphoto.getBytes());
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return repository.save(claimdata);
	}


}
