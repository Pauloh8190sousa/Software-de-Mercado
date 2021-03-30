package view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControllerViewBase implements Initializable{
	@FXML
	private Button entar;
	
	@FXML
	private void acaoButton(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Teste");
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
