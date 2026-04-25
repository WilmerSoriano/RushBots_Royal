package com.rushbot;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {        
        scene = new Scene(loadFXML("MenuScene"), 700, 700);
        scene.getStylesheets().add(App.class.getResource("css/application.css").toExternalForm());
        stage.setScene(scene);
        
        stage.setResizable(false); // Locking the windows so user doesn't change size         
        stage.setMinWidth(700);
        stage.setMaxWidth(700);
        stage.setMinHeight(700);
        stage.setMaxHeight(700);
        
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")); // Looks for fxml file
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.out.println("***Opening***");
        launch();
        System.out.println("***Closing***");
    }
}