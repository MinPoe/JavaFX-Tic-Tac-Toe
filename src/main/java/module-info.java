module org.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.tictactoe to javafx.fxml;
    exports org.tictactoe;
}