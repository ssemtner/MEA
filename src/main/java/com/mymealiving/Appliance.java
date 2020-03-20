package com.mymealiving;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Appliance {
    String name;
    String action_modifier;

    public Appliance(String text) {
        name = text;
    }

    public StackPane getVisual() {
        StackPane root = new StackPane();
        root.setMaxWidth(500);
        root.setMinWidth(500);
        root.setMaxHeight(60);
        root.setMinHeight(60);

        DropShadow shadow = new DropShadow(BlurType.THREE_PASS_BOX, Color.web("535353"), 10, 0, 0, 0);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(60);
        rect.setArcWidth(40);
        rect.setArcHeight(40);
        rect.setFill(Color.web("f1f3f4"));
        rect.setStrokeWidth(0);
        rect.setEffect(shadow);

        HBox hbox = new HBox();

        Label label = new Label();
        label.setText(MainApp.toDisplayCase(name));
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(Font.font("System", FontWeight.BOLD, 24));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setMaxWidth(300);
        label.setMinWidth(300);
        label.setMaxHeight(60);
        label.setMinHeight(60);

        StackPane stackpane = new StackPane();
        stackpane.setOnMouseEntered(event -> System.out.println("Stuff"));
        stackpane.setPadding(new Insets(0, 0, 0, 80));
        stackpane.setMaxWidth(130);
        stackpane.setMinWidth(130);
        stackpane.setMaxHeight(60);
        stackpane.setMinHeight(60);

        Rectangle btn = new Rectangle();
        btn.setWidth(150);
        btn.setHeight(50);
        btn.setArcWidth(40);
        btn.setArcHeight(40);
        btn.setFill(Color.web("b7472a"));
        btn.setStrokeWidth(0);
        btn.setEffect(shadow);

        Label btn_txt = new Label();
        btn_txt.setText("DANGER");
        btn_txt.setFont(Font.font("System", FontWeight.BOLD, 24));
        btn_txt.setAlignment(Pos.CENTER);
        btn_txt.setMaxWidth(120);
        btn_txt.setMinWidth(120);
        btn_txt.setMaxHeight(40);
        btn_txt.setMinHeight(40);

        stackpane.getChildren().add(btn);
        stackpane.getChildren().add(btn_txt);

        hbox.getChildren().add(label);
        hbox.getChildren().add(stackpane);

        root.getChildren().add(rect);
        root.getChildren().add(hbox);

        return root;
    }

    public void performAction(String change_to) {
        if (change_to.toLowerCase().equals("off"))
            System.out.println("OFF This will perform whatever action, possibly with parameters, changing to off, with modifier " + action_modifier);
        if (change_to.toLowerCase().equals("on"))
            System.out.println("ON This will perform whatever action, possibly with parameters, changing to on, with modifier " + action_modifier);
    }

}
