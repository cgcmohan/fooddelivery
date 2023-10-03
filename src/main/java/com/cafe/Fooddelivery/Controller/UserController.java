package com.cafe.Fooddelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.Fooddelivery.BusinessLogic.UserBusinessLogic;
import com.cafe.Fooddelivery.DTO.UserDto;
import com.cafe.Fooddelivery.ResponseModel.BaseResponseModel;

@RestController
@RequestMapping("user")
public class UserController {

	private final UserBusinessLogic userBusinessLogic;

    @Autowired
    public UserController(UserBusinessLogic userBusinessLogic) {
        this.userBusinessLogic = userBusinessLogic;
    }

    @PostMapping("/register")
    public BaseResponseModel registerUser(@RequestBody UserDto userDto) {
    	return userBusinessLogic.registerUser(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userBusinessLogic.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userBusinessLogic.getUserById(id);
    }
}
