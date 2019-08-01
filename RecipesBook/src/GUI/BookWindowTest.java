package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
			
			//#########################################################################################
			
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
			
			//#########################################################################################
			
			//----------------------------
			//SCENE 2 (CONSULTATION SCREEN)
			//----------------------------
			Button nextButton = new Button("Recette suivante");
			Button previousButton = new Button("Recette précédente");
			Button quitConsultButton = new Button("Fermer le Livre");
			//-------------------------------
			//BUTTON BOX (NEXT PREVIOUS QUIT)
			//-------------------------------
			HBox buttonHBox = new HBox();
			buttonHBox.setAlignment(Pos.TOP_CENTER);
			Region region1 = new Region();
			Region region2 = new Region();
			buttonHBox.setHgrow(region1, Priority.ALWAYS);
			buttonHBox.setHgrow(region2, Priority.ALWAYS);
			//buttonHBox.setSpacing((screen.getWidth()/2)/3-80);
			buttonHBox.getChildren().addAll(previousButton, region1, quitConsultButton, region2, nextButton);
			//--------------------------------------
			//CONSULTATION WINDOW MAIN VBOX AND HBOX
			//--------------------------------------
			HBox mainHBox = new HBox();
			//------------------------------
			//CONSULTATION WINDOW RIGHT PAGE
			//------------------------------
			BorderPane rightPageBP = new BorderPane();
			rightPageBP.setMaxSize(screen.getWidth()/2, screen.getHeight());
			rightPageBP.setMinSize(screen.getWidth()/2, screen.getHeight());
			rightPageBP.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label titreRightPage = new Label("Titre de la recette");
			titreRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			TextArea recetteContentRightPage = new TextArea();
			recetteContentRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;"+
                    "-fx-opacity: 1;");
			recetteContentRightPage.setEditable(false);
			recetteContentRightPage.setDisable(true);
			rightPageBP.setMargin(recetteContentRightPage, new Insets(10,0,12,0));
			rightPageBP.setAlignment(titreRightPage, Pos.CENTER);
			rightPageBP.setTop(titreRightPage);
			rightPageBP.setCenter(recetteContentRightPage);
			rightPageBP.setBottom(buttonHBox);
			//rightPageBP.getChildren().addAll(titreRightPage, recetteContentRightPage, buttonHBox);
			
			//-----------------------------
			//CONSULTATION WINDOW LEFT PAGE
			//-----------------------------
			VBox leftPageVBox = new VBox();
			leftPageVBox.setMaxSize(screen.getWidth()/2, screen.getHeight());
			leftPageVBox.setMinSize(screen.getWidth()/2, screen.getHeight());
			leftPageVBox.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			leftPageVBox.setAlignment(Pos.TOP_CENTER);
			VBox topLeftPage = new VBox();
			HBox bottomLeftPage = new HBox();
			Label selectLeftPage = new Label("Sélectionnez une recette");
			selectLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label caracteristiquesLeftPage = new Label("Caractéristiques");
			caracteristiquesLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label ingredientsLeftPage = new Label("Ingredients");
			ingredientsLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			bottomLeftPage.getChildren().addAll(caracteristiquesLeftPage, ingredientsLeftPage);
			
			leftPageVBox.getChildren().addAll(selectLeftPage, bottomLeftPage);
			//------------------
			//CONSULTATION SCENE
			//------------------
			mainHBox.getChildren().addAll(leftPageVBox, rightPageBP);
			Pane paneConsult = new Pane();
			paneConsult.getChildren().add(mainHBox);
			Scene consultScene = new Scene(paneConsult, screen.getWidth(), screen.getHeight());
			/*
			readSceneB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(mainScene);
				}
			});
			*/
			
			//#########################################################################################
			
			//-------------------
			//PRIMARY STAGE SETUP
			//-------------------
			//primaryStage.centerOnScreen();
			//primaryStage.setFullScreen(true);
			//primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			//primaryStage.setScene(mainScene);
			primaryStage.setScene(consultScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
