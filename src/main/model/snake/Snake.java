package main.model.snake;

import java.util.LinkedList;
import java.util.ListIterator;

import static main.constant.Constants.*;
import static java.lang.Math.abs;

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

    /* 用户是否按下方向键 */
    private boolean hasMoved;

    /* 记录移动前蛇尾的位置 */
    private Node lastTail;

    public Snake() {
        body = new LinkedList<>();
        initBody();
        lastTail = body.getLast();
        hasMoved = false;
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

    public Node getTail() {
        return body.getLast();
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void addLength() {
        /*
        ListIterator<Node> iterator = body.listIterator(body.size());
        Node tail = iterator.previous();
        Node lastSecond = iterator.previous();
        int x = tail.getX();
        int y = tail.getY();*/

        /* 根据蛇身体的最后一个方块和倒数第二个方块的位置判断新增加的方块的位置 */
        /*
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

        Node newTail = new Node(x, y);*/

        Node newTail = new Node(lastTail.getX(), lastTail.getY());
        lastTail = newTail;
        body.addLast(newTail);
    }

    /* 当用户输入的方向与当前蛇的运动方向不相反时，更新当前方向 */
    public void setDirection(Direction newDirection) {
        if (!newDirection.isOppositeWith(this.direction) && !hasMoved) {
            this.direction = newDirection;
            hasMoved = true;
            System.out.println("current direction:" + this.direction);
        }
    }

    public void setHasMoved() {
        hasMoved = false;
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
        lastTail = body.getLast();
        body.removeLast();
        body.addFirst(head);

    }

    public boolean isCollidedWith(Node node) {
        return getHead().isOverlappedWith(node);
    }

    public boolean isAdjacentWith(Node node) {
        if (abs(getHead().getX() - node.getX()) == 1 && getHead().getY() == node.getY())
            return true;
        if (abs(getHead().getY() - node.getY()) == 1 && getHead().getX() == node.getX())
            return true;
        return false;
    }

    private boolean isOutOfBound() {
        if (getHead().getX() <= 0)
            return true;
        if (getHead().getX() > GAME_WIDTH / NODE_LENGTH)
            return true;
        if (getHead().getY() <= 0)
            return true;
        if (getHead().getY() > GAME_HEIGHT / NODE_LENGTH)
            return true;
        return false;
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




