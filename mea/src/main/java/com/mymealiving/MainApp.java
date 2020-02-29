package com.mymealiving;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(MouseEvent event, String fxml, String css, String title) throws Exception {
        Parent root = FXMLLoader.load(MainApp.class.getResource(fxml));
        Stage stage = new Stage();

        Scene scene = new Scene(root, 800, 480);
        scene.getStylesheets().add(MainApp.class.getResource(css).toExternalForm());

        stage.setTitle(title);
        stage.setScene(scene);

        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public static void main(String[] args) {
        launch(args);
    }

}