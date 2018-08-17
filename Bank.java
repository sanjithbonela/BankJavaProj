import java.util.*;
import java.text.*;
public class Bank {
	public static void main(String[] args)throws Exception{
		Scanner g=new Scanner(System.in);
		int AcInput;
		ArrayList<Account> account = new ArrayList<Account>();
		
		Date curDate; 
		System.out.println("------------------------------");
		System.out.println(" Welcome to Bank of Freeze!!! ");
		System.out.println("------------------------------");
		int i, ind=0, flag1=0, flag2=0, flag3=0, flag4=0, flag5=0;
		double dAmt, wAmt;
		String nm, add, usn, pass, dep, pan, acNo, accType;
		Customer c; long mob;		
		Account acc, creditor=null;
		
		while(true){
			System.out.println("Enter your choice:");
			System.out.println("1. New Account Opening?");
			System.out.println("2. Existing User?");
			System.out.println("3. Remove Account?");
			System.out.println("4. Exit");
			int choice = g.nextInt();
			g.nextLine();
			switch(choice){
			case 1:
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
				acc=new Account();
				acc.setC(c);
				acc.setAccNo();
				System.out.println("Enter your User Name:");
				usn=g.nextLine();
				for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)==true){ flag5=1; break;}
				while(flag5==1){
					System.out.println("User Name already exist! Try other.");
					System.out.println("Enter your User Name:");
					usn=g.nextLine();
					flag5=0;
					for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)){ flag5=1; break;}
				}
				acc.setUserName(usn);
				System.out.println("Enter your Password:");
				pass=g.nextLine();
				acc.setPassword(pass);
				System.out.println("Enter your Account Type - Savings or Current.");
				accType=g.nextLine();
				acc.setAccType(accType);
				System.out.println(acc.getAccType().toUpperCase()+" Account Successfully Created!!!");
				System.out.println("Your account Number is "+acc.getAccNo());
				curDate=new Date();
				String DateToStr = DateFormat.getInstance().format(curDate);
				System.out.println("To activate your account, please deposit Rs. 500/-");
				System.out.println("Do you want to deposit (Y/N)?");
				dep=g.nextLine();
				if(dep.equals("Y")){
					acc.setAct(dep);
					System.out.println("Congratulations!! Your account activated successfully.");
					acc.setBalance(500);
				}
				account.add(acc);
				break;
				
			case 2:
				System.out.println("Please enter your User Name:");
				usn=g.nextLine();
				System.out.println("Please enter your Password");
				pass=g.nextLine();
				for(i=0;i<account.size();i++){
					if(account.get(i).validate(usn, pass)){
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
						else if(account.get(i).Activate()==true){
							acc = account.get(i);
							while(true){
							System.out.println("Successfully Logged in");
							System.out.println("Welcome to the Portal, "+account.get(i).getC().getName()+".");
							System.out.printf("Your Balance is Rs.%.2f\n", account.get(i).getBalance());
							flag3=1;
							// ---Account Menu----
							System.out.println("1. Deposit Amount.");
							System.out.println("2. Withdraw Amount.");
							System.out.println("3. Transfer Amount.");
							System.out.println("4. Show Mini Statement.");
							System.out.println("5. Apply for Loans.");
							System.out.println("6. Update Details.");
							System.out.println("7. View Details.");
							System.out.println("8. Log Out.");
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
								System.out.println("Benificiary A/C number :");
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
								break;
							case 6:
								acc.updateDetails();
								break;
							case 7:
								acc.getDetails();
								break;
							case 8:
								System.out.println("Successfully Logged out!!");
								flag1=1;
								break;
							default:
								System.out.println("Invalid Input. Enter correct Choice.");
								break;
							}
							if(flag1==1) break;
						}
						}
					}
				}
				if((flag3==0)&&(flag4==0)) System.out.println("Oops!! Wrong User Name or Password.\nContact admin to recover your credentials.");
				else{
					
				}
				break;
				
			case 3:
				flag2=1;
				break;
				
			case 4:
				flag2=1;
				
				break;
			}
			System.out.println("**********************************************************************************");
			if(flag2==1) break;
		}
	}
}