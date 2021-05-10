package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class ControllerViewCaixa implements Initializable{
	@FXML
	private GridPane grid;
	@FXML
	private TextArea textArea;
	
	@FXML
	private void voltar(ActionEvent event) throws IOException{
		Stage stage = (Stage) grid.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}
	@FXML
	private void somar(ActionEvent event){
		textArea.setText("R$ 00,00");
		TrayNotification tray = new TrayNotification();
		AnimationType type = AnimationType.POPUP;
		tray.setAnimationType(type);
		tray.setTitle("SOMA TOTAL!");
		tray.setMessage("SOMA: "+textArea.getText());
		tray.setNotificationType(NotificationType.INFORMATION);
		tray.showAndDismiss(Duration.millis(2000));
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
