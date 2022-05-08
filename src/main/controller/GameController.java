package main.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.model.grid.Grid;
import main.model.snake.Direction;
import main.constant.Constants;
import main.view.GameView;
import main.model.snake.Snake;

public class GameController implements EventHandler<KeyEvent> {

    private final Grid grid;

    public GameController() {
        grid = new Grid(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println("exe");
        KeyCode code = keyEvent.getCode();
        switch (code) {
            case A -> grid.getSnake().setDirection(Direction.LEFT);
            case S -> grid.getSnake().setDirection(Direction.DOWN);
            case D -> grid.getSnake().setDirection(Direction.RIGHT);
            case W -> grid.getSnake().setDirection(Direction.UP);
            default -> System.out.println("default");
        }
    }
}
