package application;

public class Sale_order {

	private int order_ID;
	private int customer_ID;
	private int p_No;
	private double down_payment;
	private int quantity;
	private int r_ID;

	public Sale_order(int order_ID, int customer_ID, int p_No, double down_payment, int quantity, int r_ID) {
		super();
		this.order_ID = order_ID;
		this.customer_ID = customer_ID;
		this.p_No = p_No;
		this.down_payment = down_payment;
		this.quantity = quantity;
		this.r_ID = r_ID;
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getP_No() {
		return p_No;
	}

	public void setP_No(int p_No) {
		this.p_No = p_No;
	}

	public double getDown_payment() {
		return down_payment;
	}

	public void setDown_payment(double down_payment) {
		this.down_payment = down_payment;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getR_ID() {
		return r_ID;
	}

	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}

}