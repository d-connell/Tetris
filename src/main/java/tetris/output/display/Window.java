package tetris.output.display;

import tetris.validation.DimensionsValidator;
import tetris.validation.ObjectValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Window extends Canvas implements Display {

    private static Canvas canvas;

    public Window(int width, int height, String title, KeyListener keyListener) {
        validateInputs(width, height, title, keyListener);
        createCanvas(width, height);
        createJFrame(title, keyListener);
    }

    @Override
    public Canvas getCanvas() {
        return canvas;
    }

    private void validateInputs(int width, int height, String title, KeyListener keyListener) {
        DimensionsValidator.ValidateDimensionsGreaterThanZero(width, height);
        ObjectValidator.ValidateObjectNotNull(title, "title");
        ObjectValidator.ValidateObjectNotNull(keyListener, "keyListener");
    }

    private void createCanvas(int width, int height) {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
    }

    private void createJFrame(String title, KeyListener keyListener) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(keyListener);
    }

}