package com.mymealiving;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import static com.mymealiving.Controller.*;

public class Light {
    String name;
    String action_modifier;

    public Light(String text) {
        name = text;
    }

    public VBox getVisual() {
        VBox vbox = new VBox();

        HBox hbox = new HBox();
        hbox.setMaxWidth(300);
        hbox.setMinWidth(300);
        hbox.setMaxHeight(60);
        hbox.setMinHeight(60);

        Label label = new Label();
        label.setText(MainApp.toDisplayCase(name));
        label.setMaxWidth(150);
        label.setMinWidth(150);
        label.setMaxHeight(60);
        label.setMinHeight(60);
        label.setPadding(new Insets(0, 0, 0, 30));
        label.setFont(new Font(18));

        StackPane stackpane = new StackPane();
        stackpane.setPadding(new Insets(10, 0, 10, 20));
        stackpane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Controller.toggle_light(event);
            }
        });
        stackpane.setMaxWidth(150);
        stackpane.setMinWidth(150);
        stackpane.setMaxHeight(60);
        stackpane.setMinHeight(60);


        return vbox;
    }

    public void performAction(String change_to) {
        if (change_to.toLowerCase() == "off")
            System.out.println("OFF This will perform whatever action, possibly with parameters, changing to off, with modifier " + action_modifier);
        if (change_to.toLowerCase() == "on")
            System.out.println("ON This will perform whatever action, possibly with parameters, changing to on, with modifier " + action_modifier);
    }

}
