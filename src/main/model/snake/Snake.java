package main.model.snake;

import java.util.LinkedList;

/**
 * 贪吃蛇
 * @author Neroll
 * @version 0.1.0
 */
public class Snake {

    /* 贪吃蛇的身体 */
    private LinkedList<Node> body;

    /* 贪吃蛇当前的运动方向 */
    private Direction direction;

    public Snake() {
        body = new LinkedList<>();
        direction = Direction.RIGHT; // 游戏开始时默认向右运动
    }

    public Node getHead() {
        return body.getFirst();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {

    }
}

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

enum Direction {
    UP, LEFT, RIGHT, DOWN
}
