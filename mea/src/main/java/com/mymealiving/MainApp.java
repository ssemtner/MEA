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

        stage.setTitle("MEA");
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

    public static String toDisplayCase(String s) {

        final String ACTIONABLE_DELIMITERS = " '-/"; // these cause the character following

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}