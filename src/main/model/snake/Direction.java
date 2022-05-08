package main.model.snake;

public enum Direction {
    UP(1), LEFT(2), RIGHT(-2), DOWN(-1);

    private final int directionCode;

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

    public boolean isOppositeWith(Direction newDirection) {
        return this.directionCode == -newDirection.directionCode;
    }
}
