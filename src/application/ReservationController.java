package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReservationController {
	@FXML
	private Button ViewreservationsBT;
	@FXML
	private Button NewReservationBT;
	@FXML
	private Button ViewreservationsBT1;
	@FXML
	private Button back;
	
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

	@FXML
	void ViewReservation(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ReservationView.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	@FXML
	void newReservation(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("NewReservation.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	@FXML
	void ViewReservedCAr(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ReservedCars.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	
	
}
