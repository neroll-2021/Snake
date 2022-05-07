package main.model.grid;

import main.model.snake.Snake;

public class Grid {
    private final int width;
    private final int height;

    private Snake snake;

    private GameStatus status;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        status = GameStatus.RUNNING;
        snake = new Snake();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

enum GameStatus {
    PAUSE, GAME_OVER, RUNNING
}
