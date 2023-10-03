package com.cafe.Fooddelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.Fooddelivery.BusinessLogic.OrderBusinessLogic;
import com.cafe.Fooddelivery.DTO.OrderDto;
import com.cafe.Fooddelivery.Entity.Order;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderBusinessLogic orderBL;
	
	@Autowired
	public OrderController(OrderBusinessLogic orderBusinessLogic) {
		this.orderBL = orderBusinessLogic;
	}
	
	@PostMapping(value = "/create")
	public BaseResponseModel createOrder(@RequestBody OrderDto orderDto) {
		return orderBL.createOrder(orderDto);
	}
	
	@GetMapping(value = "user/{userId}")
	public List<Order> getOrderByUserId(@PathVariable Long userId) {
		return orderBL.getOrderByUserId(userId);
	}
	
	@GetMapping(value = "active")
	public List<Order> activeOrderList() {
		return orderBL.activeOrderList();
	}
	
	@GetMapping(value = "/{orderId}")
	public Order getOrderByOrderId(@PathVariable Long orderId) {
		return orderBL.getOrderByOrderId(orderId);
	}
}
