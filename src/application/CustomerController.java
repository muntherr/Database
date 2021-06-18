package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CustomerController implements Initializable {
	@FXML
	private GridPane PersonGrid;
	@FXML
	private TextField NameTxtF;
	@FXML
	private TextField CIDtxtF;
	@FXML
	private TextField IDtxtF;
	@FXML
	private TextField PhoneTXTF;
	@FXML
	private TextField AgetxtF;
	@FXML
	private Button Search;
	@FXML
	private Button View;
	@FXML
	private GridPane CustomerTypeGrid;
	@FXML
	private RadioButton RBPerson;
	@FXML
	private RadioButton RBcompany;
	@FXML
	private RadioButton RBALL;
	@FXML
	private Button Back;
	@FXML
	private GridPane CompanyGrid;
	@FXML
	private TextField companytxtF;
	@FXML
	private TextField cidtxtF;
	@FXML
	private Button Search1;
	@FXML
	private Button View1;
	@FXML
	private TextField AddresstxtF;
	@FXML
	private ToggleGroup customerGroup;

	private LogInController logInController;

	@FXML
	void back(ActionEvent event) {
		Main m = new Main();
		try {
			if (LogInController.getUser() == "manager")
				m.changeScene("ManagerController.fxml");

			else
				m.changeScene("SalesmanController.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String S, SQL = null;
	public ResultSet rs;
	static Pattern numberin = Pattern.compile("[^0-9]");
	static Pattern Input = Pattern.compile("[^ a-zA-Z]");
	static Pattern InputDate = Pattern.compile("[^ a-zA-Z0-9]");

	@FXML
	void ViewALL(ActionEvent event) throws ClassNotFoundException, SQLException {
		if (!RBPerson.isSelected() && !RBcompany.isSelected() && !RBALL.isSelected()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setContentText("Please choose a customer types");
			alert.showAndWait();
		} else {
			if (RBPerson.isSelected()) {
				SQL = " Select * from Person";
			try {

				Parent root = FXMLLoader.load(getClass().getResource("PersonView.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
			}
			else if (RBcompany.isSelected()) {
				SQL = " Select * from company";
			try {

				Parent root = FXMLLoader.load(getClass().getResource("CompanyView.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
			}
			else if (RBALL.isSelected()) {

				SQL = "select * from Customer ";
				try {

					Parent root = FXMLLoader.load(getClass().getResource("AllCustomers.fxml"));
					Scene scene = new Scene(root);
					Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
					st.setScene(scene);
					st.show();

				} catch (Exception e) {
				}
			}

			

		}
	}

	

	@FXML
	void search(ActionEvent event) throws ClassNotFoundException, SQLException {
		// String type = RBPerson.getSelectionModel().getSelectedItem().toString();
		if (!RBPerson.isSelected() && !RBcompany.isSelected() && !RBALL.isSelected()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setContentText("Please choose customer types");
			alert.showAndWait();
		}
		else {
		
		if (RBPerson.isSelected()) { // If The Radio button is selected as Person, the user should enter data to find
										// it then the program will match it from data base
			if (Input.matcher(NameTxtF.getText()).find() || InputDate.matcher(AgetxtF.getText()).find()
					|| numberin.matcher(CIDtxtF.getText()).find() || numberin.matcher(IDtxtF.getText()).find()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error Input Type");
				alert.setContentText("Please fill all input fields");
				alert.showAndWait();
			} else {

				SQL = "select * from Person P where p.p_name like ";
				if (NameTxtF.getText().isEmpty())
					SQL = SQL + "p.p_name And ";
				else
					SQL = SQL + ("'%" + NameTxtF.getText() + "%'") + " and";

				if (CIDtxtF.getText().isEmpty())
					SQL = SQL + " p.customer_id = p.customer_id and";
				else
					SQL = SQL + " p.customer_id =" + Integer.parseInt(CIDtxtF.getText()) + " and";

				if (IDtxtF.getText().isEmpty())
					SQL = SQL + " p.id = p.id and";
				else
					SQL = SQL + " p.id =" + Integer.parseInt(IDtxtF.getText()) + " and";
				if (AgetxtF.getText().isEmpty())
					SQL = SQL + " p.DOB = p.DOB ";
				else
					SQL = SQL + " p.DOB =" + ("'" + AgetxtF.getText() + "'");

				try {
					Parent root = FXMLLoader.load(getClass().getResource("PersonView.fxml"));
					Scene scene = new Scene(root);
					Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
					st.setScene(scene);
					st.show();

				} catch (Exception e) {
				}
			}
		}

		else if (RBcompany.isSelected()) {

			if (InputDate.matcher(companytxtF.getText()).find() || numberin.matcher(cidtxtF.getText()).find()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error Input Type");
				alert.setContentText(
						"Input not correct. Please make sure all required fields are filled out correctly ");
				alert.showAndWait();
			} else {

				SQL = "select * from company c where c.C_name like ";
				if (companytxtF.getText().isEmpty())
					SQL = SQL + "c.C_name And ";
				else
					SQL = SQL + ("'%" + companytxtF.getText() + "%'") + " and";
				if (cidtxtF.getText().isEmpty())
					SQL = SQL + " c.customer_id = c.customer_id and";
				else
					SQL = SQL + " c.customer_id =" + Integer.parseInt(cidtxtF.getText()) + " and";

				if (AddresstxtF.getText().isEmpty())
					SQL = SQL + " c.Address = c.Address and";
				else
					SQL = SQL + " c.Address =" + AddresstxtF.getText() + " and";

				if (PhoneTXTF.getText().isEmpty())
					SQL = SQL + " c.phone = c.phone ";
				else
					SQL = SQL + " c.phone =" + Integer.parseInt(PhoneTXTF.getText());

				System.out.println(SQL);

				try {

					Parent root = FXMLLoader.load(getClass().getResource("CompanyView.fxml"));
					Scene scene = new Scene(root);
					Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
					st.setScene(scene);
					st.show();

				} catch (Exception e) {
				}
			}

		} else if (RBALL.isSelected()) {

			SQL = "select * from Customer ";
			try {

				Parent root = FXMLLoader.load(getClass().getResource("AllCustomers.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
		}
		}

	}

	@FXML
	void PersonB(ActionEvent event) {

		CompanyGrid.setVisible(false);
		PersonGrid.setVisible(true);
	}

	@FXML
	void CompanyB(ActionEvent event) {

		CompanyGrid.setVisible(true);
		PersonGrid.setVisible(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// PersonGrid.setVisible(true);
	}
}
