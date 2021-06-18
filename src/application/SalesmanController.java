package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

public class SalesmanController {
	@FXML
	Button customerSB = new Button();

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
