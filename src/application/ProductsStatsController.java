package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class ProductsStatsController implements Initializable {
	@FXML
	private TextField expensiveTF;
	@FXML
	private TextField numInStock;
	@FXML
	private TextField numOfBrandsTF;
	@FXML
	private RadioButton hyundai;
	@FXML
	private RadioButton jeep;
	@FXML
	private RadioButton fiat;
	@FXML
	private ToggleGroup brandRB;
	@FXML
	private TextField avgCapacityTF;
	@FXML
	private TextField avgPromotionsDurationTF;
	@FXML
	private Button backB;
	ResultSet rs;

	// Event Listener on RadioButton[#hyundaiRB].onAction
	@FXML
	public void getHyundaiNum(ActionEvent event) throws SQLException {
		try {
			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (rs.next())
			numOfBrandsTF.setText(rs.getString(1));
		else
			numOfBrandsTF.setText("-");
	}

	// Event Listener on RadioButton[#jeepRB].onAction
	@FXML
	public void getJeepNum(ActionEvent event) throws SQLException {
		try {
			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (rs.next())
			numOfBrandsTF.setText(rs.getString(1));
		else
			numOfBrandsTF.setText("-");
	}

	// Event Listener on RadioButton[#fiatRB].onAction
	@FXML
	public void getFiatNum(ActionEvent event) throws SQLException {
		try {
			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (rs.next())
			numOfBrandsTF.setText(rs.getString(1));
		else
			numOfBrandsTF.setText("-");
	}

	public void backToStatMain(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("StatsMain.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int sum;
		try {
			// most expensive
			rs = DB_Connection.select(
					"select p.Product_ID from Product p where p.Price = (select max(p.Price) from product p ) ;");
			if (rs.next())
				expensiveTF.setText(rs.getString(1));
			else
				expensiveTF.setText("-");
			// num of cars in brand
			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
			if (rs.next())
				numOfBrandsTF.setText(rs.getString(1));
			else
				numOfBrandsTF.setText("-");
			// number of products in stock (not sold)
			rs = DB_Connection.select(
					"SELECT (SELECT COUNT(*) AS total FROM product p) - (SELECT COUNT(*) AS sold FROM orderdetails od) AS itemsNotSold;");
			if (rs.next())
				numInStock.setText(rs.getString(1));
			else
				numInStock.setText("-");
			// avg engine capacity
			rs = DB_Connection.select("SELECT AVG (e.Engine_Capacity) from Car e;");
			if (rs.next())
				avgCapacityTF.setText(rs.getString(1) + "cc");
			else
				avgCapacityTF.setText("-");
			// avg duration of promotions
			rs = DB_Connection.select("SELECT AVG(m.Duration) FROM  Promotions m;");
			if (rs.next())
				avgPromotionsDurationTF.setText(rs.getString(1) + " year/s");
			else
				avgPromotionsDurationTF.setText("-");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private String getBrandName() {
		if (hyundai.isSelected())
			return "hundai";
		if (jeep.isSelected())
			return "jeep";
		if (fiat.isSelected())
			return "fiat";
		return "hundai";
	}

}
