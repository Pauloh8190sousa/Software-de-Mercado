package view;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
	private void acaoButton(ActionEvent event){
		if(campoEmail.getText().equals("")&&campoSenha.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo E-mail e senha vazios");
			
		}else if(campoEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo E-mail vazio");
		}
		else if(campoSenha.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio");
		}
		else{
			//em edição
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
