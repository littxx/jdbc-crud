package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;


public class MainViewController implements Initializable {
 
	@FXML
	private  MenuItem menuItemSeller;
	
	
    @FXML
    private MenuItem menuItemDepartament;
    
    @FXML
    private MenuItem menuItemSobre;
    
    @FXML
    public void onMenuSellerAction() {
    	System.out.println("vender");
    }
    @FXML
    public void onMenuDepatartAction() {
    	System.out.println("dep");
    }
    @FXML
    public void onMenuSobreAction() {
    	loadView("/gui/About.fxml");
    }
	
	
	
	
	
	@Override
	public synchronized void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	private void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox vbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(vbox.getChildren());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
