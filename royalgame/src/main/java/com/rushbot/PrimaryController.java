package com.rushbot;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ToggleButton;

import java.awt.Desktop;
import java.net.URI;

public class PrimaryController {
   
    @FXML
    private Pane coinLayer; // Loads the coin layer from fxml file
    
    @FXML
    private Hyperlink web_github;
    
    @FXML
    private Hyperlink web_youtube;
    
    @FXML
    private ToggleButton music_toggle;
    
    @FXML
    private ToggleButton sound_toggle;
    
    @FXML
    private ToggleButton backup_toggle;
    
    private AudioManager dj;

    private CoinShower coins;
    
    @FXML
    public void initialize() {
       dj = new AudioManager();
        try{
           coins = new CoinShower(coinLayer); // setting the coinlayer pane as background. NOT menuLayer
           coins.start();
        }
        catch(NullPointerException e){
           System.out.println("Coin image not found!");
        }
    }
    
    // The ActionEvent is communicated via fxml file with onAction call
    public void startGame(ActionEvent act){
       dj.clickSFX();
       System.out.println("Starting Game!");
    }
    
    public void loadGame(ActionEvent act){
       dj.clickSFX();
       System.out.println("Loading Game!");
    }
    
    public void showCredit(ActionEvent act)throws IOException{
       dj.clickSFX();
       System.out.println("Showing credits");
       //coins.stop not needed since catch handles error with no event (e.g Start and Stop button doesn't exist if class is Null)
       App.setRoot("CreditScene");
    }
    public void openLink(ActionEvent act)throws IOException{
       dj.clickSFX();
       System.out.print("Opening Link for: ");
       String link = "";
       
       if(act.getSource() == web_youtube){
          link =  "https://www.youtube.com/@BroCodez";
       }
       else{
          link = "https://github.com/WilmerSoriano/RushBots_Royal.git";
       }
       System.out.println(link);
       
       try{
          Desktop desktop = Desktop.getDesktop();
          if (desktop.isSupported(Desktop.Action.BROWSE)){
             desktop.browse(java.net.URI.create(link));
          }
          else{
             System.out.print("Gdk-WARNING: Your Environment does not support GUI to Link");
          }
       }
       catch(Exception e){
          System.out.println("WARNING: Your Environment does not support GUI to Link");
       }
    }
    
    public void showSettings(ActionEvent act)throws IOException{
       dj.clickSFX();
       System.out.println("Showing settings");
       App.setRoot("SettingScene");
    }
    public void audioToggle(ActionEvent act)throws IOException{
       dj.clickSFX();
       
       // This Section is handling the button to display On and Off for toggle button
       ToggleButton toggle = (ToggleButton) act.getSource();
       if (toggle.isSelected()) {
           toggle.setText("On");
       } else {
           toggle.setText("Off");
       }
       
       // This Section actually handles the settings for Audio.
       if(act.getSource() == music_toggle){
          System.out.println("Music has been toggle");
          dj.controlMusic(music_toggle);
       }
       else{
          System.out.println("Sound effect has been toggle");
          dj.controlSFX(sound_toggle);
       }
    }
    
    public void backupGame(ActionEvent act)throws IOException{
       dj.clickSFX();
       System.out.println("Backing up game has been swithced");
       if(backup_toggle.isSelected()){
          backup_toggle.setText("On");
       }
       else{
          backup_toggle.setText("Off");
       }
    }
    
    public void onReturn(ActionEvent act)throws IOException{
       dj.clickSFX();
       System.out.println("Main Menu");
       App.setRoot("MenuScene");
    }
}
