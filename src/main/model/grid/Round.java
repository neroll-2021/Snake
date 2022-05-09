package main.model.grid;

import main.controller.GameController;

import static main.constant.Constants.*;

public class Round implements Runnable {

    private final GameController controller;

    public Round(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                controller.moveSnake();
                if (!controller.snakeIsDead()) {
                    controller.setHasMoved();
                    controller.ifEatFood();
                    controller.repaintScreen();
                    if (controller.getScore() <= INIT_SCORE)
                        Thread.sleep(INIT_ROUND_INTERVAL);
                    else if (controller.getScore() <= SLOW_SCORE)
                        Thread.sleep(SLOW_ROUND_INTERVAL);
                    else if (controller.getScore() <= NORM_SCORE)
                        Thread.sleep(NORM_ROUND_INTERVAL);
                    else if (controller.getScore() <= FAST_SCORE)
                        Thread.sleep(FASTER_ROUND_INTERVAL);
                    else
                        Thread.sleep(FAST_ROUND_INTERVAL);
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
