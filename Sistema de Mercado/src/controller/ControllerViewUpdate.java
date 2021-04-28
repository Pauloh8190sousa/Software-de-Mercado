package controller;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javax.swing.filechooser.FileSystemView;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.util.Duration;
import tool.Update;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class ControllerViewUpdate implements Initializable {
	@FXML
	private ProgressBar progress;
	@FXML
	private ProgressIndicator indicador;
	@FXML
	private Label texto;
	private float megabytes;

	@FXML
	private void procurarUpdate(ActionEvent event) {
		if (testarConexao() == false) {
			TrayNotification tray = new TrayNotification();
			AnimationType type = AnimationType.POPUP;
			tray.setAnimationType(type);
			tray.setTitle("Sem acesso a internet");
			tray.setMessage("Verifique sua internet");
			tray.setNotificationType(NotificationType.ERROR);
			tray.showAndDismiss(Duration.millis(2000));
		} else {
			indicador.setVisible(true);
			texto.setVisible(true);
			texto.setText("Baixando arquivos recentes");
			FileSystemView system = FileSystemView.getFileSystemView();
			String path = system.getHomeDirectory().getPath();
			String url = "URL";
			Thread t1 = new Thread() {
				public void run() {
					megabytes = Update.gravaArquivoDeURL(url, path, "deu certo", ".mp4", progress, indicador);
					if (megabytes > 0) {
						Thread thread = new Thread(new Task() {

							@Override
							protected Object call() throws Exception {

								Platform.runLater(() -> {
									TrayNotification tray = new TrayNotification();
									AnimationType type = AnimationType.POPUP;
									tray.setAnimationType(type);
									tray.setTitle("Atualização concluida");
									tray.setMessage("Arquivo baixado");
									tray.setNotificationType(NotificationType.SUCCESS);
									tray.showAndDismiss(Duration.millis(2000));
									texto.setText("Tamanho da atualização: " + megabytes + "MB");
								});
								return null;
							}
						});
						thread.start();
						thread.interrupt();
					}else{
						Thread thread = new Thread(new Task() {

							@Override
							protected Object call() throws Exception {

								Platform.runLater(() -> {
									TrayNotification tray = new TrayNotification();
									AnimationType type = AnimationType.POPUP;
									tray.setAnimationType(type);
									tray.setTitle("Sistema na última versão");
									tray.setMessage("O sistema se encontra na última versão");
									tray.setNotificationType(NotificationType.SUCCESS);
									tray.showAndDismiss(Duration.millis(2000));
									texto.setText("Nenhum atualização disponivel no momento");
								});
								return null;
							}
						});
						thread.start();
						thread.interrupt();
					}
				};
			};
			t1.start();
			t1.interrupt();
		}
	}

	private static boolean testarConexao() {
		try {
			URLConnection connection = (new URL("http://www.google.com.br")).openConnection();
			connection.connect();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
