package com.mettalica.model.dto;

import com.mettalica.exception.ServiceException;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse {

	private Object response;
	private String message;
	private String status;

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
