package com.LoanManagementSystem.Dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	void AddUser(String[] dataArray);

}
