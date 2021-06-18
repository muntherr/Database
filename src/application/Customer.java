package application;
public class Customer {
	private int customer_ID;
	private String C_name;

	private String Phone;
	private String  Bank_Statement;
	private String Income_Proof;
	private String Address;
	
	public Customer(int customer_ID,String cname, String phone, String bank_Statement, String income_Proof, String address ) {
		super();
		this.customer_ID = customer_ID;
		this.C_name =cname;
		this.Phone = phone;
		this.Bank_Statement = bank_Statement;
		this.Income_Proof = income_Proof;
		this.Address = address;
	}
	public Customer(String cname, String phone, String bank_Statement, String income_Proof, String address ) {
		super();
		this.C_name =cname;
		this.Phone = phone;
		this.Bank_Statement = bank_Statement;
		this.Income_Proof = income_Proof;
		this.Address = address;
	}

	@Override
	public String toString() {
		return "Customer [customer_ID=" + customer_ID + ", C_name=" + C_name + ", Phone=" + Phone + ", Bank_Statement="
				+ Bank_Statement + ", Income_Proof=" + Income_Proof + ", Address=" + Address + "]";
	}
	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	

	public String getBank_Statement() {
		return Bank_Statement;
	}

	public void setBank_Statement(String bank_Statement) {
		this.Bank_Statement = bank_Statement;
	}

	public String getIncome_Proof() {
		return Income_Proof;
	}

	public void setIncome_Proof(String income_Proof) {
		this.Income_Proof = income_Proof;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

}