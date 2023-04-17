package model;

import view.PixelDisplayUpdater;

/**
 * Class that represents a single pixel of the glyph; stores the pixel's state and its observer.
 */
public class Pixel {
    private boolean pixelOnState;
    private PixelObserver observer;

    public Pixel() {
        pixelOnState = false;
    }

    public boolean isPixelOn() {
        return pixelOnState;
    }

    public void toggle() {
        pixelOnState = !pixelOnState;
    }

    public void reset() {
        pixelOnState = false;
    }

    /**
     * Converts the pixels state from a boolean value to either a 1 or 0; used when calculating the hexadecimal values. 
     * 
     * @return 1 if pixel is ON, 0 if pixel is OFF
     */
    public int convertStateToInt() {
        return pixelOnState ? 1 : 0;
    }

    public void setOnChange(PixelDisplayUpdater observer) {
        this.observer = observer;
    }

    public final void notifyObserver() {
        if(this.observer != null) {
            observer.pixelChanged(this);
        }
    }
}