package main.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.controller.GameController;

public class GameView extends Application {

    private GameController controller;

    public GameView() {
        controller = new GameController();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.addEventFilter(KeyEvent.KEY_PRESSED, controller);
        stage.setTitle("Snake");
        stage.show();
    }

    public void startGame() {
        launch();
    }

}
