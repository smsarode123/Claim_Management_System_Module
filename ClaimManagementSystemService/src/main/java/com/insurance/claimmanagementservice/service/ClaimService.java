package com.insurance.claimmanagementservice.service;

import java.util.List;

import com.insurance.claimmanagementservice.model.Claim;

public interface ClaimService {

	Claim getSingleClaimService(int claimId);

	Claim saveClaimInformation(Claim claim);

	List<Claim> getAllClaim();

	void deleteClaimByClaimId(int claimId);

}
