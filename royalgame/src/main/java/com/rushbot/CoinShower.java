package com.rushbot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.InputStream;

public class CoinShower {

    private Pane layer;
    private Timeline spawner;

    public CoinShower(Pane layer) {
        this.layer = layer;

        spawner = new Timeline(new KeyFrame(Duration.seconds(0.3), e -> spawnCoin()));
        spawner.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        spawner.play();
    }

    public void stop() {
        spawner.stop();
    }

    private void spawnCoin() throws NullPointerException {

       Image coinImage = new Image(getClass().getResource("images/drop.png").toExternalForm());
       ImageView coin = new ImageView(coinImage);

       coin.setFitWidth(32); // These both are to change the size of the coin
       coin.setPreserveRatio(true);

       coin.setLayoutX(Math.random() * layer.getWidth());
       coin.setLayoutY(-10);

       layer.getChildren().add(coin);

       TranslateTransition fall = new TranslateTransition(Duration.seconds(3), coin);
       fall.setByY(layer.getHeight() + 40);

       fall.setOnFinished(e -> layer.getChildren().remove(coin));

       fall.play();
    }
}