package pl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreTable extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        OknoRankingowe root = new OknoRankingowe(primaryStage);
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle("Score Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
