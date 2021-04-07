package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import system.GerenciadorAdmin;
import tool.CriarJSON;

public class ControllerViewBase implements Initializable {
	@FXML
	private Button entar;
	@FXML
	private TextField campoEmail;
	@FXML
	private PasswordField campoSenha;
	@FXML
	private GridPane gridPane;
	private int opcao = JOptionPane.YES_OPTION;

	@FXML
	private void adicionarCredenciais(KeyEvent event) {
		if (campoEmail.getText().equals("") || campoSenha.getText().equals("")) {
			if (opcao == JOptionPane.YES_OPTION) {
				CriarJSON credenciais = new CriarJSON();
				JSONObject json = credenciais.getCredenciaisJSON();
				if (json != null) {
					opcao = JOptionPane.showConfirmDialog(null, "Adicionar credenciais salvas?", "ATENÇÂO",
							JOptionPane.YES_NO_OPTION);
					if (opcao == JOptionPane.YES_OPTION) {
						campoEmail.setText((String) json.get("E-mail"));
						campoSenha.setText((String) json.get("Senha"));
					}
				}
			}
		}
	}

	@FXML
	private void acaoButton(ActionEvent event) throws Exception {
		if (campoEmail.getText().equals("") && campoSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo E-mail e senha vazios");

		} else if (campoEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo E-mail vazio");
		} else if (campoSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio");
		} else {
			GerenciadorAdmin gerenciador = GerenciadorAdmin.getInstance();
			if (gerenciador.getEmailAdmin() == null && gerenciador.getSenhaAdmin() == null) {
				JOptionPane.showMessageDialog(null, "Nenhum Administrador no Sistema!\nCadastre um Administrador.");
			} else if (gerenciador.getEmailAdmin().equals(campoEmail.getText())
					&& gerenciador.getSenhaAdmin().equals(campoSenha.getText())) {
				Stage s1 = new Stage();
				Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
				Scene scene = new Scene(root);

				CriarJSON credenciais = new CriarJSON();
				if (credenciais.getCredenciaisJSON() == null) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar Credenciais?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					if (opcao == JOptionPane.YES_OPTION) {
						credenciais.criarCredenciaisJSON(gerenciador.getEmailAdmin(), gerenciador.getSenhaAdmin(),
								gerenciador.getNomeAdmin());
					}
				}

				Stage stage = (Stage) gridPane.getScene().getWindow();
				stage.close();
				s1.setMaximized(true);
				s1.setScene(scene);
				s1.setTitle("Mercado");
				s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
				s1.show();
			} else {
				JOptionPane.showMessageDialog(null, "Senha ou E-mail incorreto");
			}
			campoEmail.setText("");
			campoSenha.setText("");
		}

	}

	@FXML
	private void acesarViewGoogle() throws Exception {
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

	@FXML
	private void acessarViewCadastrarAdmin() throws IOException {
		Stage s1 = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewCadastrarAdmin.fxml"));
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