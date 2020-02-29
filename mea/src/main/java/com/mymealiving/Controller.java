package com.mymealiving;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    @FXML
    private Label clock = new Label();
    @FXML
    private Pane main = new Pane();
    @FXML
    private Pane popup = new Pane();

    @FXML
    void appliances(MouseEvent event) throws Exception {
        System.out.println("change to appliances");
        MainApp.changeScene(event, "appliances.fxml", "style.css", "Appliances (MEA)");
    }

    @FXML
    void doors(MouseEvent event) {
        System.out.println("hello");
    }

    @FXML
    void kitchen(MouseEvent event) throws Exception {
        MainApp.changeScene(event, "kitchen.fxml", "style.css", "Kitchen (MEA)");
    }

    @FXML
    void news(MouseEvent event) {
        System.out.println("hello");
    }

    @FXML
    void initialize() {
        popup.setVisible(false);
        popup.setMouseTransparent(true);

        AtomicReference<LocalDateTime> today = new AtomicReference<>(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        clock.setText(formatter.format(today.get()));
        AtomicReference<String> date = new AtomicReference<>(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(today.get()));
        AtomicReference<String> time = new AtomicReference<>(formatter.format(today.get()));
        clock.setText(time + "\t" + date);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(15), actionEvent -> {
            today.set(LocalDateTime.now());
            date.set(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(today.get()));
            time.set(formatter.format(today.get()));
            clock.setText(time + "\t" + date);
            System.out.println(time + "\t" + date);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void emergency_show(MouseEvent event) {
        popup.setVisible(true);
        popup.setMouseTransparent(false);
    }

    @FXML
    public void emergency_hide(MouseEvent event) {
        popup.setVisible(false);
        popup.setMouseTransparent(true);
    }

    public void home(MouseEvent mouseEvent) throws Exception {
        MainApp.changeScene(mouseEvent, "home.fxml", "style.css", "MEA");
    }

    public void toggle_light(MouseEvent event) {
        toggle(event, "ON", "#F1935C", "OFF", "#B7472A");
    }

    public void toggle_blinds(MouseEvent event) {
        toggle(event, "OPEN", "#F1935C", "CLOSED", "#B7472A");
    }

    public void kitchen_toggle(MouseEvent event) {
    }

    @FXML
    private static void toggle(MouseEvent event, String text1, String color1, String text2, String color2) {
        StackPane pane = (StackPane) event.getSource();
        Rectangle rect = (Rectangle) pane.getChildren().get(0);
        Label text = (Label) pane.getChildren().get(1);

        if (text.getText().equals(text1)) {
            text.setText(text2);
            rect.setFill(Paint.valueOf(color2));
        }

        else if (text.getText().equals(text2)) {
            text.setText(text1);
            rect.setFill(Paint.valueOf(color1));
        }
    }
}