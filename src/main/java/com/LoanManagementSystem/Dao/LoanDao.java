package com.LoanManagementSystem.Dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanDao {

	Object CreateLoan(Map<String, Object> map);

}
