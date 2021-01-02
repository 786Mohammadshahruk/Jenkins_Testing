package com.LoanManagementSystem.Dao.Impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.LoanManagementSystem.Dao.EMIDao;
import com.LoanManagementSystem.Models.EMICalculation;
import com.LoanManagementSystem.Models.User;

@Repository
public class EMIDaoImpl implements EMIDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Object getEmi(Map<String, Object> map) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(EMICalculation.class);
		if ((null != map.get("loanId").toString())) {
			criteria.add(Restrictions.eq("loanId",Integer.parseInt(map.get("loanId").toString())));
		}
		return criteria.list();
	}

	@Override
	public Object crateEmi(HashMap<String, Object> hm) {
		Session session =entityManager.unwrap(Session.class);
		EMICalculation emi=new EMICalculation();
		emi.setLoanId(Integer.parseInt(hm.get("Loan_Id").toString()));
		emi.setPrincipalRemaining(hm.get("Principal_Amount_Remaining").toString());
		emi.seteMIAmount(hm.get("EMI_Amount").toString());
		emi.seteMIDate(hm.get("EMI_Date").toString());
		emi.setInterestEMI(hm.get("Interest_EMI").toString());
		emi.setPrinciple_EMI(hm.get("Principal_Emi").toString());
		emi.setTotalEMI(hm.get("Total_EMI").toString());
		session.beginTransaction();
		session.save(emi);
		session.getTransaction().commit();
		return "Added";
		
	}

}
