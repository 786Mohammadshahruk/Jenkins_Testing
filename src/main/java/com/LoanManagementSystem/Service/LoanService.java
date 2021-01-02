package com.LoanManagementSystem.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LoanService {

	Object CreateLoan(Map<String, Object> map) throws Exception;

}
