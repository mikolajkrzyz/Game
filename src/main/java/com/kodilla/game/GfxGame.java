package com.kodilla.game;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class GfxGame {
    private final GridPane grid;
    private final Board board;
    private Image imageX = new Image("file:src/main/resources/xsymbol.png",250,250,true,true);
    private Image imageO = new Image("file:src/main/resources/osymbol.png",250,250,true,true);
    private boolean xMove = true;

    public GfxGame(GridPane grid, Board board) {
        this.grid = grid;
        this.board = board;
    }

    public void showOnBoard() {
        grid.getChildren().clear();
        for (int row = 0; row < 3; row++) {
            for ( int col = 0; col < 3; col++){
                ImageView imageView = new ImageView();
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
        board.put(x, y, xMove ? 'X' : 'O');
        xMove = !xMove;
        showOnBoard();
        if (board.whoWin() == 'X' || board.whoWin() == 'O') {
            System.out.println("WIN");
            BorderPane borderPane = new BorderPane();
            Scene scene2 = new Scene(borderPane, 200, 200);
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setTitle("WYGRANA");
            stage2.show();
            //WYŚWIETLIĆ POP UP WINDOW Z KOMUNIKATEM WYGRAŁ X lub O
        }
    }
}
