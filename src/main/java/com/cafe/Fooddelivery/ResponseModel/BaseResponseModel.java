package com.cafe.Fooddelivery.ResponseModel;

import lombok.Data;

@Data
public class BaseResponseModel {

	private boolean hasError;
	
	private String errorDescription;
	
	private String status;

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
