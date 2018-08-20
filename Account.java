package BankJavaProj;

import java.text.*;
import java.util.*;
public class Account {
	protected String accNo;
	protected String userName;
	protected String password;
	protected String act="false";
	protected Customer c;
	protected static int rand=1;
	protected double balance=0;
	private ArrayList<LoanReport> loanBk = new ArrayList<LoanReport>();
	protected String dt;
	protected Calendar cal;
	protected ArrayList<Transaction> t=new ArrayList<Transaction>();
	protected String accType;
	/*=====================================================================
	    ----------------------- Loan Segment ---------------------------
	=====================================================================*/
	public void addLoan(LoanReport newLoan){
		loanBk.add(newLoan);
	}
	
	public ArrayList<LoanReport> getAll_SpecificLoan_Reports( String loanType ){
		ArrayList<LoanReport> lst = new ArrayList<LoanReport>();

		for(LoanReport report: loanBk){
			if(report.getLoanType().equals(loanType)){
				lst.add(report);
			}
		}

		return lst;
	}

	public void viewLoan(){
		Scanner in = new Scanner(System.in);
		int attempt = 3, count = 0, cPer = 0, cProp = 0, cAuto = 0;
		boolean masterLoop = true;
		double amtPer=0, amtProp=0, amtAuto=0;
		double amtRePer=0, amtReProp=0, amtReAuto=0;
		int ch;

		while( masterLoop ){
			System.out.println("\n\n=========View Loan(s) Portal=========");
			System.out.println("1. Personal Loan.");
			System.out.println("2. Property Loan.");
			System.out.println("3. Auto Loan.");
			System.out.println("4. Loan Summary.");
			System.out.println("5. Exit.");
			
			while(attempt > 0){
				System.out.print("\nEnter Your Choice : ");
				ch = in.nextInt();
				switch( ch ){
					case 1:
						System.out.println("\nPersonal Loan List :");
						for(LoanReport rep : loanBk){
							if( rep.getLoanType().equals("Personal")){
								count++;
								amtPer += rep.getLoanAmt();
								amtRePer += rep.getRepayAmt();
								System.out.println(count+".) Loan_Type::Personal  Loan_ID::"+rep.getLoanId()+"  Date::"+rep.getDt()+"  Loan_Amount::Rs."+rep.getLoanAmt()+"  Repay_Amount::Rs."+rep.getRepayAmt());
							}
						}
						if( count == 0 ){
							System.out.println("You have No Registered Personal Loans.\n");
						}else{
							System.out.println("Total Personal Loan Amount: Rs."+amtPer);
							System.out.println("Total Personal Loan Repay Amount: Rs."+amtRePer);
						}
						count = 0; amtPer = 0; amtRePer = 0;
						attempt = 0;
						break;
					case 2:
						System.out.println("\nProperty Loan List :");
						for(LoanReport rep : loanBk){
							if( rep.getLoanType().equals("Property")){
								count++;
								amtProp += rep.getLoanAmt();
								amtReProp += rep.getRepayAmt();
								System.out.println(count+".) Loan_Type::Personal  Loan_ID::"+rep.getLoanId()+"  Date::"+rep.getDt()+"  Loan_Amount::Rs."+rep.getLoanAmt()+"  Repay_Amount::Rs."+rep.getRepayAmt());
							}
						}
						if( count == 0 ){
							System.out.println("You have No Registered Property Loans.\n");
						}else{
							System.out.println("Total Property Loan Amount: Rs."+amtProp);
							System.out.println("Total Property Loan Repay Amount: Rs."+amtReProp);
						}
						count = 0; amtProp = 0; amtReProp = 0;
						attempt = 0;
						break;
					case 3:
						System.out.println("\nAuto Loan List :");
						for(LoanReport rep : loanBk){
							if( rep.getLoanType().equals("Auto")){
								count++;
								amtAuto += rep.getLoanAmt();
								amtReAuto += rep.getRepayAmt();
								System.out.println(count+".) Loan_Type::Auto  Loan_ID::"+rep.getLoanId()+"  Date::"+rep.getDt()+"  Loan_Amount::Rs."+rep.getLoanAmt()+"  Repay_Amount::Rs."+rep.getRepayAmt());
							}
						}
						if( count == 0 ){
							System.out.println("You have No Registered Auto Loans.\n");
						}else{
							System.out.println("Total Auto Loan Amount: Rs."+amtAuto);
							System.out.println("Total Auto Loan Repay Amount: Rs."+amtReAuto);
						}
						count = 0; amtAuto = 0; amtReAuto = 0;
						attempt = 0;	
						break;
					case 4:
						System.out.println("\nLoan Summary :");
						for(LoanReport rep : loanBk){
							if( rep.getLoanType().equals("Auto")){
								cAuto++;
								amtAuto += rep.getLoanAmt();
								amtReAuto += rep.getRepayAmt();
							}else if( rep.getLoanType().equals("Property")) {
								cProp++;
								amtProp += rep.getLoanAmt();
								amtReProp += rep.getRepayAmt();
							}else if( rep.getLoanType().equals("Personal")){
								cPer++;
								amtPer += rep.getLoanAmt();
								amtRePer += rep.getRepayAmt();
								System.out.println(count+".) Loan_Type::Personal  Loan_ID::"+rep.getLoanId()+"  Date::"+rep.getDt()+"  Loan_Amount::Rs."+rep.getLoanAmt()+"  Repay_Amount::Rs."+rep.getRepayAmt());
							}
						}
						
						System.out.println("Loan_Type::Personal  Count::"+ cPer +"  Total_Loan_Amt::Rs."+amtPer+"  Total_LoanRepay_Amt::Rs."+amtRePer);
						System.out.println("Loan_Type::Property  Count::"+ cProp +"  Total_Loan_Amt::Rs."+amtProp+"  Total_LoanRepay_Amt::Rs."+amtReProp);
						System.out.println("Loan_Type::Auto      Count::"+ cAuto +"  Total_Loan_Amt::Rs."+amtAuto+"  Total_LoanRepay_Amt::Rs."+amtReAuto);
						System.out.println("\nTotalLoanAmt : Rs."+(amtPer+amtProp+amtAuto)+ "    TotalRepayAmt : Rs."+(amtRePer+amtReProp+amtReAuto));
						amtPer=0; amtProp=0; amtAuto=0;
						amtRePer=0; amtReProp=0; amtReAuto=0;
						attempt = 0;
						break;
					case 5:
						attempt = 0;
						masterLoop = false;
						break;
					default:
						attempt--;
						if( attempt > 0)
							System.out.println("Invalid Input. Try Again. "+attempt+" attempts left.");
						else
							masterLoop = false;
						break;
				}
			}
			attempt = 3;
		}
		System.out.println("Redirecting to Customer Portal...\n");

	}

