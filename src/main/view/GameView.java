package main.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameView extends Application {

    private Stage window;

    @Override
    public void start(Stage stage) throws Exception
    {
        window = stage;
        window.setTitle("Snake");
        window.show();
    }

    public void getStart() {
        launch();
    }

    public Stage getWindow() {
        return window;
    }
}
