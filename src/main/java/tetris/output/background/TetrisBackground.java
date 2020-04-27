package tetris.output.background;

import tetris.validation.ObjectValidator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TetrisBackground implements Background {

    private BufferedImage background;

    public TetrisBackground(String fileName) {
        ObjectValidator.ValidateObjectNotNull(fileName, "fileName");
        setImage(fileName);
    }

    private void setImage(String fileName) {
        try {
            background = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException("Background image not found.");
        }
    }

    @Override
    public BufferedImage getImage() {
        return background;
    }

}