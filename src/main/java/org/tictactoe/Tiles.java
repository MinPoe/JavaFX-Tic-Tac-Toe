package org.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Tiles {
    private Label turnDisplay;

    // to store individual buttons that serve as the tic-tac-toe tiles
    private Button[][] tiles;
    private String playerTurn;
    private boolean endGame;
    private boolean winner;

    public Tiles(){
        this.turnDisplay = new Label("Turn: X");
        this.tiles = new Button[3][3];
        this.playerTurn = "X";
        this.endGame = false;

        // used to store boolean distinguishing between an endgame state of a win or stalemate
        this.winner = false;
    }

    public GridPane drawGrid(){
        GridPane squareGrid = new GridPane();

        for(int col = 0; col < 3; col++){
            for(int row = 0; row < 3; row++){
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));

                button.setOnAction((event) -> {
                    if(button.getText().equals(" ") && !this.endGame){
                        button.setText(this.playerTurn);
                        endGameUpdate();
                        if(!this.endGame) {
                            changeTurn();
                            this.turnDisplay.setText("Turn: " + this.playerTurn);
                        }

                    }
                });
                squareGrid.add(button, col, row);
                this.tiles[row][col] = button;
            }
        }

        return squareGrid;
    }

    public void changeTurn(){
        if (this.playerTurn.equals("X")) {
            this.playerTurn = "O";
        } else {
            this.playerTurn = "X";
        }
    }

    public Label getTurnDisplay(){
        return this.turnDisplay;
    }

    public void endGameUpdate() {
        if (checkWin()) {
            this.endGame = true;
            this.turnDisplay.setText(this.playerTurn + " wins!");
        }

        if (checkStalemate()){
            this.endGame = true;
            this.turnDisplay.setText("Stalemate, game end.");
        }
    }

    public boolean checkWin(){
        if(checkRows() || checkColumns() || checkDiagonals()){
            return true;
        }

        return false;
    }

    public boolean checkRows(){
        for(int row = 0; row < 3; row++){
            if( this.tiles[row][0].getText().equals(this.tiles[row][1].getText())
                    && this.tiles[row][2].getText().equals(this.tiles[row][1].getText())
                    && !this.tiles[row][0].getText().equals(" ") ){
                String winner = this.tiles[row][0].getText();
                gameWon(winner);
                return true;
            }
        }

        return false;
    }

    public boolean checkColumns(){
        for(int col = 0; col < 3; col++){
            if( this.tiles[0][col].getText().equals(this.tiles[1][col].getText())
                    && this.tiles[2][col].getText().equals(this.tiles[1][col].getText())
                    && !this.tiles[0][col].getText().equals(" ")){
                String winner = this.tiles[0][col].getText();
                gameWon(winner);
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonals(){
        // left to right diagonal
        if(!this.tiles[0][0].getText().equals(" ")) {
            if (this.tiles[0][0].getText().equals(this.tiles[1][1].getText())
                    && this.tiles[2][2].getText().equals(this.tiles[1][1].getText())) {
                String winner = this.tiles[0][0].getText();
                gameWon(winner);
                return true;
            }
        }

        // right to left diagonal
        if(!this.tiles[2][0].getText().equals(" ")) {
            if (this.tiles[2][0].getText().equals(this.tiles[1][1].getText())
                    && this.tiles[0][2].getText().equals(this.tiles[1][1].getText())) {
                String winner = this.tiles[2][0].getText();
                gameWon(winner);
                return true;
            }
        }

        return false;
    }
    public boolean checkStalemate(){
        for( int row = 0; row < 3; row++){
            for( int col = 0; col < 3; col++){
                if(tiles[row][col].getText().equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }
    public void gameWon(String winner){
        turnDisplay.setText("Player " + winner + " has won!");
    }

    public void stalemate(){
        turnDisplay.setText("Stalemate, game has ended.");
    }

}
