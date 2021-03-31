package pl;

import javafx.beans.binding.Bindings;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

public class PanelGry extends Pane {

    ArrayList<Jajko> listaJajek = new ArrayList<>();
    ArrayList<Jajko> listaJajekRightSide = new ArrayList<>();
    Koszyk koszyk = new Koszyk(300, 500, 50, 50);
    int stanJajka = 0;
    int stanJajkaRight = 0;
    int lifeCounter = 4;
    public Text liczbaZlapanych = new Text();
    public int score = 0;
    boolean isFinished = false;
    int i = 0;
    int j = 0;
    int wysokoscPanelu;
    int szerokoscPanelu;

    public PanelGry(int szerokoscPanelu, int wysokoscPanelu) {
        this.szerokoscPanelu = szerokoscPanelu;
        this.wysokoscPanelu = wysokoscPanelu;
        setMinSize(szerokoscPanelu, wysokoscPanelu);
        getChildren().add(koszyk);
        dodajJajka();
    }

    public void dodajJajka() {
       for(int i =0 ; i < 100; i++) {
           if(i%2 == 0) {
               Jajko jajko = new Jajko(90, 100);
               jajko.setVisible(false);
               listaJajek.add(jajko);
               getChildren().add(jajko);
               Jajko jajkoR = new Jajko(Main.dimX-15, 0);
               jajkoR.setVisible(false);
               listaJajekRightSide.add(jajkoR);
               getChildren().add(jajkoR);
           }
           else {
               Jajko jajko = new Jajko(90, 200);
               jajko.setVisible(false);
               listaJajek.add(jajko);
               getChildren().add(jajko);
               Jajko jajkoR = new Jajko(Main.dimX-15, 100);
               jajkoR.setVisible(false);
               listaJajekRightSide.add(jajkoR);
               getChildren().add(jajkoR);

           }
       }
    }

    public void ruszJajka() {
        stanJajka = 1;
        switch (stanJajka) {
            case 1:
                if(i < listaJajek.size()) {
                    listaJajek.get(i).setVisible(true);
                    listaJajek.get(i).ruszJajko();
                    if (czyWpadlo(listaJajek.get(i))) {
                        listaJajek.get(i).setVisible(false);
                        i++;
                        stanJajka = 2;
                    }
                    else if(listaJajek.get(i).getPosCenterY() > this.wysokoscPanelu) {
                        lifeCounter--;
                        i++;
                        stanJajka = 2;
                    }
                }
                else {
                    break;
                }
            case 2:
                if(i < listaJajek.size()) {
                    listaJajek.get(i).setVisible(true);
                    listaJajek.get(i).ruszJajko();
                    if (czyWpadlo(listaJajek.get(i))) {
                        listaJajek.get(i).setVisible(false);
                        i++;
                        stanJajka = 1;
                    }
                    else if(listaJajek.get(i).getPosCenterY() > this.wysokoscPanelu) {
                        lifeCounter--;
                        i++;
                        stanJajka = 1;
                    }
                }
                else {
                    break;
                }
        }
    }
    public void ruszJajkaReverse() {
        stanJajkaRight = 1;
        switch (stanJajkaRight) {
            case 1:
                if(i < listaJajekRightSide.size()) {
                    listaJajekRightSide.get(j).setVisible(true);
                    listaJajekRightSide.get(j).ruszJajkoReverse();
                    if (czyWpadlo(listaJajekRightSide.get(j))) {
                        listaJajekRightSide.get(j).setVisible(false);
                        j++;
                        stanJajkaRight = 2;
                    }
                    else if(listaJajekRightSide.get(j).getPosCenterY() > this.wysokoscPanelu) {
                        lifeCounter--;
                        j++;
                        stanJajka = 1;
                    }
                }
                else {
                    break;
                }
            case 2:
                if(i < listaJajekRightSide.size()) {
                    listaJajekRightSide.get(j).setVisible(true);
                    listaJajekRightSide.get(j).ruszJajkoReverse();
                    if (czyWpadlo(listaJajekRightSide.get(j))) {
                        listaJajekRightSide.get(j).setVisible(false);
                        j++;
                        stanJajkaRight = 1;
                    }
                    else if(listaJajekRightSide.get(j).getPosCenterY() > this.wysokoscPanelu) {
                        lifeCounter--;
                        j++;
                        stanJajka = 1;
                    }
                }
                else {
                    break;
                }
        }
    }
    public boolean czyWpadlo(Jajko jajko) {
        if(jajko==null) {
            return false;
        }
        if( koszyk.getxPos() < jajko.getPosCenterX() && (koszyk.getxPos() + 50) > jajko.getPosCenterX() &&
                koszyk.getyPos() < jajko.getPosCenterY() && (koszyk.getyPos() + 50) > jajko.getPosCenterY() ){
            jajko.isVisible = false;
            setScore(20+score);
            liczbaZlapanych.textProperty().bind(Bindings.createStringBinding(() -> " Wynik: " + getScore() ));
            return true;
        }
        if(jajko.getPosCenterY() == wysokoscPanelu && jajko.isVisible==true) {
            lifeCounter--;
            System.out.println(lifeCounter);
            if(lifeCounter < 0){
                isFinished = true;
            }
        }
        return false;
    }
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
