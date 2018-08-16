import java.util.*;
public class Loan {
	private Account acc;
	private double [][] scheme=new double[3][4];
	private double[][] interest=new double[3][4];
	double amt; 
	
	public void setScheme(double[][] a){
		scheme=a;
	}
	public void setInterest(double[][] a){
		interest=a;
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
	public double calculateLoanAmount(){
		int i, j;
		Scanner g=new Scanner(System.in);
		System.out.println("Choose the loan you want.");
		System.out.println("1.Housing Loan");
		System.out.println("2.Personal Loan");
		System.out.println("3.Auto Loan");
		int no=g.nextInt();
		g.nextLine();
		if(no==1){
			if(acc.getBalance()<scheme[0][0]){
				amt=interest[0][0]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[0][0])&&(acc.getBalance()<scheme[0][1])){
				amt=interest[0][1]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[0][1])&&(acc.getBalance()<scheme[0][2])){
				amt=interest[0][2]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[0][2])&&(acc.getBalance()<scheme[0][3])){
				amt=interest[0][3]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[0][3])){
				amt=interest[0][4]*acc.getBalance()*0.01f;
			}
		}
		else if(no==2){
			if(acc.getBalance()<scheme[1][0]){
				amt=interest[1][0]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[1][0])&&(acc.getBalance()<scheme[1][1])){
				amt=interest[1][1]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[1][1])&&(acc.getBalance()<scheme[1][2])){
				amt=interest[1][2]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[1][2])&&(acc.getBalance()<scheme[1][3])){
				amt=interest[1][3]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[1][3])){
				amt=interest[1][4]*acc.getBalance()*0.01f;
			}
		}
		else if(no==3){
			if(acc.getBalance()<scheme[2][0]){
				amt=interest[2][0]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[2][0])&&(acc.getBalance()<scheme[2][1])){
				amt=interest[2][1]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[2][1])&&(acc.getBalance()<scheme[2][2])){
				amt=interest[2][2]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[2][2])&&(acc.getBalance()<scheme[2][3])){
				amt=interest[2][3]*acc.getBalance()*0.01f;
			}
			else if((acc.getBalance()>=scheme[2][3])){
				amt=interest[2][4]*acc.getBalance()*0.01f;
			}
		}	
		return amt;
	}
	
}
