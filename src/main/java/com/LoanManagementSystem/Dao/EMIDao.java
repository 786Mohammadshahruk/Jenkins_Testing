package com.LoanManagementSystem.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface EMIDao {

	Object getEmi(Map<String, Object> map);

	Object crateEmi(HashMap<String, Object> hm);

}
