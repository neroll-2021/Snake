package main.view;

import static main.constant.Constants.WINDOW_WIDTH;
import static main.constant.Constants.WINDOW_HEIGHT;
import static main.constant.Constants.GAME_WIDTH;
import static main.constant.Constants.GAME_HEIGHT;
import static main.constant.Constants.NODE_LENGTH;

import javafx.application.Application;
import javafx.collections.ObservableList;
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

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 游戏视图类，展示游戏窗口和游戏界面
 * @author Neroll
 * @date 2022-05-08
 */
public class GameView extends Application {

    private final GameController controller;

    public GameView() {
        controller = new GameController();
    }

    public void paintScreen(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        context.setFill(Color.WHITE);
        LinkedList<main.model.snake.Node> snakeBody = controller.getSnakeBody();
        ListIterator<main.model.snake.Node> iterator = snakeBody.listIterator();
        main.model.snake.Node node;
        while (iterator.hasNext()) {
            node = iterator.next();
            context.fillRect((node.getX() - 1) * NODE_LENGTH, (node.getY() - 1) * NODE_LENGTH,
                            node.getX() * NODE_LENGTH, node.getY() * NODE_LENGTH);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Text score = new Text("Score:");
        score.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 25));

        VBox vBox = new VBox();

        ObservableList<Node> vlist = vBox.getChildren();
        vlist.addAll(score);

        Canvas canvas = new Canvas();
        canvas.setWidth(GAME_WIDTH);
        canvas.setHeight(GAME_HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();
        paintScreen(context);


        HBox hBox = new HBox();
        ObservableList<Node> hlist = hBox.getChildren();
        hlist.addAll(canvas, vBox);

        Group root = new Group(hBox, vBox);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, controller);

        stage.setScene(scene);
        stage.setTitle("Snake");
        stage.show();
    }

    public void startGame() {
        launch();
    }

}
