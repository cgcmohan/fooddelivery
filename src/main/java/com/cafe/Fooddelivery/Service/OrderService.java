package com.cafe.Fooddelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public boolean createOrder(OrderDto orderDto) {
		MenuItem menuItem = menuItemRepository.findById(orderDto.getMenuItemId())//
												.orElseThrow(() -> new EntityNotFoundException("MenuItem not found with Id : "+orderDto.getMenuItemId()));
		User user = userRepository.findById(orderDto.getUserId())//
												.orElseThrow(() -> new EntityNotFoundException("User not found with id : "+orderDto.getUserId()));
		
		Order order = new Order(menuItem, user, orderDto.getQuantity());
		Order newOrder = orderRepository.save(order);
		return true;
		
	}

	public List<Order> getOrderByUserId(Long userId) {
		List<Order> orderList= orderRepository.findByUserId(userId);
		return orderList;
	}

}
