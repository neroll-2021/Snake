package main.controller;

import static main.constant.Constants.GAME_HEIGHT;
import static main.constant.Constants.GAME_WIDTH;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.model.grid.Grid;
import main.model.snake.Direction;
import main.model.snake.Node;

import java.util.LinkedList;

/**
 * 控制器类，将视图类的事件传给模型类
 * @author Neroll
 * @version 0.1.0
 * @date 2022-05-08
 */
public class GameController implements EventHandler<KeyEvent> {

    private final Grid grid;

    public GameController() {
        grid = new Grid(GAME_WIDTH, GAME_HEIGHT);
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        switch (code) {
            case A -> grid.getSnake().setDirection(Direction.LEFT);
            case S -> grid.getSnake().setDirection(Direction.DOWN);
            case D -> grid.getSnake().setDirection(Direction.RIGHT);
            case W -> grid.getSnake().setDirection(Direction.UP);
        }
    }

    public LinkedList<Node> getSnakeBody() {
        return grid.getSnake().getBody();
    }

    public Node getSnakeHead() {
        return grid.getSnake().getHead();
    }

    public Node getFood() {
        return grid.getFood();
    }
}
