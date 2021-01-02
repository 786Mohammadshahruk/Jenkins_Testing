package com.LoanManagementSystem.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LoanManagementSystem.Service.EMIService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/")
@Component
public class EMIController {
	
	@Autowired
	private EMIService emiService;
	
	@RequestMapping(value="/getemi",method = RequestMethod.GET)
	public Object getEmi(HttpServletRequest request) throws Exception {
		Object requestObject = new ObjectMapper().readValue(request.getInputStream(), Object.class);
		Map<String, Object> map= (Map<String, Object>) requestObject;
		return emiService.getEmI(map);
	}
	@RequestMapping(value="/emi",method = RequestMethod.POST)
	public Object AddEmi(HttpServletRequest request) throws Exception {
		System.out.println(request);
		Object requestObject = new ObjectMapper().readValue(request.getInputStream(), Object.class);
		Map<String, Object> map= (Map<String, Object>) requestObject;
		return emiService.AddEmi(map);
	}

}
