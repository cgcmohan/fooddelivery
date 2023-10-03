package com.cafe.Fooddelivery.Utility;

import com.cafe.Fooddelivery.DTO.MenuItemDto;
import com.cafe.Fooddelivery.DTO.UserDto;
import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.Entity.User;

public class FoodDeliveryConvertor {

	public static MenuItemDto convertToMenuItemDto(MenuItem menuItems) {
		
		MenuItemDto menuItemDto = new MenuItemDto();
		
		menuItemDto.setName(menuItems.getName());
		
		menuItemDto.setPrice(menuItems.getPrice());
		
		return menuItemDto;
		
		
	}


	public static MenuItem convertToMenuItem(MenuItemDto menuItemDto) {
		
		MenuItem menuItems = new MenuItem();
		
		menuItems.setName(menuItemDto.getName());
		
		menuItems.setPrice(menuItemDto.getPrice());
		
		return menuItems;
		
		
	}


	public static User convertToUserEntity(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public static UserDto convertToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		return userDto;
	}


}
