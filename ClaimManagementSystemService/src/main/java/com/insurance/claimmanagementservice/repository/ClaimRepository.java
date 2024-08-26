package com.insurance.claimmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.claimmanagementservice.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
