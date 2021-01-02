package com.LoanManagementSystem.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface EMIService {

	Object getEmI(Map<String, Object> map);

	Object AddEmi(Map<String, Object> map) throws Exception;

}
