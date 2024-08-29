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

import com.insurance.claimmanagementservice.model.ClaimAssessment;
import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class ClaimAssessmentController {
	
	@Autowired
	private ClaimService claimService;
	
	@PostMapping("/saveClaimAssessment")
	public ResponseEntity<ClaimAssessment> saveClaimAssessment(@RequestBody ClaimAssessment claimAssessment){
		
		ClaimAssessment clAssessment = claimService.saveClaimAssessment(claimAssessment);
		
		return new ResponseEntity<ClaimAssessment>(clAssessment, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllClaimAssessment")
	public ResponseEntity<List<ClaimAssessment>> getAllClaimAssessment(){
		
		List<ClaimAssessment> claimAssessments = claimService.getAllClaimAssessment();
		
		
		return new ResponseEntity<List<ClaimAssessment>>(claimAssessments,HttpStatus.FOUND);
	}
	
	@GetMapping("/getSingleClaimAssessment/{claimId}")
	public ResponseEntity<ClaimAssessment> getSingleClaimAssessment(@PathVariable int claimId){
		
		ClaimAssessment claimAssessment = claimService.getSingleClaimAssessment(claimId);
		
		return  new ResponseEntity<ClaimAssessment>(claimAssessment,HttpStatus.FOUND);
	}
	
	@PutMapping("/updateClaimAssessment/{claimId}")
	public ResponseEntity<ClaimAssessment> updateClaimAssessment(@PathVariable int claimId,@RequestBody ClaimAssessment clAssessment){
		
		ClaimAssessment claimAssessment = claimService.updateClaimAssessment(claimId,clAssessment);
		
		return  new ResponseEntity<ClaimAssessment>(claimAssessment,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteClaimAssessment/{claimId}")
	public ResponseEntity<ClaimAssessment> deleteClaimAssessment(@PathVariable int claimId){
		
		claimService.deleteClaimAssessment(claimId);
		
		return  new ResponseEntity<ClaimAssessment>(HttpStatus.CREATED);
	}

	
	
}
