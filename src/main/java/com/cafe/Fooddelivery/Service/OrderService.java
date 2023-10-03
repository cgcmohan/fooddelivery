package com.cafe.Fooddelivery.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.Fooddelivery.BusinessConstant.OrderStatus;
import com.cafe.Fooddelivery.DTO.OrderDto;
import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.Entity.Order;
import com.cafe.Fooddelivery.Entity.User;
import com.cafe.Fooddelivery.Repository.MenuItemRepository;
import com.cafe.Fooddelivery.Repository.OrderRepository;
import com.cafe.Fooddelivery.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	private MenuItemRepository menuItemRepository;
	
	private UserRepository userRepository;
	
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderService(MenuItemRepository menuItemRepository, UserRepository userRepository, OrderRepository orderRepository) {
		this.menuItemRepository = menuItemRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}
	
	public Order createOrder(OrderDto orderDto) {
		MenuItem menuItem = menuItemRepository.findById(orderDto.getMenuItemId())//
												.orElseThrow(() -> new EntityNotFoundException("MenuItem not found with Id : "+orderDto.getMenuItemId()));
		User user = userRepository.findById(orderDto.getUserId())//
												.orElseThrow(() -> new EntityNotFoundException("User not found with id : "+orderDto.getUserId()));
		
		Order order = new Order(menuItem, user, orderDto.getQuantity());
		Order newOrder = orderRepository.save(order);
		return newOrder;
		
	}

	public List<Order> getOrderByUserId(Long userId) {
		List<Order> orderList= orderRepository.findByUserId(userId);
		return orderList;
	}

	public List<Order> activeOrderList() {
		String status = "active";
		List<Order> orderList= orderRepository.findByOrderStatus(status);
		return orderList;
	}

	public Order getOrderByOrderId(Long orderId) {
		Optional<Order> order= orderRepository.findById(orderId);
		if(order.isPresent()) {
			return order.get();
		}
		return new Order();
	}
	
	public void updateOrderStatusBasedOnTimeAndActiveOrders(Order order) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		LocalDateTime estimatedCompletionTime = order.getEstimatedCompletionTime();
		
		// If the estimated completion time has passed, update the status to "Completed"
        if (currentDateTime.isAfter(estimatedCompletionTime) && order.getOrderStatus() != OrderStatus.COMPLETED.toString()) {
            order.setOrderStatus(OrderStatus.COMPLETED.toString());
            orderRepository.save(order);
        } else {
            // Check the status of other active orders and update status accordingly
        	String status = "active";
            List<Order> activeOrders = orderRepository.findByOrderStatus(status); // Implement this method in OrderRepository

		
		
        }
	}

}
