package com.cafe.Fooddelivery.ResponseModel;

public class CreateOrderResponseModel extends BaseResponseModel {

	private String orderId;
	
	private String estimatedTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	
}
