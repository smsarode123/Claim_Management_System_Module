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

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	private ClaimService service;

	@GetMapping("/getsingleClaimByClaimId/{claimId}")
	public ResponseEntity<Claim> getSingleClaimService(@PathVariable("claimId") int claimId) {
		Claim claim = service.getSingleClaimService(claimId);
		return new ResponseEntity<Claim>(claim, HttpStatus.OK);

	}

	@PostMapping("/saveClaimInformation")
	public ResponseEntity<Claim> saveClaimInformation(@RequestBody Claim claim) {
		Claim claimRef = service.saveClaimInformation(claim);

		return new ResponseEntity<Claim>(claimRef, HttpStatus.CREATED);

	}

	@GetMapping("/getAllClaim")
	public ResponseEntity<List<Claim>> getAllClaim() {
		List<Claim> claim = service.getAllClaim();

		return new ResponseEntity<List<Claim>>(claim, HttpStatus.FOUND);

	}

	@DeleteMapping("/deleteclaimById/{claimId}")
	public ResponseEntity<String> deleteClaimBycliamId(@PathVariable("claimId") int claimId) {

		service.deleteClaimByClaimId(claimId);
		return new ResponseEntity<String>(HttpStatus.GONE);
	}
	
	@PutMapping("updateClaim/{claimId}")
	public ResponseEntity<Claim> updateCalaim(@PathVariable("claimId") int claimId, @RequestBody Claim claim)
	{
		Claim claimRef =service.updateClaim(claim,claimId);
		return new ResponseEntity<Claim>(claimRef, HttpStatus.OK);
		
	}
}
