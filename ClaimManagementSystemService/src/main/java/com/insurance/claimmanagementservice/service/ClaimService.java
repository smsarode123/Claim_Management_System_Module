package com.insurance.claimmanagementservice.service;

import com.insurance.claimmanagementservice.model.Claim;

public interface ClaimService {


	Claim getSingleClaimService(int claimId);

	Claim saveClaimInformation(Claim claim);

}
