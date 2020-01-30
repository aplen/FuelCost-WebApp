
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
	public void start(Stage primaryStage) throws Exception {
	    FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/MainView.FXML"));
		AnchorPane root = loader.load();
		
	
	Scene scene = new Scene(root);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.setTitle("Koszt Paliwa");
	primaryStage.show();
    }	
    

	public static void main(String[] args) {
		launch(args);
	}
}
