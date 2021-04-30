package controller;
import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tool.CampoFormatadoText;
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
	public void cadastrarProduto(ActionEvent event){
		String nome = campoNomeProduto.getText();
		float preco = Float.parseFloat(campoPreco.getText());
		System.out.println(preco);
		LocalDate dateVali = dateValidade.getValue();
		LocalDate dateFabri = dateFabricacao.getValue();
//		Caixa caixa = Caixa.getInstance();
//		caixa.addProductEstoque(preco, 0, nome, 0,dateVali, dateFabri);
		TrayNotification tray = new TrayNotification();
		AnimationType type = AnimationType.POPUP;
		tray.setAnimationType(type);
		tray.setTitle("Cadastro de Produto");
		tray.setMessage("Cadastrado o produto com sucesso");
		tray.setNotificationType(NotificationType.SUCCESS);
		tray.showAndDismiss(Duration.millis(2000));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		UnaryOperator<Change> filter = change ->{
//			String text = change.getText();
//			if(!text.matches("") && text.length()<5){
//				return change;
//			}
//			return null;
//		};
//		TextFormatter<String> textFormater = new TextFormatter<>(filter);
		CampoFormatadoText campoForm = new CampoFormatadoText(new Locale("pt", "BR"), campoPreco);
		campoPreco = campoForm.getCampo();
		
	}

}