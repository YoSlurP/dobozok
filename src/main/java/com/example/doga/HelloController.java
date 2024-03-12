package com.example.doga;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Label lbopen;
    @FXML private Pane pnJatek;
    @FXML private Label lbclose;
    @FXML private ImageView nyil;

    private Label[][] tomb= new Label[10][15];
    private AnimationTimer timer =null;

    public void initialize(){
        for(int s=0;s<10;s++){
            for(int o=0;o<15;o++){
                tomb[s][o]= new Label();
                tomb[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
                tomb[s][o].setTranslateX(10+o*64);
                tomb[s][o].setTranslateY(10+s*64);
                int ss=s,oo=o;
                tomb[s][o].setOnMouseEntered(e -> tomb[ss][oo].setStyle("-fx-background-color: lightgreen;"));
                tomb[s][o].setOnMouseExited(e -> tomb[ss][oo].setStyle("-fx-background-color: white;"));
                pnJatek.getChildren().add(tomb[s][o]);
            }
        }
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                nyil.setRotate(nyil.getRotate()+6);
            }
        };
        timer.start();
    }
}