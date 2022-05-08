package main.app;

import javafx.application.Application;
import main.controller.GameController;
import main.model.grid.Grid;
import main.view.GameView;

public class SnakeApp {
    public static void main(String[] args) {
        GameView view = new GameView();
        view.startGame();
    }
}
