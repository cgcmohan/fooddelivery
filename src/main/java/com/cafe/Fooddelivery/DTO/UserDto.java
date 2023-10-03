package com.cafe.Fooddelivery.DTO;

import java.util.List;

public class UserDto {

	private String username;
	
	private String password;

	private List<OrderDto> orders;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
	
}
