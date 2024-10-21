package com.insurance.claimmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claimmanagementservice.model.Incident_Details;

@Repository
public interface Incident_DetailsRepository extends JpaRepository<Incident_Details, Integer>{

}
