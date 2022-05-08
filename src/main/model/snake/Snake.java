package main.model.snake;

import java.util.LinkedList;

import static main.constant.Constants.INITIAL_LENGTH;
import static main.constant.Constants.INITIAL_POS_X;
import static main.constant.Constants.INITIAL_POS_Y;
import static main.constant.Constants.NODE_LENGTH;

/**
 * 贪吃蛇
 * @author Neroll
 * @version 0.1.0
 * @date 2022-05-08
 */
public class Snake {

    /* 贪吃蛇的身体 */
    private final LinkedList<Node> body;

    /* 贪吃蛇当前的运动方向 */
    private Direction direction;

    public Snake() {
        body = new LinkedList<>();
        initBody();
        Node node = new Node(18, 10);
        body.addFirst(node);
        node = new Node(17, 10);
        direction = Direction.RIGHT; // 游戏开始时默认向右运动
    }

    private void initBody() {
        for (int i = 0; i < INITIAL_LENGTH; i++) {
            Node node = new Node(INITIAL_POS_X - i * NODE_LENGTH, INITIAL_POS_Y);
            body.addLast(node);
        }
    }

    /* 获得蛇的头 */
    public Node getHead() {
        return body.getFirst();
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    /* 获得蛇的尾 */
    /*
    public Node getTail() {
        return body.getLast();
    }*/

    public void addLength() {

    }

    /* 当用户输入的方向与当前蛇的运动方向不相反时，更新当前方向 */
    public void setDirection(Direction newDirection) {
        if (!this.direction.isOppositeWith(newDirection)) {
            this.direction = newDirection;
//            System.out.println("current direction:" + this.direction);
        }
    }

    /* 蛇沿着当前方向前进一格 */
    public void move() {
        int x = getHead().getX();
        int y = getHead().getY();
        switch (direction) {
            case UP -> y--;
            case DOWN -> y++;
            case LEFT -> x--;
            case RIGHT -> x++;
        }
        Node head = new Node(x, y);
        body.addFirst(head);
        body.removeLast();
    }
}




