package com.LoanManagementSystem.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
	
private static final long serialVersionUID = 1L;
	@Id
	@Column(name="LoanId")
	private int loanId;
	
	
	@Column(name="UserId")
	private int userId;
	
	@Column(name="LoanTitle")
	private String loanTitle;
	
	@Column(name="InterestRate")
	private String interestRate;
	
	@Column(name="Tenure")
	private String tenure;
	
	@Column(name="LoanAmount")
	private String loanAmount;
	
	@Column(name="PrincipleAmount")
	private String principleAmount;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanTitle() {
		return loanTitle;
	}

	public void setLoanTitle(String loanTitle) {
		this.loanTitle = loanTitle;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPrincipleAmount() {
		return principleAmount;
	}

	public void setPrincipleAmount(String principleAmount) {
		this.principleAmount = principleAmount;
	}

	@Override
	public String toString() {
		return "Loan [userId=" + userId + ", loanId=" + loanId + ", loanTitle=" + loanTitle + ", interestRate="
				+ interestRate + ", tenure=" + tenure + ", loanAmount=" + loanAmount + ", principleAmount="
				+ principleAmount + "]";
	}

	public Loan(int userId, int loanId, String loanTitle, String interestRate, String tenure, String loanAmount,
			String principleAmount) {
		super();
		this.userId = userId;
		this.loanId = loanId;
		this.loanTitle = loanTitle;
		this.interestRate = interestRate;
		this.tenure = tenure;
		this.loanAmount = loanAmount;
		this.principleAmount = principleAmount;
	}
	
	public Loan() {
	}
	

}
