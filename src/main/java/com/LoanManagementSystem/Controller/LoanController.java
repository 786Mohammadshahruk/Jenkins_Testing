package com.LoanManagementSystem.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LoanManagementSystem.Service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/")
@Component
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	@RequestMapping(value="/loan",method = RequestMethod.POST)
	public Object updateUser(HttpServletRequest request) throws Exception {
		System.out.println(request);
		Object requestObject = new ObjectMapper().readValue(request.getInputStream(), Object.class);
		Map<String, Object> map= (Map<String, Object>) requestObject;
		return loanService.CreateLoan(map);
	}

}
