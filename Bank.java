package BankJavaProj;

import java.util.*;
import java.text.*;

public class Bank {
	public static Account createAccount(ArrayList<Account> account){
		Scanner g=new Scanner(System.in);
		int i, ind=0, flag1=0, flag2=0, flag3=0, flag4=0, flag5=0;
		double dAmt, wAmt;
		String nm, add, usn, pass, dep, pan, acNo, accType;
		Customer c; long mob;		
		Account acc=new Account();
		Date curDate;

		System.out.println("Enter your Name:");
		nm=g.nextLine();
		System.out.println("Enter your Address:");
		add=g.nextLine();
		System.out.println("Enter your Mobile Number:");
		mob=g.nextLong();
		g.nextLine();
		System.out.println("Enter your PAN Number:");
		pan=g.nextLine();
		c=new Customer(nm,mob,add,pan);
		System.out.println("Set User Name:");
		usn=g.nextLine();
		for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)==true){ flag5=1; break;}
		while(flag5==1){
			System.out.println("User Name already exist! Try other.");
			System.out.println("Set User Name:");
			usn=g.nextLine();
			flag5=0;
			for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)){ flag5=1; break;}
		}
		
		System.out.println("Set Password:");
		pass=g.nextLine();
		System.out.println("Enter your Account Type - Savings or Current.");
		accType=g.nextLine();
		if(accType.equalsIgnoreCase("Current")){
			acc = new CurrentAccount();
			((CurrentAccount)acc).setAccNo();
			((CurrentAccount)acc).setC(c);
			((CurrentAccount)acc).setUserName(usn);
			((CurrentAccount)acc).setPassword(pass);
			((CurrentAccount)acc).setAccType(accType);
			System.out.println(acc.getAccType().toUpperCase()+" Account Successfully Created!!!");
			System.out.println("Your account Number is "+((CurrentAccount)acc).getAccNo());
			curDate=new Date();
			String DateToStr = DateFormat.getInstance().format(curDate);
			System.out.println("To activate your account, please deposit Rs. 500/-");
			System.out.println("Do you want to deposit (Y/N)?");
			dep=g.nextLine();
			if(dep.equalsIgnoreCase("Y")){
				acc.setAct(dep);
				System.out.println("Congratulations!! Your account activated successfully.");
				acc.deposit(500);
			}
		}
		else if(accType.equalsIgnoreCase("Savings")){
			acc=new SavingAccount();
			((SavingAccount)acc).setAccNo();
			((SavingAccount)acc).setC(c);
			((SavingAccount)acc).setUserName(usn);
			((SavingAccount)acc).setPassword(pass);
			((SavingAccount)acc).setAccType(accType);
			System.out.println(acc.getAccType().toUpperCase()+" Account Successfully Created!!!");
			System.out.println("Your account Number is "+((SavingAccount)acc).getAccNo());
			curDate=new Date();
			String DateToStr = DateFormat.getInstance().format(curDate);
			System.out.println("To activate your account, please deposit Rs. 500/-");
			System.out.println("Do you want to deposit (Y/N)?");
			dep=g.nextLine();
			if(dep.equalsIgnoreCase("Y")){
				acc.setAct(dep);
				System.out.println("Congratulations!! Your account activated successfully.");
				acc.deposit(500);
			}
		}
		return acc;
	}
	
	public static void accountOperation(ArrayList<Account> account) {
		Scanner g = new Scanner(System.in);
		String usn, pass, dep, acNo;
		double dAmt, wAmt;
		Account acc, creditor=null;
		int i, AcInput;
		int flag1=0, flag3=0, flag4=0, flag5=0;
		int curday,accday,curmonth,accmonth,curyear,accyear,curhour,acchour,curminute,accminute;
		Calendar cal;
		
		System.out.println("Please enter your User Name:");
		usn=g.nextLine();
		System.out.println("Please enter your Password");
		pass=g.nextLine();
		for(i=0;i<account.size();i++){			
			if(account.get(i).validate(usn, pass)){	
				//----Check For If A/C Activation Status Is False?-----
				if(account.get(i).Activate()==false){
					System.out.println(account.get(i).getC().getName()+", You need to activate your account to perform transactions.");
					System.out.println("Do you want to deposit Rs.500 for activation (Y/N)?");
					dep=g.nextLine();
					if(dep.equals("Y")){
						account.get(i).setAct(dep);
						account.get(i).setBalance(500);
						System.out.println("Congratulations!! Your account activated successfully.");
						System.out.println("Re-Login to perform transactions");
						flag4=1;
						break;
					}
				}
				//----If A/C Is Activated-----
				else if(account.get(i).Activate()==true){
					acc = account.get(i);
					while(true){
						System.out.println("Successfully Logged in");
						System.out.println("Welcome to the Portal, "+account.get(i).getC().getName()+".");
						System.out.printf("Your Balance is Rs.%.2f\n", account.get(i).getBalance());
						flag3=1;
						// ---Account Menu----
						System.out.println("========= Customer Portal =========");
						System.out.println("1. Deposit Amount.");
						System.out.println("2. Withdraw Amount.");
						System.out.println("3. Transfer Amount.");
						System.out.println("4. Show Mini Statement.");
						System.out.println("5. View Loans.");
						System.out.println("6. Close Loans.");
						System.out.println("7. Update Details.");
						System.out.println("8. View Details.");
						System.out.println("9. Remove Account");
						System.out.println("10. Log Out.");
						System.out.println("---------------------------");
						System.out.print("Enter Choice Number: ");
						AcInput = g.nextInt();
						g.nextLine();
						
						switch(AcInput){
							case 1:
								System.out.println("Enter the Deposit Amount");
								dAmt = g.nextDouble();
								account.get(i).deposit(dAmt);
								break;
							case 2:
								System.out.println("Amount to be Withdrawn");
								wAmt = g.nextDouble();
								acc.withDraw(wAmt);
								break;
							case 3:
								System.out.println("Beneficiary A/C number :");
								acNo = g.nextLine();
								for( Account a: account){
									if( a.getAccNo().equals(acNo)){
										creditor = a;
										break;
									}
									creditor = null;
								}
								System.out.println("Amount:");
								wAmt = g.nextDouble();
								acc.Transfer(wAmt, acNo, creditor);								
								break;
							case 4:
								acc.displayTransReport();
								break;
							case 5:
								acc.viewLoan(acc);
								break;
							case 6:
								acc.settleLoan(acc);
								//acc.updateDetails();
								break;
							case 7:
								acc.getDetails();
								break;
							case 8:
								cal=Calendar.getInstance();
								//DateToStr = DateFormat.getInstance().format(new Date());
								curday = cal.get(Calendar.DAY_OF_MONTH);//Integer.parseInt(DateToStr.substring(2,4));
								accday = acc.getCal().get(Calendar.DAY_OF_MONTH);//Integer.parseInt(acc.getDt().substring(2,4));
								//System.out.println("cur "+Integer.parseInt(DateToStr.substring(0,2))+" Acc "+Integer.parseInt(acc.getDt().substring(0,2)));
								curmonth = cal.get(Calendar.MONTH);//Integer.parseInt(DateToStr.substring(0,1));
								accmonth = acc.getCal().get(Calendar.MONTH);//Integer.parseInt(acc.getDt().substring(0,1));
								
								curyear = cal.get(Calendar.YEAR);//Integer.parseInt(DateToStr.substring(5,7));
								accyear = acc.getCal().get(Calendar.YEAR);//Integer.parseInt(acc.getDt().substring(5,7));
								
								curhour = cal.get(Calendar.HOUR_OF_DAY);//Integer.parseInt(DateToStr.substring(8,10));
								acchour = acc.getCal().get(Calendar.HOUR_OF_DAY);//Integer.parseInt(acc.getDt().substring(8,10));
								
								curminute = cal.get(Calendar.MINUTE);//Integer.parseInt(DateToStr.substring(11,13));
								accminute = acc.getCal().get(Calendar.MINUTE);//Integer.parseInt(acc.getDt().substring(11,13));
								
								if(accyear - curyear ==0){
									if(accmonth - curmonth ==0){
										if(accday - curday ==0){
											if(acchour - curhour ==0){
												if(curminute - accminute < 1){
													System.out.println("You need to wait 6 months after opening the account to close it.");
												}
												else {
													System.out.println("You can collect your balance at the Bank by showing required documents.");
													account.remove(i);
													flag5=1;
												}
											}
											else {
												System.out.println("You can collect your balance at the Bank by showing required documents.");
												account.remove(i);
												flag5=1;
											}
										}
										else {
											System.out.println("You can collect your balance at the Bank by showing required documents.");
											account.remove(i);
											flag5=1;
										}
									}
									else {
										System.out.println("You can collect your balance at the Bank by showing required documents.");
										account.remove(i);
										flag5=1;
									}
								}
								else {
									System.out.println("You can collect your balance at the Bank by showing required documents.");
									account.remove(i);
									flag5=1;
								}
							case 9:
								if(flag5==1){
									System.out.println("Account Successfully Removed!!");
									System.out.println("Thank you for banking with us.");
								}
								System.out.println("Successfully Logged out!!");
								flag1=1;
								break;
							default:
								System.out.println("Invalid Input. Enter correct Choice.");
								break;
						}
						if(flag1==1) 
							break;
					}
					break;
				}
			}
		}
		
		if((flag3==0)&&(flag4==0)) 
			System.out.println("Oops!! Wrong User Name or Password.\nContact admin to recover your credentials.");
		else{
			
		}
	}
	
	public static void ApplyLoan( ArrayList<Account> account, Loan loanSegment ){
		Scanner in = new Scanner(System.in);
		String resp, usn, pass;
		boolean isValidUsr = false;
		Account usrAcc = null;
		int mxAttempt=3, attempt=0, diff=3;

		System.out.println("------------------------------");
		System.out.println("    Welcome To Loan Portal    ");
		System.out.println("------------------------------");

		System.out.print("\nDo You have an Account With Us (Y/N) ? ");
		resp = in.nextLine();

		while( diff > 0 ){
			attempt++;
			diff = mxAttempt - attempt;

			if( resp.equalsIgnoreCase("Y")){
				attempt = 0;
				diff = 3;
				while( diff > 0 ){
					attempt++;
					diff = mxAttempt - attempt;

					System.out.print("User Name : ");
					usn = in.nextLine();
					System.out.print("Password : ");
					pass = in.nextLine();

					for(Account acc: account ){
						if( acc.validate(usn, pass) ){
							isValidUsr = true;
							usrAcc = acc;							
							break;
						}
					}

					if( isValidUsr && usrAcc.getAct().equals("Y") ){
						loanSegment.interfaceApp(usrAcc);
						diff = 0;
					}else if(isValidUsr){
						System.out.println("Your A/C is not activated. Pls. Activate your A/C. \nRedirecting to main menu...");
						diff = 0;
					}else{
						System.out.println("Wrong UserName or Password... "+ diff +" Attempts left.\n\n");
						if( diff == 0 ){
							System.out.println("Redirecting to main menu...\n\n");
							break;
						}
					}
				}

			}else if( resp.equalsIgnoreCase("N") ){
				System.out.println("Please Create An Account First Before Proceding Further.\nRedirecting to main menu...");
				diff = 0;
				break;
			}else{
				System.out.println("Invalid Input!! "+ diff +" Attempts Left.");
				if( diff == 0){
					System.out.println("Redirecting to main menu...\n\n");
					break;
				}else{
					System.out.print("\nResponse (Y/N) :");
					resp = in.nextLine();
				}
			}
		}

	}

	public static void removeLoan( ArrayList<Account> account ){
	}

	// ToDo - (1)
	public static void bkLoanScheme( Loan LoanSegment, int choice ){

	}

	// ToDo - (2)
	public static void bkLoanReport( Loan LoanSegment, int choice ){
		
	}

	public static void main(String[] args) throws Exception{
		Scanner g=new Scanner(System.in);
		char ch;
		ArrayList<Account> account = new ArrayList<Account>();
		Loan LoanSegment = new Loan();	
		double[][][] scheme = new double[2][3][3];
		double[][][] interest = new double[2][3][3];
		double[][][] maxLoanAmt = new double[2][3][3];
		boolean bkLoop = true, masterLoop = true;

		scheme[0][0][0] = 500000 ; scheme[0][0][1] = 1000000; scheme[0][0][2] = 1500000;
		scheme[0][1][0] = 200000; scheme[0][1][1] = 700000; scheme[0][1][2] = 1500000;
		scheme[0][2][0] = 400000; scheme[0][2][1] = 1200000; scheme[0][2][2] = 1800000;

		scheme[1][0][0] = 1500000; scheme[1][0][1] = 2500000; scheme[1][0][2] = 5000000;
		scheme[1][1][0] = 2000000; scheme[1][1][1] = 4000000; scheme[1][1][2] = 6000000;
		scheme[1][2][0] = 1500000; scheme[1][2][1] = 2500000; scheme[1][2][2] = 3500000;
		LoanSegment.setScheme(scheme);

		interest[0][0][0] = 10.01 ; interest[0][0][1] = 9.85; interest[0][0][2] = 8.62;
		interest[0][1][0] = 9.85; interest[0][1][1] = 8.62; interest[0][1][2] = 8.21;
		interest[0][2][0] = 13.25; interest[0][2][1] = 12.89; interest[0][2][2] = 12.12;

		interest[1][0][0] = 8.01; interest[1][0][1] = 7.85; interest[1][0][2] = 6.62;
		interest[1][1][0] = 8.85; interest[1][1][1] = 7.62; interest[1][1][2] = 7.21;
		interest[1][2][0] = 10.25; interest[1][2][1] = 9.89; interest[1][2][2] = 9.12;
		LoanSegment.setInterest(interest);

		maxLoanAmt[0][0][0] = 250000 ; maxLoanAmt[0][0][1] = 800000; maxLoanAmt[0][0][2] = 1000000;
		maxLoanAmt[0][1][0] = 100000; maxLoanAmt[0][1][1] = 350000; maxLoanAmt[0][1][2] = 750000;
		maxLoanAmt[0][2][0] = 200000; maxLoanAmt[0][2][1] = 600000; maxLoanAmt[0][2][2] = 900000;

		maxLoanAmt[1][0][0] = 750000; maxLoanAmt[1][0][1] = 1250000; maxLoanAmt[1][0][2] = 2500000;
		maxLoanAmt[1][1][0] = 1000000; maxLoanAmt[1][1][1] = 2000000; maxLoanAmt[1][1][2] = 3000000;
		maxLoanAmt[1][2][0] = 750000; maxLoanAmt[1][2][1] = 1300000; maxLoanAmt[1][2][2] = 1800000;
		LoanSegment.setMaxLoanAmt(maxLoanAmt);

		int choice, flag2=0;
		int attempt=0, mxAttempt=3, diff=3;
		Account acc ;

		while(masterLoop){
			System.out.println("######################################################");
			System.out.println(" -------------Welcome to DE_/\\_NAAA Bank!!!--------------");
			System.out.println("######################################################");

			System.out.println("\n        A. Bank Portal     B.Customer Portal");
			System.out.println("------------------------------------------------------");
			System.out.println("Type X to close the portal.");
			System.out.print("\nEnter your choice : ");
			ch = g.nextLine().charAt(0);

			if( ch=='A' || ch=='a'){				
				while(bkLoop){
					System.out.println("\n\n--------------Bank Portal---------------");
					System.out.println("1. Loan Scheme.");
					System.out.println("2. Get Loan Report.");
					System.out.println("3. Get %-change in loan.");
					System.out.println("4. Exit.");

					System.out.print("\nEnter your choice : ");
					choice = g.nextInt();
					g.nextLine();

					attempt=0; mxAttempt=3; diff=3;

					switch( choice ){
						case 1:
							while( diff != 0 ){
								System.out.println("1. View Loan Scheme.");
								System.out.println("2. Change Loan Scheme.");
								System.out.println("3. Exit.");
								System.out.print("Enter Your Choice : ");
								choice = g.nextInt();
								g.nextLine();

								if(  choice>0 && choice<3 ){
									bkLoanScheme( LoanSegment, choice ); // ToDo - (1)
									diff = 0;
								}else if (choice == 3){
									diff = 0;
								}else{
									diff--;
									if( diff != 0)
										System.out.println("Invalid Input. Try Again. "+diff+" Attempts remains.");
								}
							}
							System.out.println("Redirecting to Bank Portal...");
							break;
						case 2:
							while( diff != 0 ){
								System.out.println("1. Get Corporate Loan Report.");
								System.out.println("2. Get Savings Loan Report.");
								System.out.println("3. Get All Loan Reports.");
								System.out.println("4. Exit.");
								System.out.print("Enter Your Choice : ");
								choice = g.nextInt();
								g.nextLine();
								if(  choice>0 && choice<4 ){
									bkLoanReport( LoanSegment, choice ); // ToDo - (2)
									diff = 0;
								}else if( choice == 4 ){
									diff = 0;
								}else{
									diff--;
									if( diff != 0)
										System.out.println("Invalid Input. Try Again. "+diff+" Attempts remains.");
								}
							}
							System.out.println("Redirecting to Bank Portal...");
							break;
						case 3:
							break;
						case 4:
							bkLoop = false;
							break;
						default:
							System.out.println("Invalid Input. Try Again...");
							break;
					}
					System.out.println("\n");
				}
				System.out.println("**************************************************\n");
			}else if( ch=='B' || ch=='b' ){
				System.out.println("\n\n------------Customer Portal-------------\n");
				while(true){
					System.out.println("Enter your choice:");
					System.out.println("1. New Account Opening?");
					System.out.println("2. Existing User?");
					System.out.println("3. Apply for Loan?");
					System.out.println("4. Clear Loans.");
					System.out.println("5. Exit");
					choice = g.nextInt();
					g.nextLine();
					
					switch(choice){
						case 1:
							acc=createAccount(account);
							account.add(acc);
							break;				
						case 2:
							accountOperation(account, LoanSegment);
							break;				
						case 3:	
							ApplyLoan(account, LoanSegment);
							break;				
						case 4:
							removeLoan( account );				
							break;
						case 5:
							flag2=1;				
							break;
					}
					System.out.println("**********************************************************************************");
					if(flag2==1) 
						break;
				}

			}else if( ch=='X' || ch =='x' ){
				System.out.println("\n\n>>>>>>>>> Thank You for banking with Us. _/\\_ <<<<<<<<<");
				masterLoop = false;
			}else{
				System.out.println("Invalid Input. Try Again...");
			}
		}
		
	}
}
