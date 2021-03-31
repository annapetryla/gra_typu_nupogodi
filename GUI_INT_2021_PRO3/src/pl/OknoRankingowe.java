package pl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OknoRankingowe extends StackPane {
    public OknoRankingowe(Stage primaryStage) throws IOException {
        Pane pane = new Pane();
        ArrayList<User> daneGraczy = new ArrayList<>();
        readFile("wyniki.txt",daneGraczy);
        Collections.sort(daneGraczy);
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList(
                daneGraczy.toArray().toString());
        list.setItems(items);
        Parent content = pane;
        Scene scene = new Scene(content);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void readFile(String path,ArrayList<User> listaUsers) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String input =  reader.readLine();
        while(input != null){
            String imie = input.split(" ")[0];
            int wynik = Integer.parseInt(input.split(" ")[1]);
            listaUsers.add(new User(imie,wynik));
            input = reader.readLine();
        }
        reader.close();
    }

}

