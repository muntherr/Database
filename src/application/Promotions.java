package application;
import java.util.*;
public class Promotions {
	
	private int p_No  ;
	private	 String offers ;
	private	 Calendar starting_Date ;
	private Calendar ending_Date ;
	private int duration ;
	
	
	public Promotions(int duration,int p_No, String offers, Calendar starting_Date, Calendar ending_Date) {
		super();
		this.p_No = p_No;
		this.offers = offers;
		this.starting_Date = starting_Date;
		this.ending_Date = ending_Date;
		this.duration = duration;

	}



	public int getP_No() {
		return p_No;
	}


	public void setP_No(int p_No) {
		this.p_No = p_No;
	}


	public String getOffers() {
		return offers;
	}


	public void setOffers(String offers) {
		this.offers = offers;
	}


	public Calendar getStarting_Date() {
		return starting_Date;
	}


	public void setStarting_Date(Calendar starting_Date) {
		this.starting_Date = starting_Date;
	}


	public Calendar getEnding_Date() {
		return ending_Date;
	}


	public void setEnding_Date(Calendar ending_Date) {
		this.ending_Date = ending_Date;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
}
