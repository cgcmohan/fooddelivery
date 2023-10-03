package com.cafe.Fooddelivery.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.Repository.MenuItemRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuItemService {

	private MenuItemRepository menuItemRepository;
	
	@Autowired
	public MenuItemService(MenuItemRepository menuItemRepository) {
		 this.menuItemRepository = menuItemRepository;
	}
	
	public List<MenuItem> getAllMenuItem() {
		List<MenuItem> menuItems = menuItemRepository.findAll();
       return menuItems;
	}

	public MenuItem getMenuItemById(Long menuId) {
		MenuItem menuById = menuItemRepository.findById(menuId).orElseThrow(() -> new EntityNotFoundException("Menu not found with id : "+menuId));
		
		return menuById;
	}

	public boolean createMenu(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		return true;
	}

	

}
