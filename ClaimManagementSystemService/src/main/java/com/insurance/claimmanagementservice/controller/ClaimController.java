package com.insurance.claimmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claimmanagementservice.service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired
	private ClaimService service;
	
	

	

}
