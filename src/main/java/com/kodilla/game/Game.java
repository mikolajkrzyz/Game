package com.kodilla.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game  {
    private final Board board;
    private boolean gameFinished = false;
    private boolean playerTurn = true;


    public Game(Board board) {

        this.board = board;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void play () throws IOException {
        playerMove();
        checkEndCondition();
    }

    private void playerMove() throws IOException {
        if (playerTurn){
            System.out.println("Podaj współrzędne wiersza");
            int x = readCoordinateFromUser();
            System.out.println("Podaj współrzędne kolumny");
            int y = readCoordinateFromUser();

            try {
                board.put(x,y, 'X');
            } catch ( ArrayIndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowe współrzędne:" + x + y);
                playerMove();
            }
            playerTurn = false;
        } else { // uzywam obiekt random next int zeby wylos0wac liczbe od 0 do 2 razy 2 bo dwie wspolrzedne. i wtedy robie board.put na randomach
            System.out.println("Podaj współrzędne wiersza");
            int x = readCoordinateFromUser();
            System.out.println("Podaj współrzędne kolumny");
            int y = readCoordinateFromUser();

            try {
                board.put(x,y, 'O'); // metoda put nie moza dawac w to samo miejsce x i o ( pamietaj zeby w while wrzucuic "!")
            } catch ( ArrayIndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowe współrzędne:" + x + y);
                playerMove();
            }
            playerTurn = true;
        }


    }
    private void checkEndCondition () {
        if (board.isBoardFull()) {
            gameFinished = true;
            System.out.println("plansza pełna");
        }
        if (board.whoWin()!='-') {
            gameFinished = true;
            System.out.println("wygrał " + board.whoWin());
        }
    }

    private int readCoordinateFromUser () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Nieprawidłowy format, spróbuj jeszcze raz");
            return readCoordinateFromUser();
        }
    }
}

