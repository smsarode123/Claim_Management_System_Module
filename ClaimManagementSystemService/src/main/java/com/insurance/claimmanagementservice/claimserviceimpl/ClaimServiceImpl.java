package com.insurance.claimmanagementservice.claimserviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.claimmanagementservice.exception.InvalidClaimIdException;

import com.insurance.claimmanagementservice.model.Claim;
import com.insurance.claimmanagementservice.repository.ClaimRepository;
import com.insurance.claimmanagementservice.service.ClaimService;


@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository repository;

	@Override

	public Claim getSingleClaimService(int claimId) {
		Optional<Claim> claim = repository.findById(claimId);

		if (claim.isPresent()) {

			return claim.get();
		} else {
			throw new InvalidClaimIdException("Customer id " + claimId + " is not valid");
		}

	}

	@Override
	public Claim saveClaimInformation(Claim claim) {

		return repository.save(claim);

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
	public Claim updateClaim(Claim claim, int claimId) {
	 Optional<Claim> claimRef=repository.findById(claimId);
	 
	 if(claimRef.isPresent()) {
		 return repository.save(claim);
	 }
	 else {
		  throw new InvalidClaimIdException(" Claim Id" + claimId + " is not valid");
	 }
	}

}
