package com.insurance.claimmanagementservice.claimserviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.claimmanagementservice.exception.InvalidClaimIdException;
import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.repository.ClaimRepository;
import com.insurance.claimmanagementservice.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired private ClaimRepository repository;

	@Override
	public Claim getSingleClaimService(int claimId) {
		Optional<Claim> claim = repository.findById(claimId);

		if (claim.isPresent()) {

			return claim.get();
		} else {
			throw new InvalidClaimIdException("Customer id " + claimId + " is not valid");
		}
	
		
	}


}
