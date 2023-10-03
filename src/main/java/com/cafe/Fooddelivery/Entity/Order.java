package com.cafe.Fooddelivery.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
//	@JoinColumn(name = "menu_item_id", nullable = false)
	@JsonIgnore
	private MenuItem menuItem;
	
	@OneToOne
//	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	private int quantity;
	
	private String orderStatus;
	
	private LocalDateTime estimatedCompletionTime = LocalDateTime.now().plusMinutes(3);

	public Order(MenuItem menuItem, User user, int quantity) {
		super();
		this.menuItem = menuItem;
		this.user = user;
		this.quantity = quantity;
	}
	
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}



	public LocalDateTime getEstimatedCompletionTime() {
		return estimatedCompletionTime;
	}



	public void setEstimatedCompletionTime(LocalDateTime estimatedCompletionTime) {
		this.estimatedCompletionTime = estimatedCompletionTime;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getOrderStatus() {
		 return this.orderStatus;
	}
	
	public void setOrderStatus(String status) {
		this.orderStatus = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static class Builder {
		
		private MenuItem menuItem;
		 
		private User user;
		
		private int quantity;
		
		private String orderStatus;
		
		private LocalDateTime estimatedCompletionTime;

		public Builder setMenuItem(MenuItem menuItem) {
			this.menuItem = menuItem;
			return this;
		}

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public Builder setQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}

		public Builder setEstimatedCompletionTime(LocalDateTime estimatedCompletionTime) {
			this.estimatedCompletionTime = estimatedCompletionTime;
			return this;
		}
		
		public Order build() {
			Order order = new Order();
			order.estimatedCompletionTime = this.estimatedCompletionTime;
			order.menuItem = this.menuItem;
			order.orderStatus = this.orderStatus;
			order.quantity = this.quantity;
			order.user = this.user;
			return order;
		}
		
		
	}
	
	
}
