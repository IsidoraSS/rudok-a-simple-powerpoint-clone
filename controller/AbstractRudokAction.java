package controller;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction{

    @SneakyThrows
    public Icon ucitajIkonicu(String pathDoIkonice){
        URL imageUrl=getClass().getResource(pathDoIkonice);
        Icon ikonica=null;
        if(imageUrl!=null){
            ikonica = new ImageIcon(ImageIO.read(getClass().getResource(pathDoIkonice)));
        } else {
            System.err.println("Resource not found: " + pathDoIkonice);
        }
        return ikonica;
    }



}
