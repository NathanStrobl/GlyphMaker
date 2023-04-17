package view;

import model.Screen;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;

/**
 * The window that shows the hexadecimal result.
 */
public class HexGUI extends Application {
    private final Screen screen;

    public HexGUI(Screen screen) {
        this.screen = screen;
    }
 
    @Override
    public void start(Stage stage) {
        TextArea hexValuesDisplayArea = new TextArea(hexOutputGenerator());
        hexValuesDisplayArea.setPrefSize(1024, 768);
        hexValuesDisplayArea.setEditable(false);

        Scene scene = new Scene(hexValuesDisplayArea);
        stage.setScene(scene);
        stage.setTitle("Hexadecimal Result - GlyphMaker for AdafruitGFX");
        stage.setResizable(true);
        stage.show();
    }

    /**
     * Assembles the hex output that can be copied and pasted into a font file and uploaded to an Arduino using the Adafruit GFX library. 
     * 
     * @return The complete result of the hexadecimal calculations, as well as the number of indices used.
     */
    private String hexOutputGenerator() {
        String completeHexOutput = "{\n";
        for(int row = 0; row < screen.getNumberOfRows(); row++) {
            for(int cluster = 0; cluster < screen.getNumberOfClusters(); cluster += 2) {
                completeHexOutput += ("0x" + screen.getHexOfCluster(cluster, row) + screen.getHexOfCluster(cluster+1, row) + ", ");       
            }
            completeHexOutput += "\n";
        }
        completeHexOutput = completeHexOutput.substring(0, completeHexOutput.length() - 3);
        completeHexOutput += ("\n}" + "\n\nNumber of indices: " + ((screen.getNumberOfClusters()/2))*screen.getNumberOfRows());
        
        return completeHexOutput;
    }
}