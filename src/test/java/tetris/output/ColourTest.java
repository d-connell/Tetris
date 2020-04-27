package tetris.output;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;

class ColourTest {

    @Test
    void shouldPassToConfirmAquaFillValues() {
        Color aquaFillColour = new Color(22, 231, 207);
        assertEquals(aquaFillColour, Colour.AQUA.getFillColour());
    }

    @Test
    void shouldPassToConfirmAquaBorderValues() {
        Color aquaBorderColour = new Color(0, 168, 157);
        assertEquals(aquaBorderColour, Colour.AQUA.getBorderColour());
    }

    @Test
    void shouldPassToConfirmBlueFillValues() {
        Color blueFillColour = new Color(0, 118, 186);
        assertEquals(blueFillColour, Colour.BLUE.getFillColour());
    }

    @Test
    void shouldPassToConfirmBlueBorderValues() {
        Color blueBorderColour = new Color(0, 77, 128);
        assertEquals(blueBorderColour, Colour.BLUE.getBorderColour());
    }

    @Test
    void shouldPassToConfirmGreenFillValues() {
        Color greenFillColour = new Color(29, 177, 0);
        assertEquals(greenFillColour, Colour.GREEN.getFillColour());
    }

    @Test
    void shouldPassToConfirmGreenBorderValues() {
        Color greenBorderColour = new Color(1, 113, 0);
        assertEquals(greenBorderColour, Colour.GREEN.getBorderColour());
    }

    @Test
    void shouldPassToConfirmGreyFillValues() {
        Color greyFillColour = new Color(111, 111, 111);
        assertEquals(greyFillColour, Colour.GREY.getFillColour());
    }

    @Test
    void shouldPassToConfirmGreyBorderValues() {
        Color greyBorderColour = new Color(92, 92, 92);
        assertEquals(greyBorderColour, Colour.GREY.getBorderColour());
    }

    @Test
    void shouldPassToConfirmOrangeFillValues() {
        Color orangeFillColour = new Color(255, 147, 0);
        assertEquals(orangeFillColour, Colour.ORANGE.getFillColour());
    }

    @Test
    void shouldPassToConfirmOrangeBorderValues() {
        Color orangeBorderColour = new Color(215, 95, 0);
        assertEquals(orangeBorderColour, Colour.ORANGE.getBorderColour());
    }

    @Test
    void shouldPassToConfirmPurpleFillValues() {
        Color purpleFillColour = new Color(146, 18, 153);
        assertEquals(purpleFillColour, Colour.PURPLE.getFillColour());
    }

    @Test
    void shouldPassToConfirmPurpleBorderValues() {
        Color purpleBorderColour = new Color(112, 15, 117);
        assertEquals(purpleBorderColour, Colour.PURPLE.getBorderColour());
    }

    @Test
    void shouldPassToConfirmRedFillValues() {
        Color redFillColour = new Color(238, 34, 12);
        assertEquals(redFillColour, Colour.RED.getFillColour());
    }

    @Test
    void shouldPassToConfirmRedBorderValues() {
        Color redBorderColour = new Color(181, 23, 0);
        assertEquals(redBorderColour, Colour.RED.getBorderColour());
    }

    @Test
    void shouldPassToConfirmYellowFillValues() {
        Color yellowFillColour = new Color(245, 238, 39);
        assertEquals(yellowFillColour, Colour.YELLOW.getFillColour());
    }

    @Test
    void shouldPassToConfirmYellowBorderValues() {
        Color yellowBorderColour = new Color(230, 222, 11);
        assertEquals(yellowBorderColour, Colour.YELLOW.getBorderColour());
    }

}