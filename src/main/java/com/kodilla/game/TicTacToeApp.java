package com.kodilla.game;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TicTacToeApp extends Application {
    private Image imageback = new Image("file:src/main/resources/backgroundgreen.png");

    public static void main(String args[]) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        for (int n = 0; n < 3; n++) {
            grid.getColumnConstraints().add(new ColumnConstraints(300));
            grid.getRowConstraints().add(new RowConstraints(300));
        }

        Scene scene = new Scene(grid, 900, 900, Color.BLACK);
        Board board = new Board();
        board.initBoard();
        GfxGame gfxGame = new GfxGame(grid,board);
        gfxGame.showOnBoard();

        grid.setOnMouseClicked(event ->{
            System.out.println(event.getX()+ " " + event.getY());
            int x = (int)event.getX()/300;
            int y = (int)event.getY()/300;
            gfxGame.doClick(x,y);
        } );

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();


    }



}






