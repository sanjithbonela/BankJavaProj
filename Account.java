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
	//private float SancLoanAmt;
	private String dt;
	private ArrayList<Transaction> t=new ArrayList<Transaction>();
	
	public void setAccNo(){
		accNo = "2018FREEZE00000" + String.valueOf(rand);
		rand++;
	}
	public void setUserName(String s){
		userName=s;
	}
	public void setPassword(String p){
		password=p;
		dt=DateFormat.getInstance().format(new Date());
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
		addTransaction(1,d);
		balance+=d;
		System.out.printf("Amount Rs %.2f successfully deposited.\n",d);
	}
	public void withDraw(double d){
		if(balance<d) System.out.println("Sorry!! Insufficient Funds.");
		else {
			balance-=d;
			addTransaction(2,d);
			System.out.printf("Amount Rs %.2f successfully withdrawn.",d);
		}
	}
	public void Transfer(double d, String bid){
		if(balance<d) System.out.println("Sorry!! Insufficient Funds.");
		else {
			balance-=d;
			addTransaction(3,d);
			System.out.println("Amount Successfully Transferred to "+bid);
		}
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
	public void addTransaction(int n, double amt){
		Transaction tr = null;
		if(n==1) tr=new Transaction("Deposit",amt);
		else if(n==2) tr=new Transaction("Withdraw",amt);
		else if(n==3) tr=new Transaction("Transfer",amt);
		if(t.size()<15) t.add(tr);
		else{
			t.remove(0);
			t.add(tr);
		}
	}
	public ArrayList<Transaction> getTList(){
		return t;
	}
	public void displayTransReport(){
		int i;
		for(i=0;i<t.size();i++){
			System.out.println("Transaction ID:"+t.get(i).getTid()+", Transaction Type:"+t.get(i).getType()+", Amount:"+t.get(i).getAmt()+", Date:"+t.get(i).getDt());
		} 
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