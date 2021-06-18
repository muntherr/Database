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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class PsceneController implements Initializable {
	@FXML
	private TextField c_NAme;
	@FXML
	private TextField Jobid;
	@FXML
	private Button save;
	@FXML
	private TextField dt;
	@FXML
	private TextField ed;
	@FXML
	private TextField CID;
	@FXML
	private Button back;

	
	// Event Listener on Button[#back].onAction
		@FXML
		void back(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("CarView.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();
		}
	// Event Listener on Button[#Next].onAction
	@FXML
	public void Reserve(ActionEvent event) throws ClassNotFoundException {

		if (c_NAme.getText().isEmpty() || Jobid.getText().isEmpty() || dt.getText().isEmpty()
				|| ed.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Input Type");
			alert.setContentText("Input not correct. Please make sure all required fields are filled out correctly ");
			alert.showAndWait();
		} else {
			try {
				DB_Connection.execute(
						"insert into Reservation (Job_ID, Customer_ID , Customer_Name, Start_Date, End_Date) values  ("
								+ "'" + Jobid.getText() + "'," + CID.getText() + ",'" + c_NAme.getText() + "','"
								+ dt.getText() + "'," + "'" + ed.getText() + "')");

			} catch (SQLException e) {
				System.out.print(e);
			}

			try {
				Parent root = FXMLLoader.load(getClass().getResource("Finish.fxml"));
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
		// TODO Auto-generated method stub
		
	}

	
}
