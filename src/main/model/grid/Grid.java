package main.model.grid;

import main.model.snake.Node;
import main.model.snake.Snake;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import static main.constant.Constants.*;

/**
 * 模型类
 * @author Neroll
 * @version 0.1.0
 * @date 2022-05-08
 */
public class Grid {
    private final int width;
    private final int height;
    private final boolean[][] grid;

    private Node food;

    private final Snake snake;

    private GameStatus status;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
        status = GameStatus.RUNNING;
        snake = new Snake();
        createFood();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void createFood() {
        Random random = new Random();
        int x = random.nextInt(GAME_WIDTH / NODE_LENGTH);
        int y = random.nextInt(GAME_HEIGHT / NODE_LENGTH);
        food = new Node(x, y);

        ListIterator<Node> iterator = snake.getBody().listIterator();
        Node snakeBodyNode;
        while (iterator.hasNext()) {
            snakeBodyNode = iterator.next();
            while (snakeBodyNode.isOverlapWith(food)) {
                x = random.nextInt(GAME_WIDTH / NODE_LENGTH);
                y = random.nextInt(GAME_HEIGHT / NODE_LENGTH);
                food = new Node(x, y);
            }
        }

    }

    public Node getFood() {
        return food;
    }
}

enum GameStatus {
    PAUSE, GAME_OVER, RUNNING
}
