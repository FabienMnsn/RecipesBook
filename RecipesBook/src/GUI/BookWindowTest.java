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
			
			//#########################################################################################
			
			//----------------------------
			//SCENE 2 (CONSULTATION SCREEN)
			//----------------------------
			Button nextConsultButton = new Button("Recette suivante");
			Button previousConsultButton = new Button("Recette précédente");
			Button quitConsultButton = new Button("Fermer le Livre");
			//-------------------------------
			//BUTTON BOX (NEXT PREVIOUS QUIT)
			//-------------------------------
			HBox consultButtonHBox = new HBox();
			consultButtonHBox.setAlignment(Pos.TOP_CENTER);
			Region region1 = new Region();
			Region region2 = new Region();
			consultButtonHBox.setHgrow(region1, Priority.ALWAYS);
			consultButtonHBox.setHgrow(region2, Priority.ALWAYS);
			//buttonHBox.setSpacing((screen.getWidth()/2)/3-80);
			consultButtonHBox.getChildren().addAll(previousConsultButton, region1, quitConsultButton, region2, nextConsultButton);
			//--------------------------------------
			//CONSULTATION WINDOW MAIN VBOX AND HBOX
			//--------------------------------------
			HBox consultMainHBox = new HBox();
			//------------------------------
			//CONSULTATION WINDOW RIGHT PAGE
			//------------------------------
			BorderPane consultRightPageBP = new BorderPane();
			consultRightPageBP.setMaxSize(screen.getWidth()/2, screen.getHeight());
			consultRightPageBP.setMinSize(screen.getWidth()/2, screen.getHeight());
			consultRightPageBP.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label consultTitreRightPage = new Label("Titre de la recette");
			consultTitreRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			TextArea consultRecetteContentRightPage = new TextArea();
			consultRecetteContentRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" +
                    "-fx-border-radius: 2;" +
                    "-fx-border-color: black;"+
                    "-fx-opacity: 1;");
			consultRecetteContentRightPage.setEditable(false);
			consultRecetteContentRightPage.setDisable(true);
			consultRightPageBP.setMargin(consultRecetteContentRightPage, new Insets(10,0,12,0));
			consultRightPageBP.setAlignment(consultTitreRightPage, Pos.CENTER);
			consultRightPageBP.setTop(consultTitreRightPage);
			consultRightPageBP.setCenter(consultRecetteContentRightPage);
			consultRightPageBP.setBottom(consultButtonHBox);
			//rightPageBP.getChildren().addAll(titreRightPage, recetteContentRightPage, buttonHBox);
			
			//-----------------------------
			//CONSULTATION WINDOW LEFT PAGE
			//-----------------------------
			BorderPane consultLeftPageBP = new BorderPane();
			consultLeftPageBP.setMaxSize(screen.getWidth()/2, screen.getHeight());
			consultLeftPageBP.setMinSize(screen.getWidth()/2, screen.getHeight());
			consultLeftPageBP.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			
			Label consultSelectLeftPage = new Label("Sélectionnez une recette");
			consultSelectLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label consultCaracteristiquesLeftPage = new Label("Caractéristiques");
			consultCaracteristiquesLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label consultIngredientsLeftPage = new Label("Ingredients");
			consultIngredientsLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" +
                    "-fx-border-radius: 2;" +
                    "-fx-border-color: black;");
			
			consultLeftPageBP.setAlignment(consultSelectLeftPage, Pos.CENTER);
			consultLeftPageBP.setTop(consultSelectLeftPage);
			consultLeftPageBP.setLeft(consultCaracteristiquesLeftPage);
			consultLeftPageBP.setRight(consultIngredientsLeftPage);
			//------------------
			//CONSULTATION SCENE
			//------------------
			consultMainHBox.getChildren().addAll(consultLeftPageBP, consultRightPageBP);
			Pane consultPane = new Pane();
			consultPane.getChildren().add(consultMainHBox);
			Scene consultScene = new Scene(consultPane, screen.getWidth(), screen.getHeight());
			/*
			readSceneB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(mainScene);
				}
			});
			*/
			
			//#########################################################################################
			
			//------------------------
			//SCENE 3 (EDITION SCREEN)
			//------------------------
			
			Button editSaveButton = new Button("Sauvegarder la recette");
			Button editCancelButton = new Button("Abandonner la création");
			Button editQuitButton = new Button("Fermer le Livre");
			//-----------------------------
			//BUTTON BOX (SAVE QUIT CANCEL)
			//-----------------------------
			HBox editButtonHBox = new HBox();
			editButtonHBox.setAlignment(Pos.TOP_CENTER);
			Region region3 = new Region();
			Region region4 = new Region();
			editButtonHBox.setHgrow(region3, Priority.ALWAYS);
			editButtonHBox.setHgrow(region4, Priority.ALWAYS);
			//buttonHBox.setSpacing((screen.getWidth()/2)/3-80);
			editButtonHBox.getChildren().addAll(editCancelButton, region3, editQuitButton, region4, editSaveButton);
			//------------------------
			//EDITION WINDOW MAIN HBOX
			//------------------------
			HBox editMainHBox = new HBox();
			//-------------------------
			//EDITION WINDOW RIGHT PAGE
			//-------------------------
			BorderPane editRightPageBP = new BorderPane();
			editRightPageBP.setMaxSize(screen.getWidth()/2, screen.getHeight());
			editRightPageBP.setMinSize(screen.getWidth()/2, screen.getHeight());
			editRightPageBP.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label editTitreRightPage = new Label("Titre de la recette");
			editTitreRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			TextArea editRecetteContentRightPage = new TextArea();
			editRecetteContentRightPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" +
                    "-fx-border-radius: 2;" +
                    "-fx-border-color: black;"+
                    "-fx-opacity: 1;");
			editRecetteContentRightPage.setEditable(false);
			editRecetteContentRightPage.setDisable(true);
			editRightPageBP.setMargin(editRecetteContentRightPage, new Insets(10,0,12,0));
			editRightPageBP.setAlignment(editTitreRightPage, Pos.CENTER);
			editRightPageBP.setTop(editTitreRightPage);
			editRightPageBP.setCenter(editRecetteContentRightPage);
			editRightPageBP.setBottom(editButtonHBox);
			
			//------------------------
			//EDITION WINDOW LEFT PAGE
			//------------------------
			BorderPane editLeftPageBP = new BorderPane();
			editLeftPageBP.setMaxSize(screen.getWidth()/2, screen.getHeight());
			editLeftPageBP.setMinSize(screen.getWidth()/2, screen.getHeight());
			editLeftPageBP.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			
			Label editSelectLeftPage = new Label("Sélectionnez une recette");
			editSelectLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label editCaracteristiquesLeftPage = new Label("Caractéristiques");
			editCaracteristiquesLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" + 
                    "-fx-border-radius: 2;" + 
                    "-fx-border-color: black;");
			Label editIngredientsLeftPage = new Label("Ingredients");
			editIngredientsLeftPage.setStyle("-fx-padding: 10;" + 
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 2;" +
                    "-fx-border-radius: 2;" +
                    "-fx-border-color: black;");
			
			editLeftPageBP.setAlignment(editSelectLeftPage, Pos.CENTER);
			editLeftPageBP.setTop(editSelectLeftPage);
			editLeftPageBP.setLeft(editCaracteristiquesLeftPage);
			editLeftPageBP.setRight(editIngredientsLeftPage);
			//------------------
			//CONSULTATION SCENE
			//------------------
			editMainHBox.getChildren().addAll(editLeftPageBP, editRightPageBP);
			Pane editPane = new Pane();
			editPane.getChildren().add(editMainHBox);
			Scene editScene = new Scene(editPane, screen.getWidth(), screen.getHeight());
			
			//#########################################################################################
			
			//-------------------------
			//BUTTON HANDLER MAIN SCENE
			//-------------------------
			readB.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e) {
					//System.out.println("Consultation");
					primaryStage.setScene(consultScene);
					primaryStage.centerOnScreen();
				}
			});
			editB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(editScene);
					primaryStage.centerOnScreen();
				}
			});
			quitB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					//System.out.println("Quitting");
					primaryStage.close();
				}
			});
			
			//---------------------------------
			//BUTTON HANDLER CONSULTATION SCENE
			//---------------------------------
			previousConsultButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					//System.out.println("PREVIOUS recipe");
				}
			});
			quitConsultButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(mainScene);
					primaryStage.centerOnScreen();
				}
			});
			nextConsultButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					//System.out.println("NEXT recipe");
				}
			});
			
			//----------------------------
			//BUTTON HANDLER EDITION SCENE
			//----------------------------
			editSaveButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					System.out.println("recette sauvegardée !");
				}
			});
			
			editQuitButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(mainScene);
					primaryStage.centerOnScreen();
				}
			});
			
			//#########################################################################################
			
			//-------------------
			//PRIMARY STAGE SETUP
			//-------------------
			//primaryStage.centerOnScreen();
			//primaryStage.setFullScreen(true);
			//primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			//primaryStage.setScene(mainScene);
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
