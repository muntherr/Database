package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SalesmenStatsController implements Initializable {
	@FXML
	private TextField numOfSalesmen;
	@FXML
	private TextField citySalesmenTF;
	@FXML
	private TextField mostSalesTF;
	@FXML
	private TableView<Salesmen> salesmenTable;
	@FXML
	private TableColumn<Salesmen, Integer> job_idCol;
	@FXML
	private TableColumn<Salesmen, String> nameCol;
	@FXML
	private TableColumn<Salesmen, Integer> idCol;
	@FXML
	private TableColumn<Salesmen, String> addressCol;
	@FXML
	private TableColumn<Salesmen, String> phoneCol;
	@FXML
	private Button editB;
	@FXML
	private Button saveB;
	@FXML
	private Button backB;
	ObservableList<Salesmen> salesmenList = FXCollections.observableArrayList();
	public static ArrayList<Salesmen> salesmen = new ArrayList<Salesmen>();
	ResultSet rs;

	public void backToStatMain(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("StatsMain.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int sum;
		try {

			/*** table ***/
			rs = DB_Connection.select("SELECT * FROM SALESMEN;");
			System.out.println(rs);
			salesmen.clear();

			while (rs.next()) {

				salesmen.add(new Salesmen(Integer.parseInt(rs.getString(1)), rs.getString(2),
						Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5)));

			}
			System.out.println(salesmen);

			for (int i = 0; i < salesmen.size(); i++)
				salesmenList.add(salesmen.get(i));

			job_idCol.setCellValueFactory(new PropertyValueFactory<>("Job_ID"));
			nameCol.setCellValueFactory(new PropertyValueFactory<>("Sname"));
			idCol.setCellValueFactory(new PropertyValueFactory<>("S_ID"));
			addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
			phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
			salesmenTable.setItems(salesmenList);
			/*******/
			// most expensive
			rs = DB_Connection.select("select count(*) from Salesmen s;");
			if (rs.next())
				numOfSalesmen.setText(rs.getString(1));
			else
				numOfSalesmen.setText("-");
//			// num of cars in brand
//			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
//			if (rs.next())
//				numOfBrandsTF.setText(rs.getString(1));
//			else
//				numOfBrandsTF.setText("-");
			// city from which are the most salesmen
			rs = DB_Connection.select(
					"SELECT MAX(c.count) , c.Address  FROM (SELECT E.Address, COUNT(E.Job_ID) AS count FROM Salesmen E GROUP BY E.Address ORDER BY 2 DESC) c;");
			if (rs.next())
				citySalesmenTF.setText(rs.getString(2));
			else
				citySalesmenTF.setText("-");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void Edit(ActionEvent event) {

		editB.setDisable(true);
		saveB.setDisable(false);

		salesmenTable.setEditable(true);
		nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

		phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	@FXML
	void Save(ActionEvent event) throws ClassNotFoundException, SQLException {
		editB.setDisable(false);
		salesmenTable.setEditable(false);
		String SQL = null;
		for (int i = 0; i < salesmen.size(); i++) {
			SQL = "UPDATE Salesmen s SET  s.Sname = '" + salesmen.get(i).getSname() + "', s.phone = " + "'"
					+ salesmen.get(i).getPhone() + "'" + ", s.address = '" + salesmen.get(i).getAddress()
					+ "' WHERE s.Job_ID = " + salesmen.get(i).getJob_ID();
			DB_Connection.execute(SQL);

		}
		saveB.setDisable(true);
		// save.setText("Saved!");
	}

	@FXML
	void EdiTme(TableColumn.CellEditEvent<Salesmen, String> event) {
		Salesmen updatedData = salesmenTable.getSelectionModel().getSelectedItem();
		updatedData.setSname(event.getNewValue());
		System.out.print("Edit");
	}

	@FXML
	void EditName(TableColumn.CellEditEvent<Salesmen, String> event) {
		Salesmen updatedData = salesmenTable.getSelectionModel().getSelectedItem();
		updatedData.setSname(event.getNewValue());
		System.out.print("Save");

	}

	@FXML
	void EditAddress(TableColumn.CellEditEvent<Salesmen, String> event) {
		Salesmen updatedData = salesmenTable.getSelectionModel().getSelectedItem();
		updatedData.setAddress(event.getNewValue());
		System.out.print("Save");
	}

	@FXML
	void EditPhone(TableColumn.CellEditEvent<Salesmen, String> event) {
		Salesmen updatedData = salesmenTable.getSelectionModel().getSelectedItem();
		updatedData.setPhone(event.getNewValue());
		System.out.print("Save");
	}

}
