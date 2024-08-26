package com.insurance.claimmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired
	private ClaimService service;
	
	@PostMapping("/saveClaimInformation")
	public ResponseEntity<Claim> saveClaimInformation(@RequestBody Claim claim)
	{
		Claim claimRef = service.saveClaimInformation(claim);
		
		return new ResponseEntity<Claim>(claimRef, HttpStatus.CREATED);
	}

	

}
