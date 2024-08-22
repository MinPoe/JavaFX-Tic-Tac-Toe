package org.tictactoe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application{
    @Override
    public void start(Stage window){
        Tiles tiles = new Tiles();
        UI ui = new UI(tiles);
        Scene appWindow = new Scene(ui.drawScene());
        window.setScene(appWindow);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}