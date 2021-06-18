package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ManagerController {
	@FXML
	private Button customerSB;
	@FXML
	private Button statsButton;
	@FXML
	private Button reservationButton;
	@FXML
	private Button logOutB;

	// Event Listener on Button[#customerSB].onAction
	@FXML
	public void customerScene(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Customer.fxml");
	}

	@FXML
	public void statsScene(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("StatsMain.fxml");
	}


	// Event Listener on Button[#reservationButton].onAction
	@FXML
	public void reservationScene(ActionEvent event) throws IOException {
		Main m = new Main();
	m.changeScene("Reservation.fxml");
	}

	// Event Listener on Button[#logOutB].onAction
	@FXML
	public void logOut(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LogIn.fxml");
	}
}
