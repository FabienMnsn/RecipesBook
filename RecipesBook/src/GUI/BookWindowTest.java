package GUI;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookWindowTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root, 400, 400);
			Button readB = new Button("Consulter");
			Button editB = new Button("Modifier");
			editB.setTranslateY(65);
			readB.setStyle(""
					+ "-fx-font: 25 arial; "
					+ "-fx-base: #660000; "
					+ "-fx-border-color: #b30000; "
					+ "-fx-text-fill: #808080; "
					+ "-fx-border-width: 1px; "
					+ "-fx-border_style: solid;");
			
			editB.setStyle(""
					+ "-fx-font: 25 arial; "
					+ "-fx-base: #660000; "
					+ "-fx-border-color: #b30000; "
					+ "-fx-text-fill: #808080; "
					+ "-fx-border-width: 1px; "
					+ "-fx-border_style: solid;");
			
			StackPane stackpane = new StackPane();
			//VBox v = new VBox();
			//v.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
			//v.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
			
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
						
			Image img = new Image("GUI/CookingBookScantitreSD.jpg", screen.getHeight()/2, 0, true, true);
			ImageView imgView = new ImageView(img);
			System.out.println("Image resize ["+img.getHeight()+", "+img.getWidth()+"]");
			
			Scene scene = new Scene(stackpane, img.getWidth(), img.getHeight());
			scene.setFill(null);
			
			//imgView.setFitHeight(352);
			//imgView.setFitWidth();
			stackpane.getChildren().addAll(imgView, readB, editB);
			
			primaryStage.centerOnScreen();
			//primaryStage.setFullScreen(true);
			//primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initStyle(StageStyle.DECORATED);
			
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