	public void settleLoan(){
		
	}
	//=====================================================================
	public void setAccNo(){
		accNo = "2018FREEZE00000" + String.valueOf(rand);
		rand++;
	}
	public void setUserName(String s){
		userName=s;
	}
	public void setPassword(String p){
		password=p;
		cal = Calendar.getInstance();
		dt=DateFormat.getInstance().format(new Date());
	}
	public void setC(Customer n){
		//c = new Customer(n.getName(), n.getMobNo(), n.getAddress(), n.getPAN());
		c = n;
	}
	public void setAct(String s){
		act=s;
	}
	public void setBalance(double d){
		balance=d;
	}
	public void setAccType( String s ){
		accType = s;
	}

	//	public void setCThreshold(int i){
//		cThreshold = i;
//	}
//	public void setSThreshold(int i){
//		sThreshold = i;
//	}
	
	public void deposit(double d){
		addTransaction(1,d);
		balance+=d;
		System.out.printf("Amount Rs %.2f successfully deposited.\n",d);
	}
	
	public void withDraw(double d){
//	/*	if( accType.equalsIgnoreCase("Current") ){
//			CurrentAccount obj1 = new CurrentAccount();
//		}
//			/*if( balance-d < cThreshold) 
//				System.out.println("Sorry!! Insufficient Funds.");
//			else {
//				balance-=d;
//				addTransaction(2,d);
//				if( balance < 0)
//					System.out.println("You have Overdrafted Rs."+(balance*(-1)) );
//				System.out.printf("Amount Rs %.2f successfully withdrawn.",d);
//			}*/
//		}else if(accType.equalsIgnoreCase("Savings")){
//			SavingAccount obj2 = new SavingAccount();
//		}
//			/*if( balance-d < sThreshold) 
//				System.out.println("Sorry!! Insufficient Funds.");
//			else {
//				balance-=d;
//				addTransaction(2,d);
//				System.out.printf("Amount Rs %.2f successfully withdrawn.",d);
//			}*/
//		}*/
	}
	
	public void Transfer(double d, String bid, Account creditor){
		
		if( accType.equalsIgnoreCase("Current") ){
			if( balance-d < -100000) 
				System.out.println("Sorry!! Insufficient Funds.");
			else {
				balance-=d;
				addTransaction(3,d);
				if( balance < 0)
					System.out.println("You have Overdrafted Rs."+(balance*(-1)) );
				System.out.printf("Amount Rs %.2f successfully withdrawn.",d);
				creditor.deposit(d);
				System.out.println("Amount Successfully Transferred to "+bid);
			}
			
		}else if(accType.equalsIgnoreCase("Savings")){
			if( balance-d <= 0) 
				System.out.println("Sorry!! Insufficient Funds.");
			else {
				balance-=d;
				addTransaction(3,d);
				System.out.printf("Amount Rs %.2f successfully withdrawn.",d);
				creditor.deposit(d);
				System.out.println("Amount Successfully Transferred to "+bid);
			}
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
	public String getAccType(){
		return accType;
	}
	public String getDt(){
		return dt;
	}
	public Calendar getCal(){
		return cal;
	}
//	public int getCThreshold(){
//		return cThreshold;
//	}
//	public int getSThreshold(){
//		return sThreshold;
//	}
	
	public void addTransaction(int n, double amt){
		Transaction tr = null;
		
		if(n==1) {
			tr=new Transaction("Deposit",amt);
		}
		else if(n==2) {
			tr=new Transaction("Withdraw",amt);
		}
		else if(n==3) {
			tr=new Transaction("Transfer",amt);
		}
		if(t.size()<15) t.add(tr);
		else{
			t.remove(0);
			t.add(tr);
		}
	}
	public void updateDetails(){
		System.out.println("1. Update your Address?");
		System.out.println("2. Update your Phone No?");
		System.out.println("3. Update your Address & Phone No?");
		Scanner g = new Scanner(System.in);
		long l;
		int choice = g.nextInt();
		g.nextLine();
		switch(choice){
			case 1: 
				System.out.println("Enter your new Address");
				c.setAddress(g.nextLine());
				break;
			case 2:	
				System.out.println("Enter your new Phone No");
				l=g.nextLong();
				g.nextLine();
				c.setMobNo(l);
				break;
			case 3:
				System.out.println("Enter your new Phone No");
				l=g.nextLong();
				g.nextLine();
				c.setMobNo(l);
				System.out.println("Enter your new Address");
				c.setAddress(g.nextLine());
				break;
			default:
				System.out.println("Invalid Choice.");
		}
	}
	public void getDetails(){
		int i;
		System.out.println("Name: "+getC().getName());
		System.out.println("Mobile: "+getC().getMobNo());
		System.out.println("Address: "+getC().getAddress());
		System.out.println("PAN: "+getC().getPAN());
		System.out.println("Account Number: "+getAccNo());
		System.out.println("Account Type: "+getAccType());
		System.out.println("Balance: "+getBalance());
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
		if(getAct().equals("Y")) return true;
		return false;
	}
	public boolean validate(String usn, String pass){
		if(userName.equals(usn)&& password.equals(pass)) return true;
		return false;
	}
}