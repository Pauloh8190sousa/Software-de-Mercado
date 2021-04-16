package controller;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import tool.Update;

public class ControllerViewUpdate implements Initializable{
	@FXML
	private ProgressIndicator progress;
	
	@FXML
	private void procurarUpdate(ActionEvent event){
		if(testarConexao()==false){
			JOptionPane.showMessageDialog(null, "Sem conex�o com a internet");
		}else{
			progress.setVisible(true);
			FileSystemView system = FileSystemView.getFileSystemView();
			String path = system.getHomeDirectory().getPath();
			new Thread(){
				@Override
				public void run() {
					Update.atualizar("URL DO ARQUIVO", path);
				}
			}.start();
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
