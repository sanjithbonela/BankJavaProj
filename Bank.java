import java.util.*;
public class Bank {
	public static void main(String[] args)throws Exception{
		Scanner g=new Scanner(System.in);
		System.out.println("------------------------------");
		System.out.println(" Welcome to Bank of Freeze!!! ");
		System.out.println("------------------------------");
		int i, ind=0, flag1=0, flag2=0, flag3=0, flag4=0, flag5=0;
		String nm, add, usn, pass, dep;
		Customer c; long mob;
		ArrayList<Account> account = new ArrayList<Account>();
		Account acc;
		while(true){
			System.out.println("Enter your choice:");
			System.out.println("1. New Account Opening?");
			System.out.println("2. Existing User?");
			System.out.println("3. Exit");
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
				c=new Customer(nm,mob,add);
				acc=new Account();
				acc.setC(c);
				acc.setAccNo();
				System.out.println("Enter your User Name:");
				usn=g.nextLine();
				acc.setUserName(usn);
				System.out.println("Enter your Password:");
				pass=g.nextLine();
				acc.setPassword(pass);
				for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)==true) flag5=1;
				while(flag5==1){
					System.out.println("User Name already exist! Try other.");
					System.out.println("Enter your User Name:");
					acc.setUserName(g.nextLine());
					System.out.println("Enter your Password:");
					acc.setPassword(g.nextLine());
					flag5=0;
					for(i=0;i<account.size();i++) if(account.get(i).getUserName().equals(usn)){ flag5=1; break;}
				}
				System.out.println("Account Successfully Created!!!");
				System.out.println("Your account Number is "+acc.getAccNo());
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
						//System.out.println("Line 36");
						if(account.get(i).Activate()==false){
							//System.out.println("Line 38");
							System.out.println(account.get(i).getC().getName()+", You need to activate your account to perform transactions.");
							System.out.println("Do you want to deposit Rs.500 for activation (Y/N)?");
							dep=g.nextLine();
							if(dep.equals("Y")){
								account.get(i).setAct(dep);
								account.get(i).setBalance(500);
								System.out.println("Congratulations!! Your account activated successfully.");
								System.out.println("Re-Login to perform transactions");
								flag4=1;
							}
							else break;
						}
						else if(account.get(i).Activate()==true){
							System.out.println("Successfully Logged in");
							System.out.println("Welcome to the Portal, "+account.get(i).getC().getName()+".");
							System.out.printf("Your Balance is Rs.%.2f\n", account.get(i).getBalance());
							flag3=1;
						}
					}
				}
				if((flag3==0)&&(flag4==0)) System.out.println("Oops!! Wrong User Name or Password.\nContact admin to recover your credentials.");
				break;
				
			case 3:
				flag2=1;
				break;	
			}
			System.out.println("**********************************************************************************");
			if(flag2==1) break;
		}
	}
}
