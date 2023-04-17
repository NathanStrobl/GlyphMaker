package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

/**
 * The initial window that prompts the user to enter the desired size of the grid.
 */
public class InitialGUI extends Application {
    private Stage window;
    private TextField rows;
    private TextField columns;

    @Override
    public void start(Stage stage) {
        window = new Stage();

        rows = new TextField();
        rows.setPrefSize(128, 32);
        rows.setPromptText("rows");

        columns = new TextField();
        columns.setPromptText("columns (mult. of 8)");
        columns.setPrefSize(128, 32);

        HBox textFields = new HBox();
        textFields.getChildren().addAll(columns, rows);

        Button generateButton = new Button("Generate Screen");
        generateButton.setPrefSize(256, 32);
        generateButton.setOnAction(new MainGUILauncher(this));

        BorderPane main = new BorderPane();
        main.setCenter(textFields);
        main.setBottom(generateButton);

        Scene scene = new Scene(main);
        window.setTitle("Enter desired glyph size.");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public int getRowsTextField() {
        return Integer.parseInt(rows.getText());
    }

    public int getColumnsTextField() {
        return Integer.parseInt(columns.getText());
    }

    public void hide() {
        window.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}