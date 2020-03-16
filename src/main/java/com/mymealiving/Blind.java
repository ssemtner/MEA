package com.mymealiving;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Blind {
    String name;
    String action_modifier;

    public Blind(String text) {
        name = text;
    }

    public VBox getVisual() {
        VBox vbox = new VBox();

        HBox hbox = new HBox();
        hbox.setMaxWidth(400);
        hbox.setMinWidth(400);
        hbox.setMaxHeight(60);
        hbox.setMinHeight(60);

        Label text = new Label();
        text.setText(MainApp.toDisplayCase(name));
        text.setMaxWidth(250);
        text.setMinWidth(250);
        text.setMaxHeight(60);
        text.setMinHeight(60);
        text.setPadding(new Insets(0, 0, 0, 30));
        text.setFont(Font.font("System", FontWeight.BOLD, 18));

        StackPane stackpane = new StackPane();
        stackpane.setPadding(new Insets(10, 0, 10, 20));
        stackpane.setOnMouseEntered(event -> Controller.toggle(event, "OPEN", "#F1935C", "CLOSED", "#B7472A"));

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(100);
        rectangle.setHeight(40);
        rectangle.setFill(Color.web("f1935c"));
        rectangle.setArcWidth(40);
        rectangle.setArcHeight(50);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(0.5);

        Label button_label = new Label();
        button_label.setText("OPEN");
        button_label.setFont(Font.font("System", FontWeight.BOLD, 18));

        Line line = new Line();
        line.setStartX(-125);
        line.setStartY(0);
        line.setEndX(175);
        line.setEndY(0);
        line.setTranslateX(25);
        line.setStroke(Color.web("aeafb0"));

        stackpane.getChildren().add(rectangle);
        stackpane.getChildren().add(button_label);

        hbox.getChildren().add(text);
        hbox.getChildren().add(stackpane);

        vbox.getChildren().add(hbox);
        vbox.getChildren().add(line);

        return vbox;
    }

    public void performAction(String change_to) {
        if (change_to.toLowerCase().equals("off"))
            System.out.println("OFF This will perform whatever action, possibly with parameters, changing to off, with modifier " + action_modifier);
        if (change_to.toLowerCase().equals("on"))
            System.out.println("ON This will perform whatever action, possibly with parameters, changing to on, with modifier " + action_modifier);
    }

}
