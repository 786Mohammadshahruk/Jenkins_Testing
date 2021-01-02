package com.LoanManagementSystem.Service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoanManagementSystem.Dao.EMIDao;
import com.LoanManagementSystem.Dao.LoanDao;
import com.LoanManagementSystem.Dao.Impl.UserDaoImpl;
import com.LoanManagementSystem.Service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private  LoanDao loanDao;
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private EMIDao emiDao;

	@Override
	public Object CreateLoan(Map<String, Object> map) throws Exception {
		map.put("interestRate", "12");
		map.put("principleAmount", map.get("loanAmount"));
		List<?>  list=(List<?>) userDaoImpl.findAlll(Integer.parseInt((String)map.get("userId")));
		if(!list.isEmpty()) {
			 loanDao.CreateLoan(map);
			
		}else {
			throw new Exception("Invalid User");
		}
		HashMap<String, Object> hm=new HashMap<>();	
		float remaining=Integer.parseInt((String)map.get("principleAmount"))*12/100+Integer.parseInt((String)map.get("principleAmount"));
		float Principal_Emi=remaining/Integer.parseInt((String)map.get("tenure"));
		float Principle_remaining=remaining-Principal_Emi;
		float Interest_Emi=(Integer.parseInt((String)map.get("principleAmount"))*12/100)/12;
		float pi=Principal_Emi-Interest_Emi;
		float totalEmi=0.0f; 
		System.out.println(Principal_Emi);
		hm.put("Loan_Id", map.get("loanId"));
		hm.put("EMI_Amount", Principle_remaining);
		hm.put("Principal_Emi", pi);
		hm.put("Interest_EMI", Interest_Emi);
		hm.put("Total_EMI", Principal_Emi);
		hm.put("EMI_Date", new Date().toString());
		hm.put("Principal_Amount_Remaining", Principle_remaining);
		emiDao.crateEmi(hm);
		return null;
	}

}
