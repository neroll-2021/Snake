package main.app;

import main.view.GameView;

/**
 * 主类，游戏程序的入口
 * @author Neroll
 * @version 0.1.0
 * @date 2022-05-08
 */
public class SnakeApp {
    public static void main(String[] args) {
        GameView view = new GameView();
        view.startGame();
    }
}
