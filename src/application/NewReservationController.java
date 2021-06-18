package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.RadioButton;

import javafx.scene.control.CheckBox;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewReservationController implements Initializable {
	@FXML
	private AnchorPane ReservationPane;
	@FXML
	private GridPane PersonGrid;
	@FXML
	private TextField Pnametxtf;
	@FXML
	private TextField idtxtf;
	@FXML
	private TextField dobtxtf;
	@FXML
	private CheckBox incomcheck;
	@FXML
	private CheckBox bankChek;
	@FXML
	private CheckBox Cincome;
	@FXML
	private CheckBox CbankSt;
	@FXML
	private TextField Addresstxtf;
	@FXML
	private TextField phonetxtf;
	@FXML
	private GridPane Companygrid;
	@FXML
	private RadioButton PersonR;
	@FXML
	private ToggleGroup ra;
	@FXML
	private RadioButton CompanyR;
	@FXML
	private TextField AdressTxtf;
	@FXML
	private TextField Cphonetxtf;
	@FXML
	private TextField CnametxtF;
	@FXML
	private Button Back;
	@FXML
	private Button Next;
	String inProof;
	String Bankst;
	// Event Listener on Button[#Back].onAction

	static Pattern numberin = Pattern.compile("[^0-9]");
	static Pattern Input = Pattern.compile("[^ a-zA-Z]");
	static Pattern InputDate = Pattern.compile("[^ a-zA-Z0-9]");

	@FXML
	void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();
		} catch (Exception e) {

		}
	}

	// Event Listener on Button[#Next].onAction
	@FXML
	public void NextP(ActionEvent event) throws ClassNotFoundException {

		if (PersonR.isSelected()) {
			if (Pnametxtf.getText().isEmpty() || idtxtf.getText().isEmpty() || dobtxtf.getText().isEmpty()
					|| Addresstxtf.getText().isEmpty() || phonetxtf.getText().isEmpty()
					|| Input.matcher(Pnametxtf.getText()).find() || InputDate.matcher(Addresstxtf.getText()).find()
					|| numberin.matcher(idtxtf.getText()).find() || numberin.matcher(phonetxtf.getText()).find()) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error Input Type");
				alert.setContentText(
						"Input not correct. Please make sure all required fields are filled out correctly ");
				alert.showAndWait();
				return;
			} else {
				if (incomcheck.isSelected() == true)
					inProof = "True";
				else
					inProof = "False";
				if (bankChek.isSelected() == true)
					Bankst = "True";
				else
					Bankst = "False";
				try {
					DB_Connection.execute(
							"insert into Customer  ( Customer_Name , phone ,   address  , Bank_statement ,Income_proof ) values ("
									+ "'" + Pnametxtf.getText() + "'" + ",'" + phonetxtf.getText() + "','"
									+ Addresstxtf.getText() + "'," + "'" + Bankst + "'," + "'" + inProof + "')");

					DB_Connection.execute("insert into person  ( p_name , id ,   DOB ) values (" + "'"
							+ Pnametxtf.getText() + "'" + "," + idtxtf.getText() + ",'" + dobtxtf.getText() + "')");
				} catch (SQLException e) {
					System.out.print(e);
				}
			}

		}
		if (CompanyR.isSelected()) {
			if (CnametxtF.getText().isEmpty() || AdressTxtf.getText().isEmpty() || Cphonetxtf.getText().isEmpty()
					|| Input.matcher(CnametxtF.getText()).find() || InputDate.matcher(AdressTxtf.getText()).find()
					|| InputDate.matcher(Cphonetxtf.getText()).find()) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error Input Type");
				alert.setContentText(
						"Input not correct. Please make sure all required fields are filled out correctly ");
				alert.showAndWait();
				return;

			}

			else {
				if (Cincome.isSelected() == true)
					inProof = "True";
				else
					inProof = "False";
				if (CbankSt.isSelected() == true)
					Bankst = "True";
				else
					Bankst = "False";
				try {
					DB_Connection.execute(
							"insert into Customer  ( Customer_Name , phone ,   address  , Bank_statement ,Income_proof ) values ("
									+ "'" + CnametxtF.getText() + "'" + ",'" + Cphonetxtf.getText() + "','"
									+ AdressTxtf.getText() + "'," + "'" + Bankst + "'," + "'" + inProof + "')");

					DB_Connection.execute("insert into company  (C_name) values (" + "'" + CnametxtF.getText() + "')");
				} catch (SQLException e) {
					System.out.print(e);
				}
			}

		}
		if (CompanyR.isSelected() == false && PersonR.isSelected() == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Input Type");
			alert.setContentText("Input not correct. Please Choose One a customer Type  ");
			alert.showAndWait();
		} else {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("CarView.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Companygrid.setVisible(false);
		PersonGrid.setVisible(true);

	}

	@FXML
	void PersonB(ActionEvent event) {

		Companygrid.setVisible(false);
		PersonGrid.setVisible(true);
	}

	@FXML
	void CompanyB(ActionEvent event) {

		Companygrid.setVisible(true);
		PersonGrid.setVisible(false);
	}

}
