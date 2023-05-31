package com.example.lab9;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sokoban Game");
        this.primaryStage.setHeight(500);
        this.primaryStage.setWidth(500);
        showMainMenu();
    }

    private void showMainMenu() {
        Button newGameButton = new Button("New Game");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(newGameButton);
//        Label helloLabel = new Label("Sokoban Game");
//        borderPane.setTop(helloLabel);
        newGameButton.setOnAction(event -> showLevelSelection());


        Scene mainMenuScene = new Scene(borderPane,500,500);
        borderPane.applyCss();
        borderPane.layout();

        primaryStage.setScene(mainMenuScene);

        primaryStage.show();

        primaryStage.sizeToScene();
    }
    private void showLevelSelection() {
        Button[] buttons = new Button[3];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("map " + (i+1));
        }


        buttons[0].setOnAction(event -> showNameInput(1));
        buttons[1].setOnAction(event -> showNameInput(2));
        buttons[2].setOnAction(event -> showNameInput(3));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(buttons);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);




        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);

        Scene levelSelectionScene = new Scene(borderPane,500,500);

        primaryStage.setScene(levelSelectionScene);

        primaryStage.show();
        primaryStage.sizeToScene();
    }
    private void showNameInput(int level) {
        TextField nameInput = new TextField();
        Button continueButton = new Button("Continue");
        nameInput.setPrefSize(100, 35);
        continueButton.setOnAction(event -> startGame(level, nameInput.getText()));

        VBox vbox = new VBox(nameInput, continueButton);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);
        Scene nameInputScene = new Scene(borderPane,500,500);
        primaryStage.setScene(nameInputScene);


        primaryStage.show();
        primaryStage.sizeToScene();
    }

    private void startGame(int level, String playerName) {
        //switch
        Controller.readMap("src/main/resources/com/example/lab9/map/map.txt");
        int width = 500;
        int height = 500;
        Canvas canvas = new Canvas(width, height);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        Controller.drawMap(gc);
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        scene.setOnMousePressed(mouseEvent -> {
            int[] clickPos = getClickPos(mouseEvent.getX(), mouseEvent.getY(), entityWidth, entityHeight);
            if (Controller.click(clickPos[0], clickPos[1])) {
                Controller.drawMap(gc);
            }
        });
        pane.getChildren().add(canvas);
        primaryStage.setTitle("map"+level);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    final static int entityWidth = 100;
    final static int entityHeight = 100;
    //转化为上下左右
    public static int[] getClickPos(double click_x, double click_y, int entityWidth, int entityHeight){
        int[] pos = new int[2];
        pos[0] = (int) (click_x / entityWidth);
        pos[1] = (int) (click_y / entityHeight);
        return pos;
    }







}
