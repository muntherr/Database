package application;
import java.util.Calendar;

public class Car {
    private int Product_ID;
    private String Vin;
    private String Color;
    private int Engine_Capacity;
    private String Transmission_Type;
    private String C_Type  ; 
    private String C_Brand ;
    private String  Licensed ; 

    public Car(int product_ID, String vin, String color,
            int engine_Capacity, String transmission_Type,String c_Type ,String c_Brand,String licensed) {
        this.Product_ID = product_ID;
        this.Vin = vin;
        this.Color = color;
        this.Engine_Capacity = engine_Capacity;
        this.Transmission_Type = transmission_Type;
        this.C_Type =c_Type  ; 
        this.C_Brand = c_Brand ; 
        this. Licensed = licensed ; 

    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }



    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getEngine_Capacity() {
        return Engine_Capacity;
    }

    public void setEngine_Capacity(int engine_Capacity) {
        Engine_Capacity = engine_Capacity;
    }

    public String getTransmission_Type() {
        return Transmission_Type;
    }

    public void setTransmission_Type(String transmission_Type) {
        Transmission_Type = transmission_Type;
    }

    public String getC_Type() {
        return C_Type;
    }

    public void setC_Type(String c_Type) {
        C_Type = c_Type;
    }

    public String getC_Brand() {
        return C_Brand;
    }

    public void setC_Brand(String c_Brand) {
        C_Brand = c_Brand;
    }

	public String getLicensed() {
		return Licensed;
	}

	public void setLicensed(String licensed) {
		Licensed = licensed;
	}

   


}