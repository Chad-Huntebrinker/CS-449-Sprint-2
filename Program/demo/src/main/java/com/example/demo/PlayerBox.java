package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PlayerBox {

    //Variables of PlayerBox.
    private RadioButton sButton;
    private RadioButton oButton;
    private Label playerLabel;

    //Constructor.
    public PlayerBox() {
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");
        playerLabel = new Label();
    }

    //Constructor.
    public PlayerBox(String playerName, HBox hbox) {
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");
        playerLabel = new Label(playerName);
        sButton.setSelected(true);

        ToggleGroup group = new ToggleGroup();
        sButton.setToggleGroup(group);
        oButton.setToggleGroup(group);

        hbox.getChildren().addAll(playerLabel, sButton, oButton);
        hbox.setSpacing(2);


    }

    //Return if the S button is selected.
    public boolean getS () {
        return sButton.isSelected();
    }

    //Return if the O button is selected.
    public boolean getO () {
        return oButton.isSelected();
    }
}