package application;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.sun.javafx.tk.Toolkit;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn;

public class PersonView implements Initializable {
	@FXML
	 TableView<Person> PersonV;
	@FXML
	private TableColumn<Person, Integer> Id;
	@FXML
	 TableColumn<Person, String> P_Name;
	@FXML
	 TableColumn<Person, String> Age;
	@FXML
	private TableColumn<Person, Integer> Customer_ID;
	@FXML
	private Button Back;
	@FXML
	private Button SaveBt;
	@FXML
	private Button EditBt;
	@FXML
	private Pane pane;
	@FXML
	private HBox Hbox ;
	@FXML
	private AnchorPane Anchor;
	ObservableList<Person> personList = FXCollections.observableArrayList();
	public static ArrayList<Person> person = new ArrayList<Person>();
	ResultSet rs;
	public static String S;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select(CustomerController.SQL);
			System.out.println(rs);
			person.clear();

			while (rs.next()) {

				person.add(new Person(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),rs.getString(3),
						rs.getString(4)));

			}
			System.out.println(person);

			for (int i = 0; i < person.size(); i++)
				personList.add(person.get(i));

			Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
			P_Name.setCellValueFactory(new PropertyValueFactory<>("P_Name"));
			Age.setCellValueFactory(new PropertyValueFactory<>("DOB"));
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));

			PersonV.setItems(personList);
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
		
		PersonV.setEditable(true);
		P_Name.setCellFactory(TextFieldTableCell.forTableColumn());

		Age.setCellFactory(TextFieldTableCell.forTableColumn());

	}
	@FXML
	void Save(ActionEvent event) throws ClassNotFoundException, SQLException {
		EditBt.setDisable(false);
		PersonV.setEditable(false);
		String SQL = null;
		for (int i = 0; i < person.size(); i++) {
			SQL = "UPDATE Person p SET  p.P_Name = '" + person.get(i).getP_Name()+ "', p.DOB = "
					+"'"+ person.get(i).getDOB()+"'" + ", p.Id = " + person.get(i).getId()
					+ " WHERE p.Customer_Id = " + person.get(i).getCustomer_ID();
			DB_Connection.execute(SQL);
			
		}
		SaveBt.setDisable(true);
		//save.setText("Saved!");
	}
	

	
	@FXML
	 void EdiTme(TableColumn.CellEditEvent<Person, String> event) {
		Person updatedData = PersonV.getSelectionModel().getSelectedItem();
		updatedData.setP_Name(event.getNewValue());
		System.out.print("Edit");
	}
	@FXML
	 void EditAe(TableColumn.CellEditEvent<Person, String> event) {
		Person updatedData = PersonV.getSelectionModel().getSelectedItem();
		updatedData.setDOB(event.getNewValue());
		System.out.print("Save");

	}


	
	

}
