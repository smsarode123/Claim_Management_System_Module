package com.insurance.claimmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claimmanagementservice.model.Incident_Details;
import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class IncidentDetailsController {
	
	@Autowired private ClaimService claimService;
	
	@PostMapping("/saveIncidentDetails")
	public ResponseEntity<Incident_Details>  saveIncidentDetails(@RequestBody Incident_Details incident_Details){
		
		
		Incident_Details inDetails = claimService.saveIncidentDetails(incident_Details);
		
		return new ResponseEntity<Incident_Details>(inDetails,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/getAllIncident_Details")
	public ResponseEntity<List<Incident_Details>> getAllIncident_Details(){
		
		List<Incident_Details> inDetails = claimService.getAllIncident_Details();
		
		return new ResponseEntity<List<Incident_Details>>(inDetails,HttpStatus.FOUND);
		
	}
	
	
	@GetMapping("/getSingleIncident_Details/{incidentId}")
	public ResponseEntity<Incident_Details> getSingleIncident_Details(@PathVariable int incidentId){
		
		Incident_Details inDetails = claimService.getSingleIncident_Details(incidentId);
		
		return new ResponseEntity<Incident_Details>(inDetails,HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateIncident_Details/{incidentId}")
	public ResponseEntity<Incident_Details> updateIncident_Details(@PathVariable int incidentId,@RequestBody  Incident_Details incident_Details){

	Incident_Details inDetails = claimService.updateIncidentDetails(incidentId,incident_Details);
	
	return new ResponseEntity<Incident_Details>(inDetails,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/deleteIncident_Details/{incidentId}")
	public ResponseEntity<Incident_Details> deleteIncident_Details(@PathVariable int incidentId){
		
		claimService.deleteIncident_Details(incidentId);
		
		return new ResponseEntity<Incident_Details>(HttpStatus.GONE);
	}
}
