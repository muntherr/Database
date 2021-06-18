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
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn;

public class AllCustomersController implements Initializable {
	@FXML
	private Button Back;
	@FXML
	private Button SaveBt;
	@FXML
	private Button EditBt;
	@FXML
	private TableView<Customer> AllView;
	@FXML
	private TableColumn<Customer, String> C_name;
	@FXML
	private TableColumn<Customer, Integer> Customer_ID;
	@FXML
	private TableColumn<Customer, String> Phone;
	@FXML
	private TableColumn<Customer, String> Bankst;
	@FXML
	private TableColumn<Customer, String> incomeproof;
	@FXML
	private TableColumn<Customer, String> Address;

	ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
	public static ArrayList<Customer> AllCustomer = new ArrayList<Customer>();

	ObservableList<Person> personList = FXCollections.observableArrayList();
	public static ArrayList<Person> person = new ArrayList<Person>();
	ResultSet rs;

	public static String S;

	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select(CustomerController.SQL);
			AllCustomer.clear();

			while (rs.next()) {
				AllCustomer.add(new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), // 2-> Cname , 3 Phone
						rs.getString(5), rs.getString(6), rs.getString(4)));

			}
			System.out.println(AllCustomer);

			for (int i = 0; i < AllCustomer.size(); i++)
				CustomerList.add(AllCustomer.get(i));

			C_name.setCellValueFactory(new PropertyValueFactory<>("C_name"));
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			Bankst.setCellValueFactory(new PropertyValueFactory<>("Bank_Statement"));
			incomeproof.setCellValueFactory(new PropertyValueFactory<>("Income_Proof"));
			AllView.setItems(CustomerList);

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
			Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(root, 600, 400);
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
		AllView.setEditable(true);

		C_name.setCellFactory(TextFieldTableCell.forTableColumn());
		Phone.setCellFactory(TextFieldTableCell.forTableColumn());
		Bankst.setCellFactory(TextFieldTableCell.forTableColumn());
		incomeproof.setCellFactory(TextFieldTableCell.forTableColumn());
		Address.setCellFactory(TextFieldTableCell.forTableColumn());

		// Phone.setCellFactory(TextFieldTableCell.forTableColumn(new
		// IntegerStringConverter()));

	}

	@FXML
	void Save(ActionEvent event) throws ClassNotFoundException, SQLException {
		EditBt.setDisable(false);
		AllView.setEditable(false);
		String SQL = null;
		for (int i = 0; i < AllCustomer.size(); i++) {
			SQL = "UPDATE Customer c SET  c.Customer_Name = '" + AllCustomer.get(i).getC_name() + "', c.Phone = " + "'"
					+ AllCustomer.get(i).getPhone() + "'" + ", c.Bank_Statement = " + "'"
					+ AllCustomer.get(i).getBank_Statement() + "'" + ", c.Address = " + "'"
					+ AllCustomer.get(i).getAddress() + "'" + ", c.Income_Proof = " + "'"
					+ AllCustomer.get(i).getIncome_Proof() + "'" + " WHERE c.Customer_Id = "
					+ AllCustomer.get(i).getCustomer_ID();
			DB_Connection.execute(SQL);
//Customer c SET  c.C_name = '0597123123', c.Phone = 'Orabi', c.Bank_Statement = 'birzeit', c.Address = 'True', c.Income_Proof = 'True' WHERE c.Customer_Id = 1

		}
		SaveBt.setDisable(true);
		// SaveBt.setText("Saved!");
	}

	@FXML
	void Editname(TableColumn.CellEditEvent<Customer, String> event) {
		Customer updatedData = AllView.getSelectionModel().getSelectedItem();
		updatedData.setC_name(event.getNewValue());
		System.out.print("Edit");
	}


	@FXML
	void EditPhone(TableColumn.CellEditEvent<Customer, String> event) {
		Customer updatedData = AllView.getSelectionModel().getSelectedItem();
		updatedData.setPhone(event.getNewValue());
		System.out.print("Save");
	}


	@FXML
	void EditBankst(TableColumn.CellEditEvent<Customer, String> event) {
		Customer updatedData = AllView.getSelectionModel().getSelectedItem();
		updatedData.setBank_Statement(event.getNewValue());
		System.out.print("Edit");
	}

	@FXML
	void Editincomeproof(TableColumn.CellEditEvent<Customer, String> event) {
		Customer updatedData = AllView.getSelectionModel().getSelectedItem();
		updatedData.setIncome_Proof(event.getNewValue());
		System.out.print("Save");
	}

	@FXML
	void EditAddress(TableColumn.CellEditEvent<Customer, String> event) {
		Customer updatedData = AllView.getSelectionModel().getSelectedItem();
		updatedData.setAddress(event.getNewValue());
		System.out.print("Save");
	}
}


