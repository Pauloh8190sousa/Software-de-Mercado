package controller;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

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
//		if(testarConexao()==false){
//			JOptionPane.showMessageDialog(null, "Sem conexão com a internet");
//		}else{
			progress.setVisible(true);
			Update up = new Update();
			FileSystemView system = FileSystemView.getFileSystemView();
			String path = system.getHomeDirectory().getPath();
			System.out.println(path+"/teto.mp3");
			up.dowload(path+"/notificacao.mp3");
				System.out.println("Executado");
//		}
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
