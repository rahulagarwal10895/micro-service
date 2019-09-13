package com.mettalica.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mettalica.exception.DataNotFoundException;
import com.mettalica.exception.ServiceException;
import com.mettalica.model.response.ApiResponse;

@RestControllerAdvice
public class BaseController {

	 @ExceptionHandler(ServiceException.class)
	    public ResponseEntity<ApiResponse> handleServiceException(ServiceException exception){
	        ApiResponse apiResponse = new ApiResponse();
	        apiResponse.setResponse(null);
	        apiResponse.setStatus("FAILURE");
	        apiResponse.setMessage(exception.getMessage());
	        
	        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException exception, HttpServletResponse http){
	        ApiResponse apiResponse = new ApiResponse();
	        apiResponse.setResponse(null);
	        apiResponse.setStatus("FAILURE");
	        apiResponse.setMessage(exception.getMessage());
	        
	        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    
	    @ExceptionHandler(DataNotFoundException.class)
	    public ResponseEntity<ApiResponse> handleDataNotFoundException(DataNotFoundException exception, HttpServletResponse http){
	        ApiResponse apiResponse = new ApiResponse();
	        apiResponse.setResponse(null);
	        apiResponse.setStatus("FAILURE");
	        apiResponse.setMessage(exception.getMessage());
	        
	        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NO_CONTENT);
	    }
}
