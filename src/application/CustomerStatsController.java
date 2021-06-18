package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class CustomerStatsController implements Initializable {
	@FXML
	private TextField numOFPersonTF;
	@FXML
	private TextField OldestTF;
	@FXML
	private TextField YoungestTF;
	@FXML
	private TextField numOFCompaniesTF;
	@FXML
	private Button backB;

	ResultSet rs;

	public void backToStatMain(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("StatsMain.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int sum;
		try {
			// number of person as a customer
			rs = DB_Connection.select("select count(*) from Person f; ");
			if (rs.next())
				numOFPersonTF.setText(rs.getString(1));
			else
				numOFPersonTF.setText("-");
			// name of the oldest person
			rs = DB_Connection
					.select("select f.P_Name from Person f where f.DOB = (select min(f.DOB) from Person f ); ");
			if (rs.next())
				OldestTF.setText(rs.getString(1));
			else
				OldestTF.setText("-");

			// name of the youngest person
			rs = DB_Connection
					.select("select f.P_Name from Person f where f.DOB = (select max(f.DOB) from Person f ); ");
			if (rs.next())
				YoungestTF.setText(rs.getString(1));
			else
				YoungestTF.setText("-");
			// number of companies as A customer
			rs = DB_Connection.select("select count(*) from Company m; ");
			if (rs.next())
				numOFCompaniesTF.setText(rs.getString(1));
			else
				numOFCompaniesTF.setText("-");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
