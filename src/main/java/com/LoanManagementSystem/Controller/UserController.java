package com.LoanManagementSystem.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.LoanManagementSystem.Service.UserService;

@RestController
@RequestMapping(value="/")
@Component
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/userfile", consumes = { "multipart/form-data", "application/json" })
	public Object executeLogin(@Validated @RequestPart(value = "User", required = false) MultipartFile user
			,HttpServletRequest request) throws Exception {
		return userService.AddUser(user);
		
	}

}
