package com.insurance.claimmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired
	private ClaimService service;
	@GetMapping("getsingleClaimByClaimId/{claimId}")
	public ResponseEntity<Claim> getSingleClaimService(@PathVariable("claimId")int claimId){
		Claim claim= service.getSingleClaimService(claimId);
		 return new ResponseEntity<Claim>(claim, HttpStatus.OK);
		
	}

	

}
