package BankJavaProj;
import java.util.*;

public class Loan {
	//private Account acc;
	/*
		Scheme defines the threshold for different min limits of loan for 
		each category i.e., Individual loan[0], house loan[1] and Auto Loan[2] for
		each segment i.e., Savings A/C[0] & Current A/C.[1]
	*/
	private double[][][] scheme = new double[2][3][3]; // [AcType][LoanType][Schemes]
	private double[][][] interest = new double[2][3][3]; // [AcType][LoanType][interestRates]
	private double[][][] maxLoanAmt = new double[2][3][3]; // [AcType][LoanType][MaxLimit]
	private double amt = 0;
	// -- Aggregate Loan Report for Bank Manager
	private ArrayList<LoanReport> lr = new ArrayList<LoanReport>();
	public static String s="";
	public static double in=0;
	
	public void setLr(ArrayList<LoanReport> l){
		lr=new ArrayList<LoanReport>(l);
	}
	public void setScheme(double[][][] a){
		scheme=a;
	}
	public void setMaxLoanAmt(double[][][] a){
		maxLoanAmt=a;
	}
	public void setInterest(double[][][] a){
		interest=a;
	}
	public ArrayList<LoanReport> getLr(){
		return lr;
	}
	public double[][][] getScheme(){
		return scheme;
	}
	public double[][][] getMaxLoanAmt(){
		return maxLoanAmt;
	}
	public double[][][] getInterest(){
		return interest;
	}
	//------------------------------Sanjit Loan Interface--------------------------------
	/*public void addLoan(){
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
	*/
	//-----------------------------------------------------------------------------------
	public void printLoanReceipt( LoanReport report ){
		System.out.println("\n\n########################### LOAN RECEIPT ###########################");
		System.out.println("$ Loan Id : "+report.getLoanId()+"   Date : "+report.getDt() );
		System.out.println("$ Name : "+report.getName()+ "  A/C No: "+report.getAccNo() );
		System.out.println("$ Loan Type : "+report.getLoanType() );
		System.out.println("$ Loan Amount : Rs."+ report.getLoanAmt() +"    Slab : "+ report.getSlab() );
		System.out.println("$ Interest Rate : "+ report.getInterest() + "%   Repay Amount : Rs." + report.getRepayAmt());
		System.out.println("====================================================================\n\n");
	}

