package com.rushbot;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {
   
    @FXML
    private Pane coinLayer; // Loads the coin layer from fxml file

    private CoinShower coins;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    public void initialize() {
        coins = new CoinShower(coinLayer); // setting the coinlayer pane as background. NOT menuLayer
        System.out.println("=== Spawning coin ===");
        try{
           coins.start();
           coins.stop();
        }
        catch(NullPointerException e){
           System.err.println("Coin image not found!");
        }
    }
    
    // The ActionEvent is communicated via fxml file with onAction call
    public void startGame(ActionEvent e){
       System.out.println("Starting Game!");
    }
    public void loadGame(ActionEvent e){
       System.out.println("Loading Game!");
    }
    public void showCredit(ActionEvent e)throws IOException{
       System.out.println("Showing credits");
       coins.stop();
       
       FXMLLoader fxl = new FXMLLoader(App.class.getResource("CreditScene.fxml"));
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       scene = new Scene(fxl.load());
       scene.getStylesheets().add(App.class.getResource("css/application.css").toExternalForm());
       stage.setScene(scene);
        
       stage.setResizable(false);      
       stage.setMinWidth(700);
       stage.setMaxWidth(700);
       stage.setMinHeight(700);
       stage.setMaxHeight(700);
        
       stage.show();
    }
    public void showSettings(ActionEvent e){
       System.out.println("Showing settings");
    }
    
    public void openYoutube(ActionEvent e){
       System.out.println("Opening YouTube!");
    }

    public void openGithub(ActionEvent e){
       System.out.println("opening github");
    }
}
