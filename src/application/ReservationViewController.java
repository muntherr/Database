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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class ReservationViewController implements Initializable {
	@FXML
	private TableView < Reservation>CompanyView;
	@FXML
	private TableColumn<Reservation, Integer> Customer_ID;
	@FXML
	private TableColumn<Reservation, String> C_Name;
	@FXML
	private TableColumn<Reservation, Integer> R_ID;
	@FXML
	private TableColumn<Reservation, Integer> JobID;
	@FXML
	private TableColumn<Reservation, String> PstartDate;
	@FXML
	private TableColumn<Reservation, String> PEndDate;
	private Button Back;
	@FXML
	private Button EditBt;
	@FXML
	private Button SaveBt;

	ObservableList<Reservation> ReservationList = FXCollections.observableArrayList();
	public static ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
	ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
	public static ArrayList<Customer> Customers = new ArrayList<Customer>();

	ResultSet rs;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		try {
			rs = DB_Connection.select(" select * from Reservation");
			Reservations.clear();

			while (rs.next()) {

				Reservations.add(new Reservation(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
						Integer.parseInt(rs.getString(4)), rs.getString(3), rs.getString(5), rs.getString(6)));

			}
			// System.out.print(Reservations.toString());

			for (int i = 0; i < Reservations.size(); i++)
				ReservationList.add(Reservations.get(i));
		

			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			C_Name.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
			R_ID.setCellValueFactory(new PropertyValueFactory<>("R_ID"));
			PstartDate.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
			PEndDate.setCellValueFactory(new PropertyValueFactory<>("End_date"));
			JobID.setCellValueFactory(new PropertyValueFactory<>("Job_ID"));

			CompanyView.setItems(ReservationList);

		} catch (Exception e) {

		} finally {
			try {
				DB_Connection.con.close();

			} catch (SQLException e) {
			}
		}
	}
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
	

	@FXML
	void Edit(ActionEvent event) {

		EditBt.setDisable(true);
		SaveBt.setDisable(false);
		CompanyView.setEditable(true);

		C_Name.setCellFactory(TextFieldTableCell.forTableColumn());
		PstartDate.setCellFactory(TextFieldTableCell.forTableColumn());
		PEndDate.setCellFactory(TextFieldTableCell.forTableColumn());
		

		// Phone.setCellFactory(TextFieldTableCell.forTableColumn(new
		// IntegerStringConverter()));

	}

	@FXML
	void Save(ActionEvent event) throws ClassNotFoundException, SQLException {
		EditBt.setDisable(false);
		CompanyView.setEditable(false);
		String SQL = null;
		for (int i = 0; i < Reservations.size(); i++) {
			SQL = "UPDATE Reservation r  SET  r.Customer_Name = '" + Reservations.get(i).getCustomer_Name() + "', r.Job_ID = " 
					+ Reservations.get(i).getCustomer_ID()  + ", r.start_date = " + "'"
					+ Reservations.get(i).getStart_date() + "'" + ", r.End_date = " + "'"
					+ Reservations.get(i).getEnd_date() + "'" 
					+ " WHERE r.R_ID = "
					+ Reservations.get(i).getR_ID();
			DB_Connection.execute(SQL);
//Customer c SET  c.C_name = '0597123123', c.Phone = 'Orabi', c.Bank_Statement = 'birzeit', c.Address = 'True', c.Income_Proof = 'True' WHERE c.Customer_Id = 1

		}
		SaveBt.setDisable(true);
		// SaveBt.setText("Saved!");
	}

	@FXML
	void Editname(TableColumn.CellEditEvent<Reservation, String> event) {
		Reservation updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setCustomer_Name(event.getNewValue());
		System.out.print("Edit");
	}


	@FXML
	void EditPstart(TableColumn.CellEditEvent<Reservation, String> event) {
		Reservation updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setStart_date(event.getNewValue());
		System.out.print("Save");
	}


	@FXML
	void EditPEnd(TableColumn.CellEditEvent<Reservation, String> event) {
		Reservation updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setEnd_date(event.getNewValue());
		System.out.print("Edit");
	}


}
