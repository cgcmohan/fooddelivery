package com.cafe.Fooddelivery.BusinessConstant;

public enum OrderStatus {

	PENDING("Pending"),
	COMPLETED("Completed"),
	RECEIVED("Order Received"),
	PROCESSING("Processing"),
	DELIVERED("Delivered"),
	CANCELLED("Cancelled");
	
	private final String status;
	
	OrderStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		 return this.status;
	}
}
