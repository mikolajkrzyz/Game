package com.kodilla.game;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;
    private boolean gameFinished = false;
    private boolean playerTurn = true;
    private char playerSymbol;


    public Game(Board board) {

        this.board = board;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void play() throws IOException {
         playerSymbol = readSymbolFromUser();
        while (!isGameFinished()) {
            playerMove();
            System.out.println(board);
            checkEndCondition();
        }
    }

    private void playerMove() throws IOException {
        if (playerTurn) {
            System.out.println("Podaj współrzędne kolumny");
            int x = readCoordinateFromUser();
            System.out.println("Podaj współrzędne wiersza");
            int y = readCoordinateFromUser();

            try {
                if (board.getSymbol(x, y) != '-') {
                    System.out.println("Pole jest już zajęte");
                    playerMove();
                } else {
                    board.put(x, y, playerSymbol);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowe współrzędne:" + x + y);
                playerMove();
            }
            playerTurn = false;
        } else {
            List<ComputerMove> possibleComputrerMoves = board.getPossibleComputerMoves();
            Collections.shuffle(Collections.singletonList(possibleComputrerMoves));
            ComputerMove computerMove = possibleComputrerMoves.get(0);
            board.put(computerMove.getX(), computerMove.getY(), playerSymbol == 'O' ? 'X' : 'O');
            playerTurn = true;
        }
    }

    private void checkEndCondition() {
        if (board.isBoardFull()) {
            gameFinished = true;
            System.out.println("Plansza jest pełna");
        }
        if (board.whoWin() != '-') {
            gameFinished = true;
            System.out.println("Gratulacje wygrał : " + board.whoWin());
        }
    }

    private int readCoordinateFromUser() throws IOException {
        try {
            return Integer.parseInt(readLineFromUser());
        } catch (NumberFormatException nfe) {
            System.out.println("Nieprawidłowa współrzędna, spróbuj jeszcze raz");
            return readCoordinateFromUser();
        }
    }

    private char readSymbolFromUser() throws IOException {
        System.out.println("Podaj symbol jakim chcesz grać");
        String lineFromUser = readLineFromUser();
        char symbol = lineFromUser.charAt(0);
        if (symbol == 'O' || symbol == 'X') {
            return symbol;
        } else {
            System.out.println("Podany symbol jest nieprawidłowy");
            return readSymbolFromUser();
        }
    }
    private String readLineFromUser() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();

    }
}

