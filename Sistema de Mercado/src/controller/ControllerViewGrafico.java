package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerViewGrafico implements Initializable{
	@FXML
	private GridPane grid;
	
	@FXML
	private void voltar(ActionEvent event) throws IOException{
		Stage stage = (Stage) grid.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}
	@FXML
	private void acaoComGrafico(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}		
		
	
		

}
