package main.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.controller.GameController;

public class GameView extends Application {

    private final GameController controller;

    public GameView() {
        controller = new GameController();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Text gameTitle = new Text("Snake");
        gameTitle.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 45));
        Group root = new Group(gameTitle);
        Scene scene = new Scene(root, 900, 600);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, controller);
//        stage.addEventHandler(KeyEvent.KEY_PRESSED, controller);
        stage.setScene(scene);
        stage.setTitle("Snake");
        stage.show();
    }

    public void startGame() {
        launch();
    }

}
