package com.kodilla.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GfxGame {
    private final GridPane grid;
    private final Board board;
    private Image imageX = new Image("file:src/main/resources/xsymbol.png");
    private Image imageO = new Image("file:src/main/resources/osymbol.png");
    private boolean xMove = true;

    public GfxGame(GridPane grid, Board board) {
        this.grid = grid;
        this.board = board;
    }

    public void showOnBoard() {
        grid.getChildren().clear();
        for (int row = 0; row < 3; row++) {
            for ( int col = 0; col < 3; col++){
                ImageView imageView = null;
                if (board.getSymbol(col, row) == 'X') {
                    imageView = new ImageView(imageX);
                } else if (board.getSymbol(col,row)=='O'){
                    imageView = new ImageView(imageO);
                }
                grid.add(imageView,col,row);
            }
        }
    }

    public void doClick(int x, int y) {
        board.put(x,y,xMove ? 'X': 'O');
        xMove = !xMove;
        showOnBoard();
    }
}
