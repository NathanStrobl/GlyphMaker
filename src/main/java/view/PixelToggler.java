package view;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * EventHandler class that toggles the pixels when their corresponding button is pressed.
 */
public class PixelToggler implements EventHandler<ActionEvent> {
    private final int row;
    private final int column;
    private final MainGUI screen;

    public PixelToggler(int row, int column, MainGUI screen) {
        this.row = row;
        this.column = column;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {
        screen.togglePixel(column, row);
    }
}