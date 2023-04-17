package view;

import model.Pixel;
import model.Screen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * The window that shows the grid of pixels and can be manipulated to create a glyph. 
 */
public class MainGUI extends Application {
    public static final Image BLACK = new Image("graphics/black.jpg");
    public static final Image WHITE = new Image("graphics/white.jpg");
    private final int ROWS;
    private final int COLUMNS;
    private final Screen screen;

    public MainGUI(int ROWS, int COLUMNS) {
        this.ROWS = ROWS;
        this.COLUMNS = COLUMNS;
        screen = new Screen(COLUMNS, ROWS);
    }

    @Override
    public void start(Stage stage) {
        GridPane buttonGrid = new GridPane();
        for(int row = 0; row < ROWS; row++) {
            for(int column = 0; column < COLUMNS; column++) {
                buttonGrid.add(makeButton(column, row), column, row);
            }
        }


        Button resetButton = new Button("Reset Screen");
        resetButton.setPrefSize(8*COLUMNS, 32);
        resetButton.setOnAction(new ScreenResetter(screen));

        Button exportButton = new Button("Convert to Hexadecimal");
        exportButton.setPrefSize(10*COLUMNS, 32);
        exportButton.setOnAction(new HexGUILauncher(screen));

        HBox controls = new HBox();
        controls.getChildren().addAll(resetButton, exportButton);
        

        BorderPane main = new BorderPane();
        main.setCenter(buttonGrid);
        main.setBottom(controls);
        
        
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setTitle(COLUMNS + " x " + ROWS + " pixels (" + ((COLUMNS/8) * ROWS) + " bytes) - GlyphMaker for AdafruitGFX");
        stage.setResizable(false);
        stage.show();
    }

    public void togglePixel(int column, int row) {
        screen.togglePixel(column, row);
    }

    /**
     * Button factory that creates each button on the grid. 
     * 
     * @param column Specifies which column the button belongs to. 
     * @param row Specifies which row the button belongs to. 
     * @return Returns a button that has a Pixel and PixelToggler attached to it. 
     */
    private Button makeButton(int column, int row) {
        ImageView buttonGraphic = new ImageView(BLACK);
        buttonGraphic.setFitWidth(16);
        buttonGraphic.setFitHeight(16);

        Button button = new Button("", buttonGraphic);
        button.setPadding(new Insets(1, 1, 1, 1));
        button.setOnAction(new PixelToggler(row, column, this));

        Pixel pixel = screen.getPixel(column, row);
        pixel.setOnChange(new PixelDisplayUpdater(buttonGraphic));
        
        return button;
    }
}