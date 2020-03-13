package com.mymealiving;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    @FXML
    public Pane home;
    @FXML
    public Pane kitchen;
    @FXML
    public Pane appliances;
    @FXML
    public Pane doors_pane;
    @FXML
    public Pane news;
    @FXML
    public Pane main;
    @FXML
    public TilePane lights = new TilePane();
    @FXML
    public TilePane blinds = new TilePane();
    @FXML
    public TilePane kitchen_appliances = new TilePane();
    @FXML
    public TilePane doors = new TilePane();
    @FXML
    private Label clock = new Label();
    @FXML
    private Pane popup = new Pane();

    @FXML
    static void toggle(MouseEvent event, String text1, String color1, String text2, String color2) {
        StackPane pane = (StackPane) event.getSource();
        Rectangle rect = (Rectangle) pane.getChildren().get(0);
        Label text = (Label) pane.getChildren().get(1);

        if (text.getText().equals(text1)) {
            text.setText(text2);
            rect.setFill(Paint.valueOf(color2));
        } else if (text.getText().equals(text2)) {
            text.setText(text1);
            rect.setFill(Paint.valueOf(color1));
        }
    }

    static void switchPane(Pane on, Pane off1, Pane off2, Pane off3, Pane off4) {
        on.setVisible(true);
        on.setMouseTransparent(false);
        off1.setVisible(false);
        off1.setMouseTransparent(true);
        off2.setVisible(false);
        off2.setMouseTransparent(true);
        off3.setVisible(false);
        off3.setMouseTransparent(true);
        off4.setVisible(false);
        off4.setMouseTransparent(true);
    }

    @FXML
    void appliances() {
        switchPane(appliances, home, doors_pane, kitchen, news);
    }

    @FXML
    void doors() {
        switchPane(doors_pane, appliances, home, kitchen, news);
    }

    @FXML
    void kitchen() {
        switchPane(kitchen, appliances, doors_pane, home, news);
    }

    @FXML
    void news() {
        switchPane(news, appliances, doors_pane, kitchen, home);
    }

    public void home() {
        switchPane(home, appliances, doors_pane, kitchen, news);
    }

    @FXML
    void initialize() {
        switchPane(home, appliances, doors_pane, kitchen, news);

        blinds.getChildren().add(DEFAULTS.BEDROOM_B.getVisual());
        blinds.getChildren().add(DEFAULTS.KITCHEN_B.getVisual());
        blinds.getChildren().add(DEFAULTS.DINING_ROOM_B.getVisual());
        blinds.setMinHeight((blinds.getChildren().size()) * 75);
        blinds.setMaxHeight((blinds.getChildren().size()) * 75);

        kitchen_appliances.getChildren().add(DEFAULTS.MICROWAVE.getVisual());
        kitchen_appliances.getChildren().add(DEFAULTS.STOVE.getVisual());
        kitchen_appliances.setMinHeight((kitchen_appliances.getChildren().size()) * 70);
        kitchen_appliances.setMaxHeight((kitchen_appliances.getChildren().size()) * 70);

        lights.getChildren().add(DEFAULTS.LIVING_ROOM_L.getVisual());
        lights.getChildren().add(DEFAULTS.KITCHEN_L.getVisual());
        lights.getChildren().add(DEFAULTS.DINING_ROOM_L.getVisual());
        lights.setMinHeight((lights.getChildren().size()) * 75);
        lights.setMaxHeight((lights.getChildren().size()) * 75);

        doors.getChildren().add(DEFAULTS.FRONT_DOOR.getVisual());
        doors.getChildren().add(DEFAULTS.BACK_DOOR.getVisual());
        doors.setMinHeight(doors.getChildren().size() * 70);
        doors.setMaxHeight(doors.getChildren().size() * 70);

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
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void emergency_show() {
        popup.setVisible(true);
        popup.setMouseTransparent(false);
    }

    @FXML
    public void emergency_hide() {
        popup.setVisible(false);
        popup.setMouseTransparent(true);
    }
}