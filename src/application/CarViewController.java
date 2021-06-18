package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CarViewController {
	@FXML
	private ImageView Fimage;
	@FXML
	private Button FiatCarBT;
	@FXML
	private ImageView himage;
	@FXML
	private Button HyndaiBt;
	@FXML
	private ImageView jeepimage;
	@FXML
	private Button JeepBt;
	@FXML
	private ImageView seatimage;
	@FXML
	private Button SeatBt;
	@FXML
	private Button Back;
	Main m = new Main();

	@FXML
	void back(ActionEvent event) {
		try {
			System.out.print(">>>>>");
			Parent root = FXMLLoader.load(getClass().getResource("NewReservation.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}
	
	
	@FXML
	void Hscene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Hscene.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}
	@FXML
	void Jscene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Jscene.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}
	@FXML
	void Sscene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Pscene.fxml"));

			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {
			System.out.print(e);

		}
	}
	@FXML
	void Fscene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Fscene.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}

}
