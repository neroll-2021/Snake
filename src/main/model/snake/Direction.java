package main.model.snake;

/**
 * 方向枚举类，包含蛇所有可能的运动方向
 * @author Neroll
 * @version 0.1.0
 * @date 2022-05-08
 */
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
