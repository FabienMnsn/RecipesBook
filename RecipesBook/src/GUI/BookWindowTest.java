package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookWindowTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			
			//---------------------
			//SCENE 1 (MAIN SCREEN)
			//---------------------
			Button readB = new Button("Consulter");
			Button editB = new Button("Modifier");
			Button quitB = new Button("Quitter");
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
			editB.setTranslateY(65);
			quitB.setStyle(""
					+ "-fx-font: 25 arial; "
					+ "-fx-base: #660000; "
					+ "-fx-border-color: #b30000; "
					+ "-fx-text-fill: #808080; "
					+ "-fx-border-width: 1px; "
					+ "-fx-border_style: solid;");
			quitB.setTranslateY(130);
			StackPane stackpaneMain = new StackPane();		
			Image img = new Image("GUI/CookingBookScantitreSD.jpg", screen.getHeight()/2, 0, true, true);
			ImageView imgView = new ImageView(img);
			//System.out.println("Image resize ["+img.getHeight()+", "+img.getWidth()+"]");
			Scene mainScene = new Scene(stackpaneMain, img.getWidth(), img.getHeight());
			//mainScene.setFill(null);
			stackpaneMain.getChildren().addAll(imgView, readB, editB, quitB);
			//---------------------
			//BUTTON HANDLER SCENE1
			//---------------------
			readB.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e) {
					System.out.println("Consultation");
				}
			});
			editB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					System.out.println("Modifier");
				}
			});
			quitB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					System.out.println("Quitting");
					primaryStage.close();
				}
			});
			
			//----------------------------
			//SCENE 2 (CONSULTATION SCREEN)
			//----------------------------
			Button nextButton = new Button(">");
			Button previousButton = new Button("<");
			Button quitConsultButton = new Button("Quitter");
			//-------------------------------
			//BUTTON BOX (NEXT PREVIOUS QUIT)
			//-------------------------------
			HBox buttonHBox = new HBox();
			VBox buttonVBox = new VBox();
			buttonHBox.getChildren().addAll(previousButton, nextButton);
			buttonVBox.getChildren().addAll(buttonHBox, quitConsultButton);
			//--------------------------------------
			//CONSULTATION WINDOW MAIN VBOX AND HBOX
			//--------------------------------------
			
			//------------------
			//CONSULTATION SCENE
			//------------------
			StackPane stackpaneConsult = new StackPane();
			Scene consultScene = new Scene(stackpaneConsult, screen.getWidth(), screen.getHeight());
			
			/*
			readSceneB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(mainScene);
				}
			});
			*/
			
			
			//-------------------
			//PRIMARY STAGE SETUP
			//-------------------
			
			//primaryStage.centerOnScreen();
			//primaryStage.setFullScreen(true);
			//primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
