package com.metallica.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.metallica.exception.ServiceException;
import com.metallica.exception.TradeNotFoundException;
import com.metallica.exception.ValidationException;
import com.metallica.model.response.ApiResponse;

@RestControllerAdvice
public class BaseController {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ApiResponse> handlevalidationException(ValidationException exception) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(null);
		apiResponse.setStatus("FAILURE");
		apiResponse.setMessage(exception.getMessage());

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ApiResponse> handleServiceException(ServiceException exception) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(null);
		apiResponse.setStatus("FAILURE");
		apiResponse.setMessage(exception.getMessage());

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException exception, HttpServletResponse http) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(null);
		apiResponse.setStatus("FAILURE");
		apiResponse.setMessage(exception.getMessage());

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(TradeNotFoundException.class)
	public ResponseEntity<ApiResponse> handleDataNotFoundException(TradeNotFoundException exception,
			HttpServletResponse http) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResponse(null);
		apiResponse.setStatus("FAILURE");
		apiResponse.setMessage(exception.getMessage());

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NO_CONTENT);
	}
}
