package com.kodilla.game;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final char board[][] = new char[3][3];

    public void put(int x, int y, char character) {
        board[x][y] = character;
    }

    public void initBoard() {
        put(0, 0, '-');
        put(0, 1, '-');
        put(0, 2, '-');
        put(1, 0, '-');
        put(1, 1, '-');
        put(1, 2, '-');
        put(2, 0, '-');
        put(2, 1, '-');
        put(2, 2, '-');
    }

    public boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public List<ComputerMove> getPossibleComputerMoves() {
        List<ComputerMove> possibleComputerMoves = new ArrayList<>();
        for ( int x = 0; x < board.length; x++) {
            for ( int y = 0; y < board[x].length; y++) {
                if (board[x][y] == '-') {
                    possibleComputerMoves.add(new ComputerMove(x,y));
                }
            }
        }
        return possibleComputerMoves;
    }
    public char getSymbol(int x, int y) {
        return board[x][y];
    }

    public char whoWin() {
        if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]) && (board[0][0] != '-')) {
            return board[0][0];
        }
        if ((board[1][0] == board[1][1]) && (board[1][0] == board[1][2]) && (board[1][0] != '-')) {
            return board[1][0];
        }
        if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]) && (board[2][0] != '-')) {
            return board[2][0];
        }
        if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]) && (board[0][0] != '-')) {
            return board[0][0];
        }
        if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]) && (board[0][1] != '-')) {
            return board[0][1];
        }
        if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]) && (board[0][2] != '-')) {
            return board[0][2];
        }

        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[0][0] != '-')) {
                return board[0][0];
        }
        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[0][2] != '-')) {
            return board[0][2];
        }

        return '-';
        }

        @Override
        public String toString () {
            return board[0][0] + "|" + board[1][0] + "|" + board[2][0] + "\n" +
                    board[0][1] + "|" + board[1][1] + "|" + board[2][1] + "\n" +
                    board[0][2] + "|" + board[1][2] + "|" + board[2][2] + "\n";


        }
    }

