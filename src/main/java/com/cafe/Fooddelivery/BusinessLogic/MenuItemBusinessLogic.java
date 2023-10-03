package com.cafe.Fooddelivery.BusinessLogic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe.Fooddelivery.DTO.MenuItemDto;
import com.cafe.Fooddelivery.Entity.MenuItem;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;
import com.cafe.Fooddelivery.Service.MenuItemService;
import com.cafe.Fooddelivery.Utility.FoodDeliveryConvertor;

@Component
public class MenuItemBusinessLogic {

	private MenuItemService menuItemService;
	
	@Autowired
	public MenuItemBusinessLogic(MenuItemService menuItemService) {
		 this.menuItemService = menuItemService;
	}
	
	public List<MenuItemDto> getAllMenuItem() {
		List<MenuItem> menuItems = menuItemService.getAllMenuItem();
		List<MenuItemDto> meuItemList = menuItems.stream().map(FoodDeliveryConvertor::convertToMenuItemDto)//
													.collect(Collectors.toList());
		return meuItemList;
	}


	public MenuItemDto getMenuItemById(Long menuId) {
		MenuItem newMenu = menuItemService.getMenuItemById(menuId);
		MenuItemDto menuById = FoodDeliveryConvertor.convertToMenuItemDto(newMenu);
		return menuById;
	}

	public BaseResponseModel createMenu(MenuItemDto menuItemDto) {
		BaseResponseModel responseModel = new BaseResponseModel();
		boolean isCreated = menuItemService.createMenu(FoodDeliveryConvertor.convertToMenuItem(menuItemDto));
		if(isCreated) {
			responseModel.setStatus("Menu created successfully");
			responseModel.setHasError(false);
		}
		return responseModel;
			
	}

}
