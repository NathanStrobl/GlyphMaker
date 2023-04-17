package view;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * Used to launch the main window; used by the InitialGUI class to show grid after size has been specified. 
 */
public class MainGUILauncher implements EventHandler<ActionEvent> {
    private final InitialGUI gui;

    public MainGUILauncher(InitialGUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        int rows = gui.getRowsTextField();
        int columns = gui.getColumnsTextField();
        
        while(columns % 8 != 0) {
            columns++;
        }
        if(rows > 56) {
            rows = 56;
        }
        if(columns > 56) {
            columns = 56;
        }
        
        gui.hide();

        MainGUI application = new MainGUI(rows, columns);
        Stage stage = new Stage();
        try {
            application.start(stage);
        } catch (Exception ignored) {}
    }

}