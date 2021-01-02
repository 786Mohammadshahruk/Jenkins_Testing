package com.LoanManagementSystem.Dao.Impl;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.LoanManagementSystem.Dao.LoanDao;
import com.LoanManagementSystem.Models.Loan;
@Repository
public class LoanDaoImpl implements LoanDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Object CreateLoan(Map<String, Object> map) {
		Session session = entityManager.unwrap(Session.class);
		Loan loan =new Loan();
		loan.setLoanId(Integer.parseInt((String) map.get("loanId")));
		loan.setUserId(Integer.parseInt((String) map.get("userId")));
		loan.setLoanAmount((String)map.get("loanAmount"));
		loan.setInterestRate((String)map.get("interestRate"));
		loan.setLoanTitle((String)map.get("loanTitle"));
		loan.setPrincipleAmount((String)map.get("principleAmount"));
		loan.setTenure((String)map.get("tenure"));
		session.beginTransaction();
		session.save(loan);
		session.getTransaction().commit();
		return null;
	}

}
