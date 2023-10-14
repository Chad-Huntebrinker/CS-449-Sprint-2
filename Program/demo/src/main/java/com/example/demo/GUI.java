package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class GUI {

    //Variables for the GUI.
    public Board board;
    private Pane square = new Pane();
    private Pane gameBoard = new Pane();
    private HBox rightPlayer;
    private HBox leftPlayer;
    private PlayerBox redPlayer;
    private PlayerBox bluePlayer;
    private GameMode menu;
    private HBox menuHB;
    private HBox textFieldHB;
    private Label displayTurn;
    private TextField textField;
    private Label label;
    private Button btn;

    //Constructor for the GUI.
    public GUI(Board board) {
        this.board = board;
        this.board.initBoard();
        square = new Pane();
        gameBoard = new Pane();
        rightPlayer = new HBox();
        leftPlayer = new HBox();
        menuHB = new HBox();
        redPlayer = new PlayerBox("Red Player", rightPlayer);
        bluePlayer = new PlayerBox("Blue Player", leftPlayer);
        square.setPrefSize(1000, 600);
        gameBoard.setPrefSize(400, 400);
        menu = new GameMode(menuHB, board);
        textFieldHB = new HBox();
        displayTurn = new Label();
        label = new Label();
        textField = new TextField();
        btn = new Button();
    }

    //Getter for square.
    public Pane getSquare() {return square;}

    //This function makes the GUI.
    public void makeBoard() {

        //Create the Pane that will contain the board.
        gameBoard = new Pane();
        gameBoard.setPrefSize(400, 400);

        //Create the board itself based on the boardSize.
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Box box = new Box(board, redPlayer, bluePlayer, displayTurn);
                box.setLayoutX(j * (400 / board.getBoardSize()) + 250);
                box.setLayoutY(i * (400 / board.getBoardSize()) + 100);

                //Add the box to both the GUI and the board.
                gameBoard.getChildren().add(box);
                board.addBox(box, i, j);

            }
        }

        //Right player contains the Red Player's control.
        rightPlayer.setLayoutX(700);
        rightPlayer.setLayoutY(300);

        //Left player contains the Blue Player's control.
        leftPlayer.setLayoutX(100);
        leftPlayer.setLayoutY(300);

        //menuHB contains the title of the game, Simple, and General game radio buttons.
        menuHB.setLayoutX(100);
        menuHB.setLayoutY(10);

        //This sets up the board size editor for the GUI.
        textField.setText(String.valueOf(board.getBoardSize()));
        label.setText("Board Size");
        textField.setPrefSize(30, 2);
        textFieldHB.getChildren().addAll(label, textField, btn);
        textFieldHB.setSpacing(5);
        textFieldHB.setLayoutX(700);
        textFieldHB.setLayoutY(10);

        //Shows whose turn it is.
        displayTurn.setText("Blue Player's Turn");
        displayTurn.setFont(Font.font(15));
        displayTurn.setLayoutX(390);
        displayTurn.setLayoutY(75);

        //Add all that stuff to the main part of the GUI
        square.getChildren().addAll(gameBoard, rightPlayer, leftPlayer, menuHB, textFieldHB, displayTurn);

        //If the button next to the textField is pressed, then set the board size to the new value and
        //run the restGUI function.
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                board.setBoardSize(Integer.parseInt(textField.getText()));
                resetGUI();
            }
        });
    }

    //This function resets the GUI by removing all the children, reseting the board and initiating the board.
    //Then run makeBoard function
    public void resetGUI() {
        square.getChildren().removeAll(gameBoard, rightPlayer, leftPlayer, menuHB, textFieldHB, displayTurn);
        textFieldHB.getChildren().removeAll(label, textField, btn);
        board.resetBoard();
        board.initBoard();
        makeBoard();

    }
}
