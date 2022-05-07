package main.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameView extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Snake");
        stage.show();
    }

    public void getStart() {
        launch();
    }
}
