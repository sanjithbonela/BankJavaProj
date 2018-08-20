package BankJavaProj;

import java.util.*;
import java.text.*;
public class LoanReport {
	private String name;
	private String accNo;
	// Three types of loan >> 1. "Personal", 2."Property", 3."Auto"
	private String loanType;
	private String cType;
	private String cID;
	private String status; // "Approved", "Settled"
	private int slab;
	private double interest;
	private double loanAmt;
	private String dt;
	private String loanId;
	private static int rand=0;
	private double repayAmt;
	
	
	public String getCType() {
		return cType;
	}
	public void setStatus( String s ){
		status = s;
	}
	public String getStatus(){
		return status;
	}
	public LoanReport(){}
	public LoanReport(String nm, String ano, String lt, int sl, double inter, double la, String cType, String cID ){
		name=nm;
		accNo=ano;
		loanType=lt;
		slab=sl;
		interest=inter;
		loanAmt=la;
		dt=DateFormat.getInstance().format(new Date());
		setLoanId();
		setRepayAmt();
		setStatus("Approved");
		this.cType = cType;
		this.cID = cID;
	}
	public void setRepayAmt(){
		repayAmt = loanAmt*(100+interest)*0.01;
	}
	public double getRepayAmt(){
		return repayAmt ;
	}
	public void setName(String s){
		name=s;
	}
	public void setAccNo(String s){
		accNo=s;
	}
	public void setLoanType(String s){
		loanType=s;
	}
	public void setSlab(int a){
		slab=a;
	}
	public void setInterest(double f){
		interest=f;
	}
	public void setLoanAmt(double f){
		loanAmt=f;
	}
	public void setDt(){
		dt=DateFormat.getInstance().format(new Date());
	}
	public void setLoanId(){
		//if(dt.charAt(1)=='/')
			loanId="2018"+"MONDAL000000"+String.valueOf(rand);
		//else
			//loanId=dt.substring(0,2)+dt.substring(3,5)+dt.substring(7,9)+"MONDAL000000"+String.valueOf(rand);	
		rand++;
	}
	public String getLoanId(){
		return loanId;
	}
	public String getName(){
		return name;
	}
	public String getAccNo(){
		return accNo;
	}
	public String getLoanType(){
		return loanType;
	}
	public String getDt(){
		return dt;
	}
	public int getSlab(){
		return slab;
	}
	public double getInterest(){
		return interest;
	}
	public double getLoanAmt(){
		return loanAmt;
	}
}