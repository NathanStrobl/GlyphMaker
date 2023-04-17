package model;

/**
 * Class that stores the grid of pixels that the user is working on.
 */
public class Screen {
    private final Pixel[][] screen;
    private final int columns;
    private final int rows;

    public Screen(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        screen = new Pixel[rows][columns];
        for(int currentRow = 0; currentRow < rows; currentRow++) {
            for(int currentColumn = 0; currentColumn < columns; currentColumn++) {
                screen[currentRow][currentColumn] = new Pixel();
            }
        }
    }

    public Pixel getPixel(int column, int row) {
        return screen[row][column];
    }

    public void togglePixel(int column, int row) {
        screen[row][column].toggle();
        screen[row][column].notifyObserver();
    }

    /**
     * Calculates and returns string representing the hex value so that it can be printed in the 'Hexadecimal Result' window.
     * 
     * @param cluster Specifies which cluster's hex value to calculate; a cluster is four columns that are grouped together into one hex value. 
     * @param row Specified which row the cluster is located in. 
     * @return Returns the result. 
     */
    public String getHexOfCluster(int cluster, int row) {
        int decimal = 0;
        for(int pixelInCluster = 0; pixelInCluster < 4; pixelInCluster++) {
            decimal += (screen[row][(cluster*4) + pixelInCluster].convertStateToInt())*Math.pow(2, 3-pixelInCluster);
        }
        return Integer.toHexString(decimal); 
    }

    public int getNumberOfClusters() {
        return columns/4;
    }

    public int getNumberOfRows() {
        return rows;
    }

    public void resetScreen() {
        for (Pixel[] pixels : screen) {
            for (Pixel pixel : pixels) {
                pixel.reset();
                pixel.notifyObserver();
            }
        }
    }
}