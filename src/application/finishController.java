package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class finishController implements Initializable  {
	@FXML
	private Button main;
	@FXML
	private Button exit;

	// Event Listener on Button[#main].onAction
	@FXML
	void mainmenu(ActionEvent event) {
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

	// Event Listener on Button[#exit].onAction
	@FXML
	public void exit(ActionEvent event) {
		exit.setOnAction(actionEvent -> Platform.exit());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
