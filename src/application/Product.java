package application;

import java.util.*;

public class Product {

	private int prdoduct_ID;
	private double price;
	private Calendar p_Date;
	private String cleared;

	public Product(int prdoduct_ID, double price, Calendar p_Date, String cleared) {

		this.prdoduct_ID = prdoduct_ID;
		this.price = price;
		this.p_Date = p_Date;
		this.cleared = cleared;
	}

	public int getPrdoduct_ID() {
		return prdoduct_ID;
	}

	public void setPrdoduct_ID(int prdoduct_ID) {
		this.prdoduct_ID = prdoduct_ID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Calendar getP_Date() {
		return p_Date;
	}

	public void setP_Date(Calendar p_Date) {
		this.p_Date = p_Date;
	}

	public String getCleared() {
		return cleared;
	}

	public void setCleared(String cleared) {
		this.cleared = cleared;
	}

	

}