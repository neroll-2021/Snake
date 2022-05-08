package main.model.grid;

import main.controller.GameController;

import static main.constant.Constants.ROUND_INTERVAL;

public class Round implements Runnable {

    private final GameController controller;

    public Round(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (!controller.snakeIsDead()) {
                    controller.moveSnake();
                    controller.ifEatFood();
                    controller.repaintScreen();
                    Thread.sleep(ROUND_INTERVAL);
                } else {
                    System.out.println("snake dead");
                    controller.paintGameOver();
                    Thread.currentThread().interrupt();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
