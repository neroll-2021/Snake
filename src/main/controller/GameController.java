package main.controller;

import static main.constant.Constants.GAME_HEIGHT;
import static main.constant.Constants.GAME_WIDTH;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.model.grid.Grid;
import main.model.snake.Direction;

public class GameController implements EventHandler<KeyEvent> {

    private final Grid grid;

    public GameController() {
        grid = new Grid(GAME_WIDTH, GAME_HEIGHT);
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
