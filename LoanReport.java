import java.util.*;
import java.text.*;
public class LoanReport {
	private String name;
	private String accNo;
	private String loanType;
	private int slab;
	private float interest;
	private float loanAmt;
	private String dt;
	
	public LoanReport(String nm, String ano, String lt, int sl, float inter, float la){
		name=nm;
		accNo=ano;
		loanType=lt;
		slab=sl;
		interest=inter;
		loanAmt=la;
		dt=DateFormat.getInstance().format(new Date()); 
	}
}
