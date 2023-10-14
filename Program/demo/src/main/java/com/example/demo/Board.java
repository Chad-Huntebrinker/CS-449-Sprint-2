package com.example.demo;


import java.util.ArrayList;

public class Board {

    //Variables for Board
    private ArrayList<ArrayList <Box>> board;
    private boolean isBluePlayerTurn;
    private boolean isSimpleGame;
    private int boardSize;

    //Constructor.
    public Board() {
        board = new ArrayList<ArrayList<Box>>();
        isBluePlayerTurn = true;
        isSimpleGame = true;
        boardSize = 3;
        initBoard();
    }

    //initBoard builds the ArrayList full of Boxes
    public void initBoard() {
        this.board = new ArrayList<ArrayList<Box>>();
        this.isBluePlayerTurn = true;

        for(int i = 0; i < boardSize; ++i) {
            this.board.add(new ArrayList<Box>());
            for(int j = 0; j < boardSize; ++j) {
                addBox(new Box(), i, j);
            }
        }

    }

    //This function adds the box to the ArrayList.
    public void addBox(Box box, int row, int column) {
        this.board.get(row).add(column, box);
    }

    //Get a specific Box from the ArrayList.
    public Box getBoxOfBoard(int row, int column) {
        if(row >= 0 && row < boardSize && column >= 0 && column < boardSize) {
            return this.board.get(row).get(column);
        }
        return null;

    }

    //Resets the board.
    public void resetBoard() {board.clear();}

    //Sets the board to the size given if it is greater than 2.
    public void setBoardSize(int size) {
        if(size > 2){
            boardSize = size;
        }
        initBoard();
    }

    //Getters and setters.
    public int getBoardSize() {return boardSize;}
    public void setIsBlueTurn(boolean turn) {isBluePlayerTurn = turn;}
    public boolean getIsBlueTurn() {return isBluePlayerTurn;}
    public void setIsSimpleGame(boolean gameMode) {isSimpleGame = gameMode;}
    public boolean getIsSimpleGame() {return isSimpleGame;}


}
