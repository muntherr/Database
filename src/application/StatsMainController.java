package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class StatsMainController {
	@FXML
	private Button productsB;
	@FXML
	private Button salesmenB;
	@FXML
	private Button customersB;
	@FXML
	private Button backB;

	// Event Listener on Button[#productsB].onAction
	@FXML
	public void goToProducts(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ProductsStats.fxml");
	}

	// Event Listener on Button[#salesmenB].onAction
	@FXML
	public void goToSalesmen(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("SalesmenStats.fxml");
	}

	// Event Listener on Button[#customersB].onAction
	@FXML
	public void goToCustomers(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("CustomerStatsController.fxml");
	}

	// Event Listener on Button[#backB].onAction
	@FXML
	public void backToManager(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ManagerController.fxml");
	}
}
