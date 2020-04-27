package tetris.output;

import java.awt.*;

public enum Colour {

    AQUA (22, 231, 207, 0, 168, 157),
    BLUE (0, 118, 186, 0, 77, 128),
    GREEN (29, 177, 0, 1, 113, 0),
    GREY (111, 111, 111, 92, 92, 92),
    ORANGE (255, 147, 0, 215, 95, 0),
    PURPLE (146, 18, 153, 112, 15, 117),
    RED (238, 34, 12, 181, 23, 0),
    YELLOW (245, 238, 39, 230, 222, 11),
    ;

    private final Color fillColour;
    private final Color borderColour;

    Colour(int fillRed, int fillBlue, int fillGreen, int borderRed, int borderBlue, int borderGreen) {
        this.fillColour = new Color(fillRed, fillBlue, fillGreen);
        this.borderColour = new Color(borderRed, borderBlue, borderGreen);
    }

    public Color getFillColour() {
        return fillColour;
    }

    public Color getBorderColour() {
        return borderColour;
    }

}