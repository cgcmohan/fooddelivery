package com.cafe.Fooddelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.Fooddelivery.BusinessLogic.MenuItemBusinessLogic;
import com.cafe.Fooddelivery.DTO.MenuItemDto;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;

@RestController
@RequestMapping("/menuitem")
public class MenuItemController {

	private MenuItemBusinessLogic menuItemBusinessLogic;
	
	@Autowired
	public MenuItemController(MenuItemBusinessLogic menuItemBusinessLogic) {
		 this.menuItemBusinessLogic = menuItemBusinessLogic;
	}
	
	@GetMapping(value = "all")
	public List<MenuItemDto> getAllMenuItem() {
		return menuItemBusinessLogic.getAllMenuItem();
	}
	
	@PostMapping(value = "{id}")
	public MenuItemDto getMenuItemById(@PathVariable Long id) {
		return menuItemBusinessLogic.getMenuItemById(id);
	}
	
	@PostMapping(value = "create")
	public BaseResponseModel createMenu(@RequestBody MenuItemDto menuItemDto) {
		return menuItemBusinessLogic.createMenu(menuItemDto);
	}
	
	
}
