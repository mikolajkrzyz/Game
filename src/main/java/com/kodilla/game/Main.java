package com.kodilla.game;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {
        Board board = new Board();
        board.initBoard();
        Game game = new Game(board);
        char playerSymbol = 'O';
        while (!game.isGameFinished()) {
            game.play();
            System.out.println(board);
        }
    }
}
