package main.app;

import javafx.application.Application;
import main.view.GameView;

public class SnakeApp {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.getStart();
    }
}
