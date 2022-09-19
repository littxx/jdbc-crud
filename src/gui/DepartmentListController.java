package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	@FXML
	private TableView<Department> tableViewDepart;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btnew;
	
	
	public void onBTNew() {
		System.out.println("oi");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = ( Stage)Main.getMainScene().getWindow();
		tableViewDepart.prefHeightProperty().bind(stage.heightProperty());
		
	}

}