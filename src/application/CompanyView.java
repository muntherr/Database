
package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn;

public class CompanyView implements Initializable {

	@FXML
	private TableView <Company> CompanyView ;
	@FXML
	private TableColumn <Company, Integer> Customer_ID ;
	@FXML
	private TableColumn <Company, String> C_Name;
	@FXML
	private TableColumn <Company, String> Address;
	@FXML
	private TableColumn <Company, String> Phone;
	@FXML
	private Button Back;
	@FXML
	private Button EditBt;
	@FXML
	private Button SaveBt;
	


	ObservableList<Company> CompanyList = FXCollections.observableArrayList();
	public static ArrayList<Company> Company = new ArrayList<Company>();
	ResultSet rs;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select(CustomerController.SQL);
			Company.clear();

			while (rs.next()) {

				Company.add(new Company(Integer.parseInt(rs.getString(1)),rs.getString(2) , rs.getString(4) ,rs.getString(3)));

			}
			System.out.println(Company);
		                
			for (int i = 0; i < Company.size(); i++)
				CompanyList.add(Company.get(i));
			
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			C_Name.setCellValueFactory(new PropertyValueFactory<>("C_Name"));
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			
			CompanyView.setItems(CompanyList);
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
		Address.setCellFactory(TextFieldTableCell.forTableColumn());
		Phone.setCellFactory(TextFieldTableCell.forTableColumn());

		//Phone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

	}
	@FXML
	void Save(ActionEvent event) throws ClassNotFoundException, SQLException {
		EditBt.setDisable(false);
		CompanyView.setEditable(false);
		String SQL = null;
		for (int i = 0; i < Company.size(); i++) {
			SQL = "UPDATE company c SET  c.C_name = '" + Company.get(i).getC_Name()+ "', c.Phone = "
					+ "'"+ Company.get(i).getPhone() +"'"+ ", c.Address = " +"'" + Company.get(i).getAddress() +"'"
					+ " WHERE c.Customer_Id = "+ Company.get(i).getCustomer_ID();
			DB_Connection.execute(SQL);
			
		}
		SaveBt.setDisable(true);
	}
	
	@FXML
	 void EdiTme(TableColumn.CellEditEvent<Company, String> event) {
		Company updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setC_Name(event.getNewValue());
		System.out.print("Edit");
	}
	@FXML
	 void EditAddress(TableColumn.CellEditEvent<Company, String> event) {
		Company updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setAddress(event.getNewValue());
		System.out.print("Save");
	}
	@FXML
	 void EditPhone(TableColumn.CellEditEvent<Company, String> event) {
		Company updatedData = CompanyView.getSelectionModel().getSelectedItem();
		updatedData.setPhone(event.getNewValue());
		System.out.print("Save");
	}
}

