package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import system.Caixa;
import system.Product;

public class ControllerViewListarProduto implements Initializable{
	@FXML
	private TableView<Product> table;
	@FXML
	private TableColumn<Product, Double> codBarras;
	@FXML
	private TableColumn<Product, String> descricao;
	@FXML
	private TableColumn<Product, Float> preco;
	@FXML
	private TableColumn<Product, String> validade;
	@FXML
	private GridPane grid;
	
	@FXML
	private void voltar(ActionEvent event) throws IOException{
		Stage stage = (Stage) grid.getScene().getWindow();
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewInicio.fxml"));
		Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
		stage.setScene(scene);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Product> list = FXCollections.observableArrayList();
		ArrayList<Product> array = Caixa.getProdutos();
		list.setAll(array);
		codBarras.setCellValueFactory(new PropertyValueFactory<Product, Double>("codBarra"));
		descricao.setCellValueFactory(new PropertyValueFactory<Product, String>("descricao"));
		preco.setCellValueFactory(new PropertyValueFactory<Product, Float>("preco"));
		validade.setCellValueFactory(new PropertyValueFactory<Product, String>("dataValidade"));
		
		table.setItems(list);
	}

}
