package com.mymealiving;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static FXMLLoader loader;
    public static Scene scene;

    public static String toDisplayCase(String s) {
        final String ACTIONABLE_DELIMITERS = " '-/";

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (ACTIONABLE_DELIMITERS.indexOf(c) >= 0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Server server = new Server(5050);
            server.start();
            server = null;
        });
        thread.start();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        loader = new FXMLLoader(getClass().getResource("index.fxml"));
//        Options.putFonts(loader, 'm');

        Parent root = loader.load();
        scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("mediumFont.css").toExternalForm());

        stage.setTitle("MEA");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
