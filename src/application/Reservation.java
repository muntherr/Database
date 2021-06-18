package application;

import java.sql.Date;
import java.util.Calendar;

public class Reservation {
	private int R_ID;
	private int Job_ID;
	private int Customer_ID;
	private String Customer_Name;
	private String Start_date;
	private String End_date;

	public Reservation(int r_ID, int job_ID, int customer_ID,String customer_Name, String start_date, String end_date) {
		super();
		this.R_ID = r_ID;
		this.Job_ID = job_ID;
		this.Customer_ID = customer_ID;
		this.Start_date = start_date;
		this.Customer_Name = customer_Name;
		this.End_date = end_date;

	}

	public String getCustomer_Name() {
		return Customer_Name;
	}


	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}


	public int getR_ID() {
		return R_ID;
	}

	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}

	public int getJob_ID() {
		return Job_ID;
	}

	public void setJob_ID(int job_ID) {
		Job_ID = job_ID;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getStart_date() {
		return Start_date;
	}

	public void setStart_date(String start_date) {
		Start_date = start_date;
	}

	public String getEnd_date() {
		return End_date;
	}

	@Override
	public String toString() {
		return "Reservation [R_ID=" + R_ID + ", Job_ID=" + Job_ID + ", Customer_ID=" + Customer_ID + ", Start_date="
				+ Start_date + ", End_date=" + End_date + "]";
	}

	public void setEnd_date(String end_date) {
		End_date = end_date;
	}

}