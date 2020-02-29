package com.mymealiving;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    @FXML
    private Label clock = new Label();

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
    void kitchen(MouseEvent event) {
        System.out.println("hello");
    }

    @FXML
    void news(MouseEvent event) {
        System.out.println("hello");
    }

    @FXML
    void initialize() {
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

    public void emergency(MouseEvent mouseEvent) {
        System.out.println("this would open popup");
    }

    public void home(MouseEvent mouseEvent) throws Exception {
        MainApp.changeScene(mouseEvent, "home.fxml", "style.css", "MEA");
    }

    public void toggle_light(MouseEvent mouseEvent) {
    }

    public void toggle_blinds(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getSource());
    }
}