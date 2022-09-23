package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService DepartamentService;
	@FXML
	private TableView<Department> tableViewDepart;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btnew;
	
	private ObservableList<Department> obsList;
	public void onBTNew() {
		System.out.println("oi");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	public void setService(DepartmentService DepartmentService) {
		this.DepartamentService = DepartmentService;
	}

	private void initializeNodes() {
		
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = ( Stage)Main.getMainScene().getWindow();
		tableViewDepart.prefHeightProperty().bind(stage.heightProperty());
		
	}
	public void updateTableView() {
		if(DepartamentService == null) {
			throw new IllegalStateException("Service null");
		}
		List<Department> list = DepartamentService.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepart.setItems(obsList);
	}

}
