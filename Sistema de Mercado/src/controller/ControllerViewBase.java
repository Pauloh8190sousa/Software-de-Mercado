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

				CriarJSON json = new CriarJSON();
				if (json.getCredenciaisJSON() == null) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar Credenciais?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					if (opcao == JOptionPane.YES_OPTION) {
						json.criarCredenciaisJSON(gerenciador.getEmailAdmin(), gerenciador.getSenhaAdmin(),
								gerenciador.getNomeAdmin());
					}
				}
				if (json.getConfigJSON() == null) {
					json.criarConfigJSON();
					json.addChaveEValorConfig("Logado", true);
				}else{
					json.atualizarValorConfig("Logado", true);
				}
				Stage stage = (Stage) gridPane.getScene().getWindow();
				Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
				Scene scene = new Scene(root,stage.getScene().getWidth(),stage.getScene().getHeight());
				stage.setScene(scene);
				
			} else {
				JOptionPane.showMessageDialog(null, "Senha ou E-mail incorreto");
			}
			campoEmail.setText("");
			campoSenha.setText("");
		}

	}

	@FXML
	private void acesarViewGoogle() throws Exception {
		Stage stage = (Stage) gridPane.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/LoginGoogle.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}

	@FXML
	private void acessarViewCadastrarAdmin() throws IOException {
		Stage stage = (Stage) gridPane.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewCadastrarAdmin.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CriarJSON json = new CriarJSON();
		JSONObject config = json.getConfigJSON();
		if (config != null) {
			String tema = (String) config.get("Tema");
			if (tema != null) {
				if (tema.equals("claro")) {
					gridPane.getStylesheets()
							.remove(gridPane.getStylesheets().get(gridPane.getStylesheets().size() - 1));
					gridPane.getStylesheets().add(getClass().getResource("/view/EstiloWhiteLogin.css").toString());
				} else {
					gridPane.getStylesheets()
							.remove(gridPane.getStylesheets().get(gridPane.getStylesheets().size() - 1));
					gridPane.getStylesheets().add(getClass().getResource("/view/EstiloViewLoginCSS.css").toString());
				}
			}
		}
		config = null;
		json = null;
	}
}