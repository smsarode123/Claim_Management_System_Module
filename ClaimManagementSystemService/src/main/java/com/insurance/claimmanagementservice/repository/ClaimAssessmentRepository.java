package com.insurance.claimmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claimmanagementservice.model.ClaimAssessment;
@Repository
public interface ClaimAssessmentRepository extends JpaRepository<ClaimAssessment,Integer> {

}
