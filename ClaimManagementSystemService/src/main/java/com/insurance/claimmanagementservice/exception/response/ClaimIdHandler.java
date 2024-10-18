package com.insurance.claimmanagementservice.exception.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.claimmanagementservice.dto.ErrorResponse;
import com.insurance.claimmanagementservice.exception.InvalidClaimIdException;

public class ClaimIdHandler {

	public ResponseEntity<ErrorResponse> handlerInvalidId(InvalidClaimIdException claim) {

		ErrorResponse response = new ErrorResponse(claim.getMessage(), claim.getClass().getName(), new Date(), 404);

		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
