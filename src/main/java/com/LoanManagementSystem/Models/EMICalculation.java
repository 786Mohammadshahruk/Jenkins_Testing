package com.LoanManagementSystem.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "emicalculation")
public class EMICalculation implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "Loan_Id")
	private int loanId;
	
	@Column(name = "EMI_Amount")
	private String eMIAmount;
	
	@Id @GeneratedValue
	@Column(name = "EMI_Number")
	private String eMINumber;
	
	@Column(name = "Principle_EMI")
	private String principle_EMI;
	
	@Column(name = "Interest_EMI")
	private String interestEMI;
	
	@Column(name = "Total_EMI")
	private String totalEMI;
	
	@Column(name = "EMI_Date")
	private String eMIDate;
	
	@Column(name = "PrincipalRemaining")
	private String principalRemaining;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String geteMIAmount() {
		return eMIAmount;
	}

	public void seteMIAmount(String eMIAmount) {
		this.eMIAmount = eMIAmount;
	}

	public String geteMINumber() {
		return eMINumber;
	}

	public void seteMINumber(String eMINumber) {
		this.eMINumber = eMINumber;
	}

	public String getPrinciple_EMI() {
		return principle_EMI;
	}

	public void setPrinciple_EMI(String principle_EMI) {
		this.principle_EMI = principle_EMI;
	}

	public String getInterestEMI() {
		return interestEMI;
	}

	public void setInterestEMI(String interestEMI) {
		this.interestEMI = interestEMI;
	}

	public String getTotalEMI() {
		return totalEMI;
	}

	public void setTotalEMI(String totalEMI) {
		this.totalEMI = totalEMI;
	}

	public String geteMIDate() {
		return eMIDate;
	}

	public void seteMIDate(String eMIDate) {
		this.eMIDate = eMIDate;
	}

	public String getPrincipalRemaining() {
		return principalRemaining;
	}

	public void setPrincipalRemaining(String principalRemaining) {
		this.principalRemaining = principalRemaining;
	}

	@Override
	public String toString() {
		return "EMICalculation [loanId=" + loanId + ", eMIAmount=" + eMIAmount + ", eMINumber=" + eMINumber
				+ ", principle_EMI=" + principle_EMI + ", interestEMI=" + interestEMI + ", totalEMI=" + totalEMI
				+ ", eMIDate=" + eMIDate + ", principalRemaining=" + principalRemaining + "]";
	}

	public EMICalculation(int loanId, String eMIAmount, String eMINumber, String principle_EMI, String interestEMI,
			String totalEMI, String eMIDate, String principalRemaining) {
		super();
		this.loanId = loanId;
		this.eMIAmount = eMIAmount;
		this.eMINumber = eMINumber;
		this.principle_EMI = principle_EMI;
		this.interestEMI = interestEMI;
		this.totalEMI = totalEMI;
		this.eMIDate = eMIDate;
		this.principalRemaining = principalRemaining;
	}
	public EMICalculation() {
	}
	
	
	

}
