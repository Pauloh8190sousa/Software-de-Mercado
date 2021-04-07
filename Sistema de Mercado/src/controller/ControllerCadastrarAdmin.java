package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import dataBase.AdminDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import system.Admin;
import system.GerenciadorAdmin;

public class ControllerCadastrarAdmin implements Initializable {
	@FXML
	private TextField campoNome;
	@FXML
	private TextField campoEmail;
	@FXML
	private PasswordField campoSenha;
	@FXML
	private PasswordField campoConfirmar;
	@FXML
	private GridPane grid;

	@FXML
	private void acaoButtonCadastrar(ActionEvent event) throws IOException {
		GerenciadorAdmin gerenciadorAdmin = GerenciadorAdmin.getInstance();
		if (gerenciadorAdmin.getEmailAdmin() == null && gerenciadorAdmin.getSenhaAdmin() == null) {
			if (campoSenha.getText().equals("") || campoEmail.getText().equals("")
					|| campoConfirmar.getText().equals("") || campoNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Vazio");
			} else {
				if (campoConfirmar.getText().equals(campoSenha.getText())) {
					gerenciadorAdmin.addEmailAdmin(campoEmail.getText());
					gerenciadorAdmin.addSenhaAdmin(campoSenha.getText());
					gerenciadorAdmin.addNomeAdmin(campoNome.getText());

					JOptionPane.showMessageDialog(null, "Administrador Cadastrado!\nFa�a Login para entrar");

					Stage s1 = new Stage();
					Pane root = FXMLLoader.load(getClass().getResource("/view/ViewLogin.fxml"));
					Scene scene = new Scene(root);

					Stage stage = (Stage) grid.getScene().getWindow();
					stage.close();
					s1.setMaximized(true);
					s1.setScene(scene);
					s1.setTitle("Mercado");
					s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
					s1.show();
				} else {
					JOptionPane.showMessageDialog(null, "Senha Diferente!");
				}
			}
		} else {
			if (campoSenha.getText().equals("") || campoEmail.getText().equals("")
					|| campoConfirmar.getText().equals("") || campoNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Vazio");
			} else {
				JOptionPane.showMessageDialog(null, "J� existe um Administrador");
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
