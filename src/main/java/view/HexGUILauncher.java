package view;

import model.Screen;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * Used to launch the 'Hexadecimal Result' window. 
 */
public class HexGUILauncher implements EventHandler<ActionEvent> {
    private final Screen screen;

    public HexGUILauncher(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent event) {
        HexGUI application = new HexGUI(screen);
        Stage stage = new Stage();
        try {
            application.start(stage);
        } catch (Exception ignored) {}
    }
}