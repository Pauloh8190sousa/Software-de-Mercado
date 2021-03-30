package view;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class ControllerViewBase implements Initializable{
	@FXML
	private Button entar;
	@FXML
	private TextField campoEmail;
	@FXML
	private PasswordField campoSenha;
	
	@FXML
	private void acaoButton(ActionEvent event){
		if(campoEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo E-mail vazio");
			
		}else{
			System.out.println("E-mail: "+campoEmail.getText());
		}
		if(campoSenha.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio");
		}
		else{
			System.out.println("Senha: "+campoSenha.getText());
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
