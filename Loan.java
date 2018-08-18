package BankJavaProj;
import java.util.*;

public class Loan {
	private Account acc;
	/*
		Scheme defines the threshold for different min limits of loan for 
		each category i.e., Individual loan, house loan and Auto Loan for
		each segment i.e., Savings A/C & Current A/C.
	*/
	private double [][] scheme = new double[3][4];
	private double[][] interest = new double[3][4];
	private double amt = 0;
	// -- Aggregate Loan Report for Bank Manager
	private ArrayList<LoanReport> lr = new ArrayList<LoanReport>();
	public static String s="";
	public static double in=0;
	
	public void setLr(ArrayList<LoanReport> l){
		lr=new ArrayList<LoanReport>(l);
	}
	public void setScheme(double[][] a){
		scheme=a;
	}
	public void setInterest(double[][] a){
		interest=a;
	}
	public ArrayList<LoanReport> getLr(){
		return lr;
	}
	public void setAcc(Account a){
		acc=a;
	}
	public double[][] getScheme(){
		return scheme;
	}
	public double[][] getInterest(){
		return interest;
	}
	public Account getAcc(){
		return acc;
	}
	public void addLoan(){
		LoanReport r = new LoanReport(acc.getC().getName(),acc.getAccNo(),s,1,in,amt);
		lr.add(r);
	}
	public void displayReport(){
		int i=0;
		System.out.println("Your Loan Report:");
		for(i=0;i<lr.size();i++){
			System.out.println("Name:"+lr.get(i).getName()+", Account Number:"+lr.get(i).getAccNo()+", Loan Type:"+lr.get(i).getLoanType()+", Loan Id:"+lr.get(i).getLoanId()+", Loan Amount:"+lr.get(i).getLoanAmt()+", Interest:"+lr.get(i).getInterest()+", Date & Time:"+lr.get(i).getDt());
		}
		if(i==0) System.out.println("No Loans pending!!");
	}
	public void removeLoan(String lid){
		int i;
		for(i=0;i<lr.size();i++){
			if(lr.get(i).getLoanId().equals(lid)){
				lr.remove(i);
				break;
			} 
		}
	}
	public double calculateLoanAmount(){
		Scanner g=new Scanner(System.in);
		System.out.println("Choose the loan you want.");
		System.out.println("1.Housing Loan");
		System.out.println("2.Personal Loan");
		System.out.println("3.Auto Loan");
		int no=g.nextInt();
		g.nextLine();
		if(no==1){
			s="Housing";
			if(acc.getBalance()<scheme[0][0]){
				amt=interest[0][0]*acc.getBalance()*0.01f;
				in=interest[0][0];
			}
			else if((acc.getBalance()>=scheme[0][0])&&(acc.getBalance()<scheme[0][1])){
				amt=interest[0][1]*acc.getBalance()*0.01f;
				in=interest[0][1];
			}
			else if((acc.getBalance()>=scheme[0][1])&&(acc.getBalance()<scheme[0][2])){
				amt=interest[0][2]*acc.getBalance()*0.01f;
				in=interest[0][2];
			}
			else if((acc.getBalance()>=scheme[0][2])&&(acc.getBalance()<scheme[0][3])){
				amt=interest[0][3]*acc.getBalance()*0.01f;
				in=interest[0][3];
			}
			else if((acc.getBalance()>=scheme[0][3])){
				amt=interest[0][4]*acc.getBalance()*0.01f;
				in=interest[0][4];
			}
		}
		else if(no==2){
			s="Personal";
			if(acc.getBalance()<scheme[1][0]){
				amt=interest[1][0]*acc.getBalance()*0.01f;
				in=interest[1][0];
			}
			else if((acc.getBalance()>=scheme[1][0])&&(acc.getBalance()<scheme[1][1])){
				amt=interest[1][1]*acc.getBalance()*0.01f;
				in=interest[1][1];
			}
			else if((acc.getBalance()>=scheme[1][1])&&(acc.getBalance()<scheme[1][2])){
				amt=interest[1][2]*acc.getBalance()*0.01f;
				in=interest[1][2];
			}
			else if((acc.getBalance()>=scheme[1][2])&&(acc.getBalance()<scheme[1][3])){
				amt=interest[1][3]*acc.getBalance()*0.01f;
				in=interest[1][4];
			}
			else if((acc.getBalance()>=scheme[1][3])){
				amt=interest[1][4]*acc.getBalance()*0.01f;
				in=interest[1][4];
			}
		}
		else if(no==3){
			s="Auto";
			if(acc.getBalance()<scheme[2][0]){
				amt=interest[2][0]*acc.getBalance()*0.01f;
				in=interest[2][0];
			}
			else if((acc.getBalance()>=scheme[2][0])&&(acc.getBalance()<scheme[2][1])){
				amt=interest[2][1]*acc.getBalance()*0.01f;
				in=interest[2][1];
			}
			else if((acc.getBalance()>=scheme[2][1])&&(acc.getBalance()<scheme[2][2])){
				amt=interest[2][2]*acc.getBalance()*0.01f;
				in=interest[2][2];
			}
			else if((acc.getBalance()>=scheme[2][2])&&(acc.getBalance()<scheme[2][3])){
				amt=interest[2][3]*acc.getBalance()*0.01f;
				in=interest[2][3];
			}
			else if((acc.getBalance()>=scheme[2][3])){
				amt=interest[2][4]*acc.getBalance()*0.01f;
				in=interest[2][4];
			}
		}	
		return amt;
	}
	
	public void interface( Account acc ){
		int mxAttempt=3, attempt=0, diff;
		int resp;

		diff = mxAttempt - attempt;
		while(diff > 0){
			attempt++;

			System.out.println("\nChoose Your Loan Application Type >>");
			System.out.println("1. Personal Loan ");
			System.out.println("2. Property Loan ");
			System.out.println("3. Automobile Loan ");
			System.out.println("4. Exit Portal ");
			System.out.print("\nResponse : ");
			resp = in.nextInt();

			switch( resp ){
				case 1:
					diff = 0;
					break;
				case 2:
					diff = 0;
					break;
				case 3:
					diff = 0;
					break;
				case 4:
					break;
				default:
					System.out.println("\nWrong Input..."+ diff +" Attempts left");
					break;
			}
		}

	}

}