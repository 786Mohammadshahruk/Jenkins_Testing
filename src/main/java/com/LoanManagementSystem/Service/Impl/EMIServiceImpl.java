package com.LoanManagementSystem.Service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoanManagementSystem.Dao.EMIDao;
import com.LoanManagementSystem.Models.EMICalculation;
import com.LoanManagementSystem.Service.EMIService;

@Service
public class EMIServiceImpl implements EMIService {

	@Autowired
	private EMIDao emiDao;

	@Override 
	public Object AddEmi(Map<String, Object> map) throws Exception {
		String loanId = map.get("loanId").toString();
		Map<String, Object> ma = new HashMap<String, Object>();
		ma.put("loanId", loanId);
		List<?> list = (List<?>) emiDao.getEmi(ma);
		System.out.println("hi");
		EMICalculation hm = (EMICalculation) list.get(0);
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("Emi_Number", hm.geteMINumber());
		hm1.put("Loan_Id", hm.getLoanId());
		hm1.put("Principal_Emi", hm.getPrinciple_EMI());
		hm1.put("Interest_EMI", hm.getInterestEMI());
		hm1.put("Total_EMI", hm.getTotalEMI());
		hm1.put("EMI_Date", new Date().toString());
		float principalRemaining = Float.parseFloat(hm.getPrincipalRemaining().toString())
				- Float.parseFloat(hm.getTotalEMI());
		hm1.put("EMI_Amount",principalRemaining );
		hm1.put("Principal_Amount_Remaining", principalRemaining);
		if(principalRemaining>0)
		emiDao.crateEmi(hm1);
		else
			throw new Exception("EMI is Completed!!!");
		return null;
	}

	@Override
	public Object getEmI(Map<String, Object> map) {
		return emiDao.getEmi(map);
	}

}
