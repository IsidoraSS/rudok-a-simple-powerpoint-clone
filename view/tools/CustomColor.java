package view.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomColor {
    private String hexValue;
    private String naziv;
    private ImageIcon ikonica;

    public CustomColor(String hexValue, String naziv) {
        this.hexValue = hexValue;
        this.naziv = naziv;
        this.ikonica=napraviIkonicu();
    }

    private ImageIcon napraviIkonicu(){
        BufferedImage image = new BufferedImage(22, 22, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setPaint(Color.decode(hexValue));
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public String getHexValue() {
        return hexValue;
    }

    public String getNaziv() {
        return naziv;
    }

    public ImageIcon getIkonica() {
        return ikonica;
    }
}
