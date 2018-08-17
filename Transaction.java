import java.util.*;
import java.text.*;
public class Transaction {
	private String tid;
	private String dt;
	private String type;
	private double amt;
	private static int rand;
	
	public Transaction(){}
	public Transaction(String s,double d){
		setTid();
		dt=DateFormat.getInstance().format(new Date());
		amt=d;
		type=s.toUpperCase();
	}
	public void setTid(){
		//dt.substring(0,1)+dt.substring(2,4)+dt.substring(6,8)
		//dt.substring(0,2)+dt.substring(3,5)+dt.substring(7,9)
		/*if(dt.charAt(1)=='/')	*/		
			tid="0"+"17-8-2018"+"YASHA000000"+String.valueOf(rand);
		/*else
			tid="17-8-2018"+"YASHA000000"+String.valueOf(rand);	*/
		rand++;
	}
	public double getAmt(){
		return amt;
	}
	public String getTid(){
		return tid;
	}
	public String getDt(){
		return dt;
	}
	public String getType(){
		return type;
	}
}
