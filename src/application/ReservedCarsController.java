package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class ReservedCarsController implements Initializable {
	@FXML
	private TableView<Car> CarsView;
	@FXML
	private TableColumn<Car, Integer> Product_ID;
	@FXML
	private TableColumn<Car, String> VIN;
	@FXML
	private TableColumn<Car, String> Color;
	@FXML
	private TableColumn<Car, Integer> Engine_Capacity;
	@FXML
	private TableColumn<Car, String> Transmission;
	@FXML
	private TableColumn<Car, String> Car_Type;
	@FXML
	private TableColumn<Car, String> Car_Brand;
	@FXML
	private TableColumn<Car, String> Licenced;
	@FXML
	private Button Back;
	@FXML
	private Button EditBt;
	@FXML
	private Button SaveBt;

	ObservableList<Car> CarList = FXCollections.observableArrayList();
	public static ArrayList<Car> cars = new ArrayList<Car>();

	ResultSet rs;

	// Event Listener on Button[#Back].onAction
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			rs = DB_Connection.select(" select * from car");
			cars.clear();

			while (rs.next()) {

				cars.add(new Car(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						Integer.parseInt(rs.getString(4)), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8)));

			}
			// System.out.print(Reservations.toString());

			for (int i = 0; i < cars.size(); i++)
				CarList.add(cars.get(i));

			Product_ID.setCellValueFactory(new PropertyValueFactory<>("Product_ID"));
			VIN.setCellValueFactory(new PropertyValueFactory<>("Vin"));
			Color.setCellValueFactory(new PropertyValueFactory<>("Color"));
			Engine_Capacity.setCellValueFactory(new PropertyValueFactory<>("Engine_Capacity"));
			Transmission.setCellValueFactory(new PropertyValueFactory<>("Transmission_Type"));
			Car_Type.setCellValueFactory(new PropertyValueFactory<>("C_Type"));
			Car_Brand.setCellValueFactory(new PropertyValueFactory<>("C_Brand"));
			Licenced.setCellValueFactory(new PropertyValueFactory<>("Licensed"));

			CarsView.setItems(CarList);

		} catch (Exception e) {

		} finally {
			try {
				DB_Connection.con.close();

			} catch (SQLException e) {
			}
		}
	}
}
