package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerViewBase implements Initializable{
	@FXML
	private Button entar;
	@FXML
	private TextField campoEmail;
	@FXML
	private PasswordField campoSenha;
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private void acaoButton(ActionEvent event) throws Exception{
		if(campoEmail.getText().equals("")&&campoSenha.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo E-mail e senha vazios");
			
		}else if(campoEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo E-mail vazio");
		}
		else if(campoSenha.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio");
		}
		else{
			Stage s1 = new Stage();
			 Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
			 Scene scene = new Scene(root,600,400);
			 
			 Stage stage = (Stage) anchorPane.getScene().getWindow();
			 stage.close();
			 s1.setScene(scene);
			 s1.setTitle("Mercado");
			 s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
			 s1.show();
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}