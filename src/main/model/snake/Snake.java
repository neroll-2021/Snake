package main.model.snake;

import java.util.LinkedList;
import java.util.ListIterator;

import static main.constant.Constants.*;

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
        direction = Direction.RIGHT; // 游戏开始时默认向右运动
    }

    private void initBody() {
        for (int i = 0; i < INITIAL_LENGTH; i++) {
            Node node = new Node(INITIAL_POS_X - i, INITIAL_POS_Y);
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
        ListIterator<Node> iterator = body.listIterator(body.size() - 1);
        Node tail = body.getLast();
        Node lastSecond = iterator.previous();
        int x = tail.getX();
        int y = tail.getY();
        if (tail.getX() == lastSecond.getX()) {
            if (tail.getY() < lastSecond.getY()) {
                y--;
            } else {
                y++;
            }
        } else if (tail.getY() == lastSecond.getY()) {
            if (tail.getX() < lastSecond.getX()) {
                x--;
            } else {
                x++;
            }
        }

        Node newTail = new Node(x, y);
        body.addLast(newTail);
    }

    /* 当用户输入的方向与当前蛇的运动方向不相反时，更新当前方向 */
    public void setDirection(Direction newDirection) {
        if (!newDirection.isOppositeWith(this.direction)) {
            this.direction = newDirection;
            System.out.println("current direction:" + this.direction);
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
        System.out.println("x=" + x + " y=" + y);
        body.addFirst(head);
        body.removeLast();
    }

    public boolean isCollidedWith(Node node) {
        return getHead().isOverlappedWith(node);
    }

    private boolean isOutOfBound() {
        return getHead().getX() <= 0 || getHead().getX() > GAME_WIDTH / NODE_LENGTH
                || getHead().getY() <= 0 || getHead().getY() > GAME_HEIGHT / NODE_LENGTH;
    }

    public boolean isDead() {
        boolean collideSelf = false;
        ListIterator<Node> iterator = body.listIterator(1);
        Node bodyNode;
        while (iterator.hasNext()) {
            bodyNode = iterator.next();
            if (isCollidedWith(bodyNode)) {
                collideSelf = true;
                break;
            }
        }
        return isOutOfBound() || collideSelf;
    }
}




