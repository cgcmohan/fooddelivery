package com.cafe.Fooddelivery.BusinessLogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe.Fooddelivery.DTO.OrderDto;
import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.Entity.Order;
import com.cafe.Fooddelivery.Entity.User;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;
import com.cafe.Fooddelivery.Service.OrderService;

@Component
public class OrderBusinessLogic {

	private OrderService orderService;
	
	@Autowired
	public OrderBusinessLogic(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public BaseResponseModel createOrder(OrderDto orderDto) {
		BaseResponseModel response = new BaseResponseModel();
		boolean isCreated = orderService.createOrder(orderDto);
		if(isCreated) {
			response.setStatus("Order Placed Successfully");
			response.setHasError(false);
		}
		return response;
	}

	public List<Order> getOrderByUserId(Long userId) {
		List<Order> orderList = orderService.getOrderByUserId(userId);
		return orderList;
	}

}
