public class Customer {
	private String name;
	private long mobNo;
	private String address;
	
	public Customer(){}
	public Customer(String s, long l, String add){
		name=s;
		mobNo=l;
		address=add;
	}
	
	public void setName(String s){
		name=s;
	}
	public void setMobNo(long l){
		mobNo=l;
	}
	public void setAddress(String a){
		address=a;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public long getMobNo(){
		return mobNo;
	}
}