	public void loanProcessing(Account acc, String loanType){
		String acType = acc.getAccType();
		Scanner in = new Scanner(System.in);
		ArrayList<LoanReport> lst = null ;
		double bal = acc.getBalance();
		boolean excptn = false;
		LoanReport newLoan;
		double amt=0, limit;
		double aggLoan = 0;
		int slab = -1;
		int lType = -1;

		if(loanType.equals("Personal")){
			lType = 0;
			lst = acc.getAll_SpecificLoan_Reports("Personal");
		}else if(loanType.equals("Property")){
			lType = 1;
			lst = acc.getAll_SpecificLoan_Reports("Property");
		}else if(loanType.equals("Auto")){
			lType = 2;
			lst = acc.getAll_SpecificLoan_Reports("Auto");
		}

		// calculating existing Loan Amt.
		if( !lst.isEmpty() ){
			for(LoanReport rep: lst){
				if( rep.getStatus().equals("Approved") ){
					aggLoan += rep.getLoanAmt();
				}
			}
		}

		if( acType.equals("Savings") ){

			// Getting Appropriate Slab
			if( bal < scheme[0][0][0] ){
				slab = -1;			
			}else if( bal>=scheme[0][lType][0] && bal<scheme[0][lType][1] ){
				slab = 0;
			}else if( bal>=scheme[0][lType][1] && bal<scheme[0][lType][2] ){
				slab = 1;
			}else if( bal>=scheme[0][lType][2] && bal<scheme[0][lType][3] ){
				slab = 2;
			}

			if( slab >= 0 ){
				if( aggLoan <  maxLoanAmt[0][lType][slab] ){
					limit = maxLoanAmt[0][lType][slab] - aggLoan;
					System.out.println("Current Loan Limit: Rs."+limit);
					do{
						try{
							System.out.print("\nRequest for Loan Amount : ");					
							amt = in.nextDouble();
							excptn = false;
						}catch(InputMismatchException e){
							System.out.println("Invalid Input. Try Again.");
							in.nextLine();
							excptn = true;
						}
					}while(excptn);
					
					if( amt > 0 && amt<= limit ){	
						System.out.println("Processing... Pls Wait.");
						newLoan = new LoanReport(acc.getC().getName() , acc.getAccNo(), loanType, slab, interest[0][lType][slab] ,amt, "Savings", acc.getAccNo() );
						acc.addLoan(newLoan);
						lr.add(newLoan);
						System.out.println("Loan Approved!!!");
						printLoanReceipt(newLoan);
					}else if(amt > limit){
						System.out.println("Your Request is beyond the limit. Loan Denied.");
					}else{
						System.out.println("Invalid Input.");
					}

				}else{
					System.out.println("Loan limit Exceeded. Loan can't be Approved.");
				}

			}else{
				System.out.println("You don't Have sufficient balance. Loan Denied.");
			}

			System.out.println("Redirecting to main menu...");

		}else if( acType.equals("Current") ){
			// Getting Appropriate Slab
			if( bal < scheme[1][lType][0] ){
				slab = -1;			
			}else if( bal>=scheme[1][lType][0] && bal<scheme[1][lType][1] ){
				slab = 0;
			}else if( bal>=scheme[1][lType][1] && bal<scheme[1][lType][2] ){
				slab = 1;
			}else if( bal>=scheme[1][lType][2] && bal<scheme[1][lType][3] ){
				slab = 2;
			}

			if( slab >= 0 ){
				if( aggLoan <  maxLoanAmt[1][lType][slab] ){
					limit = maxLoanAmt[1][lType][slab] - aggLoan;
					System.out.println("Current Loan Limit: Rs."+limit);
					do{
						
						try{
							System.out.print("\nRequest for Loan Amount : ");					
							amt = in.nextDouble();
							excptn = false;
						}catch(InputMismatchException e){
							System.out.println("Invalid Input. Try Again.");
							in.nextLine();
							excptn = true;
						}

					}while(excptn);

					if( amt > 0 && amt<= limit ){	
						System.out.println("Processing... Pls Wait.");
						newLoan = new LoanReport(acc.getC().getName() , acc.getAccNo(), loanType, slab, interest[1][lType][slab] ,amt, "Current", acc.getAccNo() );
						acc.addLoan(newLoan);
						lr.add(newLoan);
						System.out.println("Loan Approved!!!");
						printLoanReceipt(newLoan);
					}else if(amt > limit){
						System.out.println("Your Request is beyond the limit. Loan Denied.");
					}else{
						System.out.println("Invalid Input.");
					}

				}else{
					System.out.println("Loan limit Exceeded. Loan can't be Approved.");
				}

			}else{
				System.out.println("You don't Have sufficient balance. Loan Denied.");
			}

			System.out.println("Redirecting to main menu...");
		}

	}
	
	public void interfaceApp( Account acc ){
		Scanner in = new Scanner(System.in);
		int mxAttempt=3, attempt=0, diff;
		boolean excptn = false;
		int resp = -1;

		diff = mxAttempt - attempt;
		while(diff > 0){
			attempt++;
			diff = mxAttempt - attempt;

			System.out.println("\nChoose Your Loan Application Type >>");
			System.out.println("1. Personal Loan ");
			System.out.println("2. Property Loan ");
			System.out.println("3. Automobile Loan ");
			System.out.println("4. Exit Portal ");
			
			do{
				try{
					System.out.print("\nResponse : ");
					resp = in.nextInt();
					excptn = false;
				}catch( InputMismatchException e ){
					System.out.println("Invalid Input. Try Again.");
					in.nextLine();
					excptn = true;
				}
			}while(excptn);

			switch( resp ){
				case 1:
					loanProcessing(acc, "Personal");
					diff = 0;
					break;
				case 2:
					loanProcessing(acc, "Property");
					diff = 0;
					break;
				case 3:
					loanProcessing(acc, "Auto");
					diff = 0;
					break;
				case 4:
					diff = 0;
					break;
				default:
					System.out.println("\nWrong Input..."+ diff +" Attempts left");
					break;
			}
		}
	}

}