package myclass26x0;

import java.util.Scanner;

public class X0Game {
    FieldX0 gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;


    void setupNewGame(){
        System.out.println("Will play new X0 game");
        this.gameField = new FieldX0();
        this.gameField.initField();
    }

    void play(){
        this.setupNewGame();
        System.out.println("Who will make first turn: ");
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == '0'){
            this.whoMakeNextTurn = first;
        }else {
            System.out.println("i recognizing only X and 0 (zero). So first will be X");
            this.whoMakeNextTurn = 'X';
        }

        while (!gameOver){
            turn();
            this.gameOver = this.gameField.isGameOver(this.whoMakeNextTurn);
            if (this.gameOver){
                System.out.println(this.whoMakeNextTurn + " win!");
            }
            if (this.whoMakeNextTurn == 'X'){
                this.whoMakeNextTurn = '0';
            }else {
                this.whoMakeNextTurn = 'X';
            }
        }
        System.out.println("game over.");
    }

    void turn() {
        System.out.println(this.whoMakeNextTurn + ", you turn.");
        System.out.print("Chose row: ");
        int rowNumber = this.scanner.nextInt();
        System.out.print("Chose column: ");
        int colNumber = this.scanner.nextInt();
        int rowIndex = rowNumber - 1;
        int colIndex = colNumber - 1;
        if (this.gameField.isPlaceFree(rowIndex, colIndex)){
            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
            this.gameField.printField();
        }else{
            System.out.println("Wrong number (maybe is not free?). Make turn again");
            turn();
        }
    }
}
