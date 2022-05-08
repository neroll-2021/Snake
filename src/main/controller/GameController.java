package main.controller;

import javafx.scene.input.KeyEvent;
import main.model.grid.Grid;
import main.view.GameView;

public class GameController {
    private Grid grid;
    private GameView view;

    public GameController(Grid grid, GameView view) {
        this.grid = grid;
        this.view = view;
        view.getWindow().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            System.out.println("pressed");
        });
    }
}
