package view;

import model.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * EventHandler class that resets the screen in the event that the 'Reset Screen' is pressed.
 */
public class ScreenResetter implements EventHandler<ActionEvent> {
    private final Screen screen;

    public ScreenResetter(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {
        screen.resetScreen();
    }
}