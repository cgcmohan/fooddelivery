package com.cafe.Fooddelivery.Scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cafe.Fooddelivery.Entity.Order;
import com.cafe.Fooddelivery.Service.OrderService;

@Component
public class OrderStatusUpdater {

	private OrderService orderService;
	@Autowired
	public OrderStatusUpdater(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Scheduled(fixedRate = 60000)
	public void updateOrderStatus() {
		List<Order> activeOrders = orderService.activeOrderList();
		
		for(Order order : activeOrders) {
			orderService.updateOrderStatusBasedOnTimeAndActiveOrders(order);
		}
	}
}
