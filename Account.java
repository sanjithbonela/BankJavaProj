import java.text.*;
import java.util.*;
public class Account {
	private String accNo;
	private String userName;
	private String password;
	private String act="false";
	private Customer c;
	private static int rand=1;
	private double balance=0;
	private Date created;
	private float SancLoanAmt;
	
	public void setAccNo(){
		accNo = "2018FREEZE00000" + String.valueOf(rand);
		rand++;
	}
	public void setUserName(String s){
		userName=s;
	}
	public void setPassword(String p){
		password=p;
	}
	public void setC(Customer n){
		c=new Customer(n.getName(), n.getMobNo(), n.getAddress(), n.getPAN());
	}
	public void setAct(String s){
		act=s;
	}
	public void setBalance(double d){
		balance=d;
	}
	public void deposit(double d){
		balance+=d;
	}
	public double getBalance(){
		return balance;
	}
	public String getAct(){
		return act;
	}
	public String getAccNo(){
		return accNo;
	}
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public Customer getC(){
		return c;
	}
	public boolean Activate(){
		//System.out.println("Line 40");
		if(getAct().equals("Y")) return true;
		//System.out.println("Line 42");
		return false;
	}
	public boolean validate(String usn, String pass){
		if(userName.equals(usn)&& password.equals(pass)) return true;
		return false;
	}
}