package application;

public class Part {
	private int product_Id;
	private String MPN;
	
	
	public Part(int product_Id, String MPN) {
		this.product_Id = product_Id;
		this.MPN = MPN;
	}


	public int getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}


	public String getMPN() {
		return MPN;
	}


	public void setMPN(String mPN) {
		MPN = mPN;
	}
	

}
