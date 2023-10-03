package com.cafe.Fooddelivery.BusinessLogic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe.Fooddelivery.DTO.UserDto;
import com.cafe.Fooddelivery.Entity.User;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;
import com.cafe.Fooddelivery.Service.UserService;
import com.cafe.Fooddelivery.Utility.FoodDeliveryConvertor;

@Component
public class UserBusinessLogic {

	private UserService userService;

	@Autowired
	public UserBusinessLogic(UserService userService) {
		this.userService = userService;
	}

	public BaseResponseModel registerUser(UserDto userDto) {
		BaseResponseModel responseModel = new BaseResponseModel();
		boolean isCreated = userService.registerUser(FoodDeliveryConvertor.convertToUserEntity(userDto));
		if (isCreated) {
			responseModel.setStatus("Menu created successfully");
			responseModel.setHasError(false);
		}
		return responseModel;

	}

	public List<UserDto> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> userList = users.stream().map(FoodDeliveryConvertor::convertToUserDto)
				.collect(Collectors.toList());
		return userList;
	}

	public UserDto getUserById(Long id) {
		User user = userService.getUserById(id);
		UserDto userDto = FoodDeliveryConvertor.convertToUserDto(user);
		return userDto;
	}

}
