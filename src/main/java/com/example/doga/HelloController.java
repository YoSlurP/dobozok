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
    private String [][] chtomb= new String[10][15];
    private long now;
    int ures =0;
    int doboz=0;

    public void initialize(){
        for(int s=0;s<10;s++){
            for(int o=0;o<15;o++){
                tomb[s][o]= new Label();
                chtomb[s][o]="null";
                tomb[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("null.png"))));
                tomb[s][o].setTranslateX(10+o*64);
                tomb[s][o].setTranslateY(10+s*64);
                int ss=s,oo=o;
                tomb[s][o].setOnMouseEntered(e -> tomb[ss][oo].setStyle("-fx-background-color: lightgreen;"));
                tomb[s][o].setOnMouseExited(e -> tomb[ss][oo].setStyle("-fx-background-color: white;"));
                tomb[s][o].setOnMouseClicked(e -> katt(ss,oo));
                pnJatek.getChildren().add(tomb[s][o]);
            }
        }
        doboz();
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(now>l){
                    l=now+50000000;
                    nyil.setRotate(nyil.getRotate()+1);
                    remove();
                }

            }
        };
        timer.start();
    }
    public void remove(){
        for(int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                if(chtomb[i][j].equals("boxopen")){
                    tomb[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("null.png"))));
                    chtomb[i][j]="null";
                }
            }
        }
    }
    public void katt(int s,int o){
        if(chtomb[s][o].equals("box")&&chtomb[s-1][o].equals("null")){
            tomb[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("boxopen.png"))));
            chtomb[s][o]="boxopen";
            ures++;
            doboz--;
        }
        if(chtomb[s][o].equals("null")){
            if(chtomb[s+1][o].equals("box")){
                tomb[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
                chtomb[s][o]="box";
                doboz++;
            }

        }
        lbclose.setText(doboz+"");
        lbopen.setText(ures+"");
    }
    public void doboz(){

        for(int i=2;i<7;i++){
            for(int j=0;j<10;j++){
                tomb[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
                chtomb[i][j]="box";
                doboz++;

            }
        }
        lbclose.setText(doboz+"");
    }
}