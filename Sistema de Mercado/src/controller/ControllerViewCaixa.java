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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class ControllerViewCaixa implements Initializable {
	@FXML
	private GridPane grid;
	@FXML
	private TextArea textArea;

	@FXML
	private void teclado(KeyEvent keyEvent) {
		if (keyEvent.getText().matches("[0-9]")) {
			if (textArea.getText().equals("")) {
				textArea.setText(keyEvent.getText());
			} else {
				textArea.setText(textArea.getText() + "\n" + keyEvent.getText());
			}
		}
	}

	@FXML
	private void voltar(ActionEvent event) throws IOException {
		Stage stage = (Stage) grid.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}

	@FXML
	private void somar(ActionEvent event) {
		TrayNotification tray = new TrayNotification();
		AnimationType type = AnimationType.POPUP;
		tray.setAnimationType(type);
		tray.setTitle("SOMA TOTAL!");

		if (textArea.getText().contains("-")) {
			
			tray.setTitle("ATENÇÃO!");
			tray.setMessage("SOMA TOTAL JÁ FOI EXECUTADA");
			tray.setNotificationType(NotificationType.WARNING);
			tray.showAndDismiss(Duration.millis(3000));
			
		}else if(textArea.getText().equals("")){
			tray.setTitle("NENHUM NÚMERO FOI INSERIDO");
			tray.setMessage("NÃO HÁ NÚMEROS\nDIGITE ALGUM NÚMERO PARA SOMAR!");
			tray.setNotificationType(NotificationType.ERROR);
			tray.showAndDismiss(Duration.millis(3000));
		}else {
			
			String[] array = textArea.getText().split("\n");
			float soma = 0;
			for (int i = 0; i < array.length; i++) {
				float num = Float.parseFloat(array[i]);
				soma += num;
			}
			textArea.setText(textArea.getText() + "\n----------------\n");
			textArea.setText(textArea.getText() + "Total: R$ " + soma);
			tray.setMessage("SOMA: " + soma);
			tray.setNotificationType(NotificationType.INFORMATION);
			tray.showAndDismiss(Duration.millis(2000));
		}

	}

	@FXML
	private void limpar(ActionEvent event) {
		textArea.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
