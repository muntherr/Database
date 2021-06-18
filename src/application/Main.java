package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
			primaryStage.setTitle("PAC");
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false); 
			primaryStage.show();
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
