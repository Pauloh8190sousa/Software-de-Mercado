package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;

public class ControllerViewUpdate implements Initializable{
	@FXML
	private ProgressIndicator progress;
	
	@FXML
	private void procurarUpdate(ActionEvent event){
		progress.setVisible(true);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
