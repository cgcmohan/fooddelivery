package com.cafe.Fooddelivery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.Fooddelivery.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	 public List<Order> findByUserId(Long userId);

	public List<Order> findByOrderStatus(String status);
	 
}
