package com.kodilla.game;



public class Board {

    private final char board[][] = new char[3][3];

    public void put(int x, int y, char character) {
        board[x][y] = character;
    } // tu to zmeinic

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
    public boolean computerTurn () {
        for (int c = 0; c < board.length; c++) {
            for (int d=0; d < board[c].length; d++) {
                if (board[c][d] != '-') {
                    return true;
                }
            }
        }
        return false;

        computer.add(computerTurn.nextInt(4));


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
            return board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" +
                    board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n" +
                    board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "\n";


        }
    }

