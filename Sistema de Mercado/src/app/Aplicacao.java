package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Aplicacao extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("/view/ViewLogin.fxml"));
		Scene scene = new Scene(root, 600, 400);
		arg0.setScene(scene);
		arg0.setTitle("Mercado");
		arg0.getIcons().add(new Image("/icons8-full-shopping-basket-30.png"));
		arg0.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
