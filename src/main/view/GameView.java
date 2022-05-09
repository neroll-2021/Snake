package main.view;

import static main.constant.Constants.WINDOW_WIDTH;
import static main.constant.Constants.WINDOW_HEIGHT;
import static main.constant.Constants.GAME_WIDTH;
import static main.constant.Constants.GAME_HEIGHT;
import static main.constant.Constants.NODE_LENGTH;
import static main.constant.Constants.GAME_OVER_X;
import static main.constant.Constants.GAME_OVER_Y;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import main.controller.GameController;
import main.model.grid.Round;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 游戏视图类，展示游戏窗口和游戏界面
 * @author Neroll
 * @date 2022-05-08
 */
public class GameView extends Application {

    private final GameController controller;
    private final Canvas canvas;
    private final GraphicsContext context;

    public GameView() {
        controller = new GameController(this);
        canvas = new Canvas();
        context = canvas.getGraphicsContext2D();
    }

    public void paintScreen() {

        /* 将画面填充为黑色 */
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        /* 获取蛇身的迭代器 */
        LinkedList<main.model.snake.Node> snakeBody = controller.getSnakeBody();
        ListIterator<main.model.snake.Node> iterator = snakeBody.listIterator();
        main.model.snake.Node node;

        /* 绘制蛇的头 */
        context.setFill(Color.LIGHTGREEN);
        main.model.snake.Node snakeHead = iterator.next();
        context.fillRect((snakeHead.getX() - 1) * NODE_LENGTH, (snakeHead.getY() - 1) * NODE_LENGTH,
                        NODE_LENGTH, NODE_LENGTH);

        /* 绘制蛇的身体 */
        context.setFill(Color.WHITE);
        while (iterator.hasNext()) {
            node = iterator.next();
//            System.out.println("x=" + node.getX() + " y=" + node.getY());
            context.fillRect((node.getX() - 1) * NODE_LENGTH, (node.getY() - 1) * NODE_LENGTH,
                            NODE_LENGTH, NODE_LENGTH);
        }

        /* 绘制食物 */
        node = controller.getFood();
        context.fillRect((node.getX() - 1) * NODE_LENGTH, (node.getY() - 1) * NODE_LENGTH,
                            NODE_LENGTH, NODE_LENGTH);
    }

    public void paintGameOver() {
        context.setFill(Color.AQUA);
        context.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        context.fillText("GAME OVER", GAME_OVER_X * NODE_LENGTH, GAME_OVER_Y * NODE_LENGTH);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Text scoreTip = new Text("Score:");
        scoreTip.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 25));

        int score = controller.getScore();
        Text scoreText = new Text(score + "");
        scoreText.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40));

        VBox vBox = new VBox();
        ObservableList<Node> vlist = vBox.getChildren();
        vlist.addAll(scoreTip, scoreText);
        vBox.setPadding(new Insets(15));

        canvas.setWidth(GAME_WIDTH);
        canvas.setHeight(GAME_HEIGHT);
        paintScreen();

        Round round = new Round(controller);
        Thread task = new Thread(round);
        task.setDaemon(true);
        task.start();

        HBox hBox = new HBox();
        ObservableList<Node> hlist = hBox.getChildren();
        hlist.addAll(canvas, vBox);

        Group root = new Group(hBox);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, controller);

        stage.setScene(scene);
        stage.setTitle("Snake");
        stage.setResizable(false);
        stage.show();
    }

    public void startGame() {
        launch();
    }

}
