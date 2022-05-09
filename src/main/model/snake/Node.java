package main.model.snake;

/**
 * 画面的最小单位
 * @author Neroll
 * @version 0.1.0 2022-05-08
 */
public class Node {
    private final int x; // 当前点的右侧距离画面的左侧有多少个点
    private final int y; // 当前点的底部距离画面的顶部有多少个点

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

    /* 判断两个点是否重叠 */
    public boolean isOverlappedWith(Node node) {
        return x == node.getX() && y == node.getY();
    }
}
