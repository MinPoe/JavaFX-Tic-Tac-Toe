package org.tictactoe;

import javafx.scene.layout.BorderPane;

public class UI {
    private Tiles tiles;

    public UI(Tiles tiles){
        this.tiles = tiles;
    }

    public BorderPane drawScene() {
        BorderPane windowView = new BorderPane();
        windowView.setTop(this.tiles.getTurnDisplay());
        windowView.setCenter(this.tiles.drawGrid());

        return windowView;
    }



}
