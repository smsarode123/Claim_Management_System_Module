package com.insurance.claimmanagementservice.claimserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.repository.ClaimRepository;
import com.insurance.claimmanagementservice.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired private ClaimRepository repository;

	@Override
	public List<Claim> getAllClaim() {
		
		List<Claim> claim =repository.findAll();
		
		return claim;
	}

	
}
