package controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControllerLoginGoogle implements Initializable{
	@FXML
	private WebView webGoogle;
	@FXML
	private BorderPane border;
	private WebEngine webEngine;

	@FXML
	private void voltar(ActionEvent event) throws IOException{
		Stage s1 = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewLogin.fxml"));
		Scene scene = new Scene(root);

		Stage stage = (Stage) border.getScene().getWindow();
		stage.close();
		s1.setMaximized(true);
		s1.setScene(scene);
		s1.setTitle("Mercado");
		s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		s1.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		webEngine = webGoogle.getEngine();
		webEngine.load("https://www.google.com/accounts/login");
		
	}

	

}
