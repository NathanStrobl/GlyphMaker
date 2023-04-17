package view;

import model.Pixel;
import model.PixelObserver;
import javafx.scene.image.ImageView;

/**
 * Class that updates buttons on the grid as they are changed.
 */
public class PixelDisplayUpdater implements PixelObserver {
    private final ImageView buttonGraphic;

    public PixelDisplayUpdater(ImageView buttonGraphic) {
        this.buttonGraphic = buttonGraphic;
    }

    @Override
    public void pixelChanged(Pixel pixel) {
        if(!pixel.isPixelOn()) {
            buttonGraphic.setImage(MainGUI.BLACK);
        } else {
            buttonGraphic.setImage(MainGUI.WHITE);
        } 
    }
}