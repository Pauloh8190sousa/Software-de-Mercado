package controller;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerViewBase implements Initializable{
	@FXML
	private Button entar;
	@FXML
	private TextField campoEmail;
	@FXML
	private PasswordField campoSenha;
	@FXML
	private GridPane gridPane;
	
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
			 Scene scene = new Scene(root);
			 
			 Stage stage = (Stage) gridPane.getScene().getWindow();
			 stage.close();
			 s1.setMaximized(true);
			 s1.setScene(scene);
			 s1.setTitle("Mercado");
			 s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
			 s1.show();
		}
		
	}
	@FXML
	private void acesarViewGoogle() throws Exception{
		Stage s1 = new Stage();
		 Pane root = FXMLLoader.load(getClass().getResource("/view/LoginGoogle.fxml"));
		 Scene scene = new Scene(root);
		 
		 Stage stage = (Stage) gridPane.getScene().getWindow();
		 stage.close();
		 s1.setMaximized(true);
		 s1.setScene(scene);
		 s1.setTitle("Mercado");
		 s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		 s1.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
