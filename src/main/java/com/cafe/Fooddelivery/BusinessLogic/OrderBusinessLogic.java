package com.cafe.Fooddelivery.BusinessLogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe.Fooddelivery.BusinessConstant.OrderStatus;
import com.cafe.Fooddelivery.DTO.OrderDto;
import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.Entity.Order;
import com.cafe.Fooddelivery.Entity.User;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;
import com.cafe.Fooddelivery.ResponseModel.CreateOrderResponseModel;
import com.cafe.Fooddelivery.Service.OrderService;

@Component
public class OrderBusinessLogic {

	private OrderService orderService;
	
	@Autowired
	public OrderBusinessLogic(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public CreateOrderResponseModel createOrder(OrderDto orderDto) {
		CreateOrderResponseModel response = new CreateOrderResponseModel();
		Order newOrder = orderService.createOrder(orderDto);
		if(newOrder != null) {
			response.setStatus("Order Placed Successfully : "+OrderStatus.RECEIVED);
			response.setHasError(false);
			response.setOrderId(String.valueOf(newOrder.getId()));
			response.setEstimatedTime("5 minutes");
		}
		return response;
	}

	public List<Order> getOrderByUserId(Long userId) {
		List<Order> orderList = orderService.getOrderByUserId(userId);
		return orderList;
	}

	public List<Order> activeOrderList() {
		List<Order> orderList = orderService.activeOrderList();
		return orderList;
	}

	public Order getOrderByOrderId(Long orderId) {
		Order order = orderService.getOrderByOrderId(orderId);
		return order;
	}

}
