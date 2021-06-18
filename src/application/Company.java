package application;

public class Company {
	private int customer_ID;
	private String c_Name;
	private String Address ;
	private String phone;
	

	public Company(int customer_ID, String c_Name) {
		this.customer_ID = customer_ID;
		this.c_Name = c_Name;
	}
	

	public Company(int customer_ID, String c_Name, String address, String phone) {
		super();
		this.customer_ID = customer_ID;
		this.c_Name = c_Name;
		this.Address = address;
		this.phone = phone;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

}