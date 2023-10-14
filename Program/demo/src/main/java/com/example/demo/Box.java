package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Box extends StackPane {
    //Variables for Box.
    private Text text = new Text();
    private Board board;
    private PlayerBox red;
    private PlayerBox blue;

    //Constructors for Box
    public Box() {

        //Set up the rectangle size.
        Rectangle border = new Rectangle(50,50);

        //Set up the boarder of the box.
        border.setFill(null);
        border.setStroke(Color.BLACK);

        //Set up the font in the box
        text.setFont(Font.font(50));
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

    }

    //Another constructor for Box.
    public Box(Board board, PlayerBox redPlayer, PlayerBox bluePlayer, Label displayTurn) {
        this.board = board;
        red = redPlayer;
        blue = bluePlayer;

        //Set up the rectangle size so that it is proportional to how big the board is.
        Rectangle border = new Rectangle((400 / this.board.getBoardSize()),
                (400 / this.board.getBoardSize()));

        //Set up the boarder of the box.
        border.setFill(null);
        border.setStroke(Color.BLACK);

        //Set up the font in the box so that it is proportional to how big the board is.
        text.setFont(Font.font(400/this.board.getBoardSize()));
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

        //If someone clicks on the box
        setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                //If it is Blue Player's turn.
                if (this.board.getIsBlueTurn()) {

                    //If the box is not empty, don't do anything.
                    if (!text.getText().isEmpty()) {
                        return;
                    }

                    //If Blue Player has selected the S radio button, draw S.
                    if(blue.getS()) {
                        drawS();
                    }

                    //Else, draw an O.
                    else{
                        drawO();
                    }

                    //It's no longer Blue Player's turn, change that in board and in the GUI.
                    this.board.setIsBlueTurn(false);
                    displayTurn.setText("Red Player's Turn");
                }
            }

            if (event.getButton() == MouseButton.PRIMARY) {

                //If it is Red Player's turn.
                if (!this.board.getIsBlueTurn()) {

                    //If the box is not empty, don't do anything.
                    if (!text.getText().isEmpty()) {
                        return;
                    }

                    //If Blue Player has selected the S radio button, draw S.
                    if(red.getS()) {
                        drawS();
                    }

                    //Else, draw an O.
                    else {
                        drawO();
                    }

                    //It's no longer Red Player's turn, change that in board and in the GUI.
                    this.board.setIsBlueTurn(true);
                    displayTurn.setText("Blue Player's Turn");
                }
            }

        });

    }

    //If the box is empty, put a S in.
    public void drawS() {
        if(text.getText().isEmpty())
            text.setText("S"); }

    //If the box is empty, put an O in.
    public void drawO() {
        if(text.getText().isEmpty())
        text.setText("O");
    }

    //Returns the value of the text.
    public String getValue() {
        return text.getText();
    }

}
