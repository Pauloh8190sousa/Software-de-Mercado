package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControllerViewCadastrarProduto implements Initializable{
	@FXML
	private TextField campoNomeProduto;
	@FXML
	private TextField campoPreco;
	@FXML
	private DatePicker dateValidade;
	@FXML
	private DatePicker dateFabricacao;
	
	@FXML
	public void cadastrarProduto(ActionEvent event){
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
