package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tool.CriarJSON;

public class ControllerInicio implements Initializable {
	@FXML
	private ToggleGroup grupo;
	@FXML
	private BorderPane border;
	@FXML
	private RadioMenuItem claro;
	@FXML
	private RadioMenuItem escuro;

	
	@FXML
	private void viewCadastrarProduto(ActionEvent event) throws IOException{
		Stage s1 = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewCadastrarProduto.fxml"));
		Scene scene = new Scene(root);

		Stage stage = (Stage) border.getScene().getWindow();
		stage.close();
		s1.setMaximized(true);
		s1.setScene(scene);
		s1.setTitle("Mercado");
		s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		s1.show();
		
	}
	@FXML
	private void viewAtualizacao(ActionEvent event) throws IOException{
		Stage s1 = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewUpdate.fxml"));
		Scene scene = new Scene(root);

		Stage stage = (Stage) border.getScene().getWindow();
		stage.close();
		s1.setMaximized(true);
		s1.setScene(scene);
		s1.setTitle("Mercado");
		s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		s1.show();
	}
	@FXML
	private void mudarTema(ActionEvent event) {
		CriarJSON json = new CriarJSON();
			if (claro.isSelected()) {
				border.getStylesheets().remove(border.getStylesheets().get(border.getStylesheets().size() - 1));
				border.getStylesheets().add(getClass().getResource("/view/EstiloWhiteInicio.css").toString());
				if(json.getConfigJSON().get("Tema")==null){
					json.addChaveEValorConfig("Tema", "claro");
				}else{
					json.atualizarValorConfig("Tema", "claro");
				}
			} else if (escuro.isSelected()) {
				border.getStylesheets().remove(border.getStylesheets().get(border.getStylesheets().size() - 1));
				border.getStylesheets().add(getClass().getResource("/view/EstiloViewInicioCSS.css").toString());
				if(json.getConfigJSON().get("Tema")==null){
					json.addChaveEValorConfig("Tema", "escuro");
				}else{
					json.atualizarValorConfig("Tema", "escuro");
				}
			}
	}

	@FXML
	private void acaoLogout(ActionEvent event) throws IOException {
		Stage s1 = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewLogin.fxml"));
		Scene scene = new Scene(root);

		CriarJSON json = new CriarJSON();
		json.atualizarValorConfig("Logado", false);

		Stage stage = (Stage) border.getScene().getWindow();
		stage.close();
		s1.setMaximized(true);
		s1.setScene(scene);
		s1.setTitle("Mercado");
		s1.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		s1.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CriarJSON json = new CriarJSON();
		JSONObject config = json.getConfigJSON();
		String tema = (String) config.get("Tema");
		if(tema!=null){
			if(tema.equals("claro")){
				border.getStylesheets().remove(border.getStylesheets().get(border.getStylesheets().size() - 1));
				border.getStylesheets().add(getClass().getResource("/view/EstiloWhiteInicio.css").toString());
			}else{
				border.getStylesheets().remove(border.getStylesheets().get(border.getStylesheets().size() - 1));
				border.getStylesheets().add(getClass().getResource("/view/EstiloViewInicioCSS.css").toString());
			}
		}
		config = null;
		json = null;
	}
}
