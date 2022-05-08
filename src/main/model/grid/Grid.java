package main.model.grid;

import main.model.snake.Snake;

public class Grid {
    private final int width;
    private final int height;
    private final boolean[][] grid;

    private final Snake snake;

    private GameStatus status;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
        status = GameStatus.RUNNING;
        snake = new Snake();
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
}

enum GameStatus {
    PAUSE, GAME_OVER, RUNNING
}
