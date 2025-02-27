package com.mymealiving;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {
    private static Robot robot = new Robot();
    @FXML
    private Pane home, kitchen, appliances, doors_pane, options, popup, danger;
    @FXML
    private TilePane lights, blinds, kitchen_appliances, doors;
    @FXML
    private Label clock, font_label_a, font_label_b, font_label_c;
    @FXML
    private StackPane emergency_button;
    @FXML
    private Rectangle home_button;
    @FXML
    private AnchorPane font_menu;

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
        robot.mouseMove(0, 0);
    }

    static void switchPane(Node on, Node off1, Node off2, Node off3, Node off4, Node home_button, Node emergency_button) {
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

        if (on.getId().equals("home")) {
            emergency_button.setVisible(false);
            emergency_button.setMouseTransparent(true);
            home_button.setVisible(false);
            home_button.setMouseTransparent(true);
        } else {
            emergency_button.setVisible(true);
            emergency_button.setMouseTransparent(false);
            home_button.setVisible(true);
            home_button.setMouseTransparent(false);
        }
        robot.mouseMove(0, 0);
    }

    @FXML
    void appliances() {
        switchPane(appliances, home, doors_pane, kitchen, options, home_button, emergency_button);
    }

    @FXML
    void doors() {
        switchPane(doors_pane, appliances, home, kitchen, options, home_button, emergency_button);
    }

    @FXML
    void kitchen() {
        switchPane(kitchen, appliances, doors_pane, home, options, home_button, emergency_button);
    }

    @FXML
    void options() {
        switchPane(options, appliances, doors_pane, kitchen, home, home_button, emergency_button);
    }

    @FXML
    void home() {
        switchPane(home, appliances, doors_pane, kitchen, options, home_button, emergency_button);
    }

    @FXML
    void initialize() {
        //Show home screen
        robot.mouseMove(0, 0);
        home();
        emergency_hide();
        danger_hide();

        //Fill in blinds
        blinds.getChildren().add(DEFAULTS.BEDROOM_B.getVisual());
        blinds.getChildren().add(DEFAULTS.KITCHEN_B.getVisual());
        blinds.getChildren().add(DEFAULTS.DINING_ROOM_B.getVisual());
        blinds.setMinHeight((blinds.getChildren().size()) * 75);
        blinds.setMaxHeight((blinds.getChildren().size()) * 75);

        //Fill in kitchen appliances
        kitchen_appliances.getChildren().add(DEFAULTS.MICROWAVE.getVisual());
        kitchen_appliances.getChildren().add(DEFAULTS.STOVE.getVisual());
        kitchen_appliances.setMinHeight((kitchen_appliances.getChildren().size()) * 70);
        kitchen_appliances.setMaxHeight((kitchen_appliances.getChildren().size()) * 70);

        //Fill in lights
        lights.getChildren().add(DEFAULTS.LIVING_ROOM_L.getVisual());
        lights.getChildren().add(DEFAULTS.KITCHEN_L.getVisual());
        lights.getChildren().add(DEFAULTS.DINING_ROOM_L.getVisual());
        lights.setMinHeight((lights.getChildren().size()) * 75);
        lights.setMaxHeight((lights.getChildren().size()) * 75);

        //Fill in doors
        doors.getChildren().add(DEFAULTS.FRONT_DOOR.getVisual());
        doors.getChildren().add(DEFAULTS.BACK_DOOR.getVisual());
        doors.setMinHeight(doors.getChildren().size() * 70);
        doors.setMaxHeight(doors.getChildren().size() * 70);

        font_menu.setVisible(false);
        font_menu.setMouseTransparent(true);

        //Start clock
        AtomicReference<LocalDateTime> today = new AtomicReference<>(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        clock.setText(formatter.format(today.get()));
        AtomicReference<String> date = new AtomicReference<>(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(today.get()));
        AtomicReference<String> time = new AtomicReference<>(formatter.format(today.get()));
        clock.setText(time + "\t" + date);
        Timeline clock_timeline = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> {
            today.set(LocalDateTime.now());
            date.set(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(today.get()));
            time.set(formatter.format(today.get()));
            clock.setText(time + "\t" + date);
        }));
        clock_timeline.setCycleCount(Animation.INDEFINITE);
        clock_timeline.play();
    }

    @FXML
    public void emergency_show(MouseEvent event) {
        StackPane cancel = (StackPane) popup.getChildren().get(1);
        if (((StackPane) event.getSource()).getParent().getId().equals("home")) {
            cancel.setLayoutY(520);
        } else {
            cancel.setLayoutY(450);
        }

        popup.setVisible(true);
        popup.setMouseTransparent(false);
        robot.mouseMove(0, 0);
    }

    @FXML
    public void emergency_hide() {
        popup.setVisible(false);
        robot.mouseMove(0, 0);
        popup.setMouseTransparent(true);
    }

    public void danger_show() {
        danger.setVisible(true);
        danger.setMouseTransparent(false);
        robot.mouseMove(0, 0);
    }

    public void danger_hide() {
        danger.setVisible(false);
        robot.mouseMove(0, 0);
        danger.setMouseTransparent(true);
    }

    public void toggle_font_menu() {
        if (font_menu.isVisible()) {
            System.out.println();
            font_menu.setVisible(false);
            font_menu.setMouseTransparent(true);
        } else {
            font_menu.setVisible(true);
            font_menu.setMouseTransparent(false);
        }

        robot.mouseMove(0, 0);
    }

    public void font_select(MouseEvent event) {
        Label source;
        String lastSize;
        if (event.getSource().toString().contains("label_b")) {
            source = font_label_b;
        } else {
            source = font_label_c;
        }
        lastSize = font_label_a.getText().toLowerCase();
        font_label_a.setText(source.getText());
        System.out.println(source.getText());
        switch (source.getText()) {
            case "Small":
                font_label_b.setText("Medium");
                font_label_c.setText("Large");
                break;
            case "Large":
                font_label_b.setText("Small");
                font_label_c.setText("Medium");
                break;
            default:
                font_label_b.setText("Small");
                font_label_c.setText("Large");
        }
        robot.mouseMove(0, 0);

        toggle_font_menu();

        String fontSize = font_label_a.getText().toLowerCase();

        System.out.println(getClass().getResource(lastSize + "Font.css").toExternalForm());
        System.out.println(getClass().getResource(fontSize + "Font.css").toExternalForm());

        MainApp.scene.getStylesheets().remove(getClass().getResource(lastSize + "Font.css").toExternalForm());
        MainApp.scene.getStylesheets().add(getClass().getResource(fontSize + "Font.css").toExternalForm());
    }

}
