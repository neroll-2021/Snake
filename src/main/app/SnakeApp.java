package main.app;

import javafx.application.Application;
import main.controller.GameController;
import main.model.grid.Grid;
import main.view.GameView;

public class SnakeApp {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        Grid grid = new Grid(50, 50);

        gameView.getStart();
        GameController controller = new GameController(grid, gameView);

    }
}
