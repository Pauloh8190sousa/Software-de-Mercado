package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ControllerLoginGoogle implements Initializable{
	@FXML
	private StackPane paneGoogle;
	@FXML
	private WebView webGoogle;
	
	private WebEngine webEngine;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		webEngine = webGoogle.getEngine();
		webEngine.load("https://www.google.com/accounts/login");
		
	}

	

}
