package com.kodilla.game;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TicTacToeApp extends Application {
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);
        for ( int m = 0; m < 3; m++) {
            for ( int k = 0; k < 3; k++) {
                Tile tile = new Tile();
                tile.setTranslateX(k * 200);
                tile.setTranslateY(m * 200);
                root.getChildren().add(tile);
            }
        }
        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("TICTACTOE");
        primaryStage.show();
    }
    private class Tile extends StackPane {
        public Tile() {
            Rectangle border = new Rectangle(200,200);
            border.setFill(null);
            border.setStroke(Color.BLACK);
             setAlignment(Pos.CENTER);
             getChildren().addAll(border);
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}






