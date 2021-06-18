package application;

public class Salesmen {

	private int Job_ID;
	private String sname;
	private int S_ID;
	private String Address;
	private String Phone;

	public Salesmen(int Job_ID, String sname, int S_ID, String Address, String Phone) {
		this.Job_ID = Job_ID;
		this.sname = sname;
		this.S_ID = S_ID;
		this.Address = Address;
		this.Phone = Phone;

	}

	public String getSname() {
		return sname;
	}

	public int getS_ID() {
		return S_ID;
	}

	public int getJob_ID() {
		return Job_ID;
	}

	public String getAddress() {
		return Address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setJob_ID(int Job_ID) {
		this.Job_ID = Job_ID;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setS_ID(int S_ID) {
		this.S_ID = S_ID;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
}