package com.example.doga;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Label lbopen;
    @FXML private Pane pnJatek;
    @FXML private Label lbclose;

    private ImageView[][] tomb= new ImageView[10][15];

    public void initialize(){
        for(int s=0;s<10;s++){
            for(int o=0;o<15;o++){
                tomb[s][o]
            }
        }
    }
}