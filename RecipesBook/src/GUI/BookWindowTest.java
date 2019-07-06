package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookWindowTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//CECI EST UN COMM TU TEST THE COMMIT FCT
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root, 400, 400);
			VBox v = new VBox();
			v.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
			//v.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
			
			Scene scene = new Scene(v, 352, 505);
			scene.setFill(null);
			
			Image img = new Image("GUI/CookingBookScantitreSD.jpg");
			ImageView imgView = new ImageView(img);
			v.getChildren().add(imgView);
			
			primaryStage.centerOnScreen();
			//primaryStage.setFullScreen(true);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
