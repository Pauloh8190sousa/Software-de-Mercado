package controller;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.Duration;
import system.Caixa;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
	private TextField codBarra;
	@FXML
	private TextField gramasCampo;

	@FXML
	private void cadastrarProduto(ActionEvent event){
		if(dateValidade.getValue()!=null && dateFabricacao!=null && !campoNomeProduto.getText().equals("") &&
				!campoPreco.getText().equals("") && !codBarra.getText().equals("") && !gramasCampo.getText().equals("")){
			String nome = campoNomeProduto.getText();
			float preco = Float.parseFloat(campoPreco.getText());
			LocalDate localVali = dateValidade.getValue();
			LocalDate localFabri = dateFabricacao.getValue();
			
			String dateVali = localVali.getDayOfMonth()+"/"+localVali.getMonthValue()+"/"+localVali.getYear();
			String dateFabri = localFabri.getDayOfMonth()+"/"+localFabri.getMonthValue()+"/"+localFabri.getYear();
			
			double cod = Double.parseDouble(codBarra.getText());
			float gramas = Float.parseFloat(gramasCampo.getText());
			Caixa caixa = Caixa.getInstance();
			caixa.addProductEstoque(preco, cod, nome, gramas,dateVali, dateFabri);
			TrayNotification tray = new TrayNotification();
			AnimationType type = AnimationType.POPUP;
			tray.setAnimationType(type);
			tray.setTitle("Cadastro de Produto");
			tray.setMessage("Produto cadastrado com sucesso");
			tray.setNotificationType(NotificationType.SUCCESS);
			tray.showAndDismiss(Duration.millis(2000));
			campoNomeProduto.setText("");
			campoPreco.setText("");
			codBarra.setText("");
			gramasCampo.setText("");
		}else{
			TrayNotification tray = new TrayNotification();
			AnimationType type = AnimationType.POPUP;
			tray.setAnimationType(type);
			tray.setTitle("Verefique os campos");
			tray.setMessage("Campo vazio!");
			tray.setNotificationType(NotificationType.ERROR);
			tray.showAndDismiss(Duration.millis(2000));
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UnaryOperator<Change> filter = change ->{
			String text = change.getControlNewText();
			if(text.matches("^[/[0-9].?!]*") && text.length()<=5){
				return change;
			}
			return null;
		};
		TextFormatter<String> textFormater = new TextFormatter<>(filter);
		
		campoPreco.setTextFormatter(textFormater);
		
		UnaryOperator<Change> filter2 = change ->{
			String text = change.getControlNewText();
			if(text.matches("^[0-9]*") && text.length()<=5){
				return change;
			}
			return null;
		};
		TextFormatter<String> textFormater2 = new TextFormatter<>(filter2);
		codBarra.setTextFormatter(textFormater2);
		
		UnaryOperator<Change> filter3 = change ->{
			String text = change.getControlNewText();
			if(text.matches("^[/[0-9].?!]*") && text.length()<=5){
				return change;
			}
			return null;
		};
		TextFormatter<String> textFormater3 = new TextFormatter<>(filter3);
		gramasCampo.setTextFormatter(textFormater3);
	}

}