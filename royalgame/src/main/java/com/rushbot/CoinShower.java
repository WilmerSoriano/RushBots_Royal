package com.rushbot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CoinShower {

    private Pane layer;
    private Timeline spawner;

    public CoinShower(Pane layer)throws NullPointerException{
        if(layer == null){
            throw new IllegalArgumentException("Coin layer cannot be null");
        }
        
        this.layer = layer;

        spawner = new Timeline(new KeyFrame(Duration.seconds(0.3), e -> spawnCoin()));//Every 0.3 sec spawn a coin.
        spawner.setCycleCount(Timeline.INDEFINITE); // Always spawns coins
    }

    public void start()throws NullPointerException{
        spawner.play();
    }

    public void stop() {
        spawner.stop();
    }

    private void spawnCoin()throws NullPointerException{ // The NullPointer is only for coins image

       Image coinImage = new Image(getClass().getResource("images/drop.png").toExternalForm());
       ImageView coin = new ImageView(coinImage);

       coin.setFitWidth(32); // maintains the size of the coin
       coin.setPreserveRatio(true);

       coin.setLayoutX(Math.random() * layer.getWidth()); // randomly drops goins around the screen based on width of screen
       coin.setLayoutY(-15);

       layer.getChildren().add(coin);// Adds the coin to screen specefically to pane layer

       TranslateTransition fall = new TranslateTransition(Duration.seconds(3), coin); // Falling animation for 3 sec
       fall.setByY(layer.getHeight() + 20); // The coin fall pass the screen (+20) 

       fall.setOnFinished(e -> layer.getChildren().remove(coin));// Remove coin after all the above, prevent memory issue.

       fall.play();
    }
}