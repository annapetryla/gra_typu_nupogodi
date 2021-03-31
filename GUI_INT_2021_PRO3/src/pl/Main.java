package pl;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

    static int dimX = 800;
    static int dimY = 600;
    static int promien = 10;
    boolean isGameFinished = false;
    int counter = 0;
    private LongProperty score = new SimpleLongProperty(10);
    Button buttonStart = new Button("Start");
    Button highScoresButton = new Button("Ranking");
    Button exitButton = new Button("Exit");
    Label textLabel = new Label("Witaj. Wybierz jedna z opcji: ");
    private Label label = new Label();
    boolean showInputDialog = false;

    @Override
    public void start(Stage primaryStage) {
        GridPane root2 = new GridPane();
        root2.setPrefSize(180, 180);
        Parent content = root2;
        root2.setAlignment(Pos.CENTER);
        root2.add(textLabel,0,0);
        root2.add(buttonStart,0,1);
        root2.add(highScoresButton,0,2);
        root2.add(exitButton,0,3);
        Scene scene2 = new Scene(content);
        Stage window = new Stage();
        window.setX(1200);
        window.setY(400);
        window.setScene(scene2);
        window.show();

        EventHandler<ActionEvent> startButtonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                event.consume();
                StackPane root = new StackPane();
                PanelGry panelGry = new PanelGry(dimX,dimY);
                root.getChildren().add(panelGry);

                panelGry.liczbaZlapanych.setText("GG! " + score);
                panelGry.liczbaZlapanych.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 20));
                panelGry.liczbaZlapanych.setY(100);
                panelGry.liczbaZlapanych.setX(100);
                panelGry.liczbaZlapanych.setFill(Color.GREEN);
                panelGry.liczbaZlapanych.setVisible(true);
                panelGry.liczbaZlapanych.setOpacity(0);

                Label textLabel = new Label("Witaj. Wybierz jedna z opcji: ");
                root.getChildren().add(panelGry.liczbaZlapanych);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(setGameFinished()) {
                            try {
                                Thread.sleep(70);
                                counter++;
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                            panelGry.ruszJajka();
                            panelGry.ruszJajkaReverse();
                            System.out.println("Twoj wynik to: "+panelGry.score);
                            if( panelGry.isFinished){
                                isGameFinished = true;
                            }
                        }
                    }
                });
                thread.start();
                Scene scene = new Scene(root,dimX,dimY);
                root.setId("pane");
                scene.getStylesheets().addAll(this.getClass().getResource("background.css").toExternalForm());
                scene.setOnKeyPressed(keyEvent -> {
                    if(keyEvent.getCode().equals(KeyCode.UP)){
                        panelGry.koszyk.setDirection(Koszyk.Direction.UP);
                        panelGry.koszyk.poruszKoszyk();
                    }
                    if(keyEvent.getCode().equals(KeyCode.DOWN) ){
                        panelGry.koszyk.setDirection(Koszyk.Direction.DOWN);
                        panelGry.koszyk.poruszKoszyk();
                    }
                    if(keyEvent.getCode().equals(KeyCode.RIGHT)){
                        panelGry.koszyk.setDirection(Koszyk.Direction.RIGHT);
                        panelGry.koszyk.poruszKoszyk();
                    }
                    if(keyEvent.getCode().equals(KeyCode.LEFT) ){
                        panelGry.koszyk.setDirection(Koszyk.Direction.LEFT);
                        panelGry.koszyk.poruszKoszyk();
                    }
                    if(keyEvent.getCode().equals(KeyCode.Q)){ //skrót klawiaturowy
                        primaryStage.close();
                    }
                });
                primaryStage.setTitle("Nu pogodi game");
                primaryStage.setScene(scene);
                primaryStage.show();
                showInputTextDialog(panelGry);
            }
        };
        EventHandler<ActionEvent> highScoresButtonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                event.consume();
                try {
                    new ScoreTable().start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        EventHandler<ActionEvent> exitButtonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                event.consume();
                primaryStage.close();
            }
        };
        buttonStart.setOnAction(startButtonHandler);
        highScoresButton.setOnAction(highScoresButtonHandler);
        exitButton.setOnAction(exitButtonHandler);

    }

    public static void zakonczGre(Stage stage, PanelGry panelGry) {
            TilePane tilePane = new TilePane();
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setHeaderText("Podaj nick");
            textInputDialog.show();
            Scene sc = new Scene(tilePane, 50, 50);
            stage.setScene(sc);
            //stage.show();
            FileWriter fw = null;
            try {
                fw = new FileWriter("src/pl/wyniki.txt", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (textInputDialog.getDefaultValue() != "") {
                writeToFile(fw, textInputDialog.getContentText(), panelGry.score);
            } else {
                writeToFile(fw, "anonim", panelGry.getScore());
            }
    }

    private void showInputTextDialog(PanelGry panelGry) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Podaj nick");
        dialog.setHeaderText("Enter your nick:");
        dialog.setContentText("nick:");
        Optional<String> result = dialog.showAndWait();
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/pl/wyniki.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter finalFw = fw;
        result.ifPresent(name -> {
            this.label.setText(name);
            writeToFile(finalFw, name, panelGry.score);
        });
    }

    public static void writeToFile(FileWriter fw, String input, int wynik) {
            try {
                fw.write(input + " " + wynik + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public boolean setGameFinished(){

        return !isGameFinished;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
