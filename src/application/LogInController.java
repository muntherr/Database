package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LogInController {
	private static String user = "";

	public static String getUser() {
		return user;
	}

	@FXML
	private TextField unameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button logInButton;
	@FXML
	private Label wrongLabel;

	// Event Listener on Button[#logInButton].onAction
	@FXML
	public void logIn(ActionEvent event) throws IOException {
		credentialsValidity();
	}

	private void credentialsValidity() throws IOException {
		Main m = new Main();
		if (unameField.getText().toString().equals("admin") && passwordField.getText().toString().equals("admin1234")) {
			user = "manager";
			System.out.println(getUser());
			m.changeScene("ManagerController.fxml");
			wrongLabel.setText("manager scene not added yet");
		} else if (unameField.getText().toString().equals("salesman")
				&& passwordField.getText().toString().equals("sales1234")) {
			user = "salesman";
			m.changeScene("SalesmanController.fxml");
		} else if (unameField.getText().isEmpty() && passwordField.getText().isEmpty())
			wrongLabel.setText("no credenitals entered");
		else
			wrongLabel.setText("wrong username and/or password!");
	}
}
