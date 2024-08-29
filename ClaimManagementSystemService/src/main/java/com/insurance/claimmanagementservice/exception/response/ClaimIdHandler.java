package com.insurance.claimmanagementservice.exception.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.insurance.claimmanagementservice.dto.ErrorResponse;
import com.insurance.claimmanagementservice.exception.InvalidClaimIdException;
import com.insurance.claimmanagementservice.exception.InvalidIncidentIdException;
import com.insurance.claimmanagementservice.exception.InvalidClaimAssessmentIdException;

@ControllerAdvice
public class ClaimIdHandler {

	 @ExceptionHandler(InvalidClaimIdException.class)
	public ResponseEntity<ErrorResponse> handlerInvalidId(InvalidClaimIdException claim) {
		
		ErrorResponse response = new ErrorResponse(claim.getMessage(), claim.getClass().getName(), new Date(), 404);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	 @ExceptionHandler(InvalidIncidentIdException.class)
    public ResponseEntity<ErrorResponse> InvalidIncidentIdId(InvalidIncidentIdException incinIdException) {
		
		ErrorResponse response = new ErrorResponse(incinIdException.getMessage(), incinIdException.getClass().getName(), new Date(), 404);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	 
	 @ExceptionHandler(InvalidClaimAssessmentIdException.class)
	 public ResponseEntity<ErrorResponse> InvalidClaimAssessmentIdException(InvalidClaimAssessmentIdException inException) {
			
			ErrorResponse response = new ErrorResponse(inException.getMessage(), inException.getClass().getName(), new Date(), 404);
			
			return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
		}
}
