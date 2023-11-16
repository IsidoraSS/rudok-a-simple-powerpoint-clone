package view.slot;

import model.Slot;
import model.SlotTip;
import observer.ISubscriber;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlotView implements ISubscriber {

    private Slot slotModel;
    private Graphics2D graphics2D;
    private Image img;


    public SlotView(Slot slotModel) {
        this.slotModel = slotModel;
        this.slotModel.addSubscriber(this);
    }

    public void paint(Graphics2D g){
        g.setPaint(slotModel.getBoja());
        g.setStroke(slotModel.getLinija().getStroke());
        g.drawRect(slotModel.getPozicija().x, slotModel.getPozicija().y,slotModel.getVelicina().width, slotModel.getVelicina().height);
    }

    public void paintPreview(Graphics2D g){
        g.setPaint(slotModel.getBoja());
        g.setStroke(new BasicStroke(1f));
        g.drawRect(slotModel.getPozicija().x/5, slotModel.getPozicija().y/5,slotModel.getVelicina().width/5, slotModel.getVelicina().height/5);
    }

    public void paintSlideshow(Graphics2D g){
        if(slotModel.getTip()== SlotTip.SLIKA){
            try {
                img=resize2(slotModel.getSadrzaj().getSadrzaj(),(int)slotModel.getVelicina().getWidth(),(int)slotModel.getVelicina().getHeight());
            } catch (IOException e) {
            }
            g.drawImage(img,(int)slotModel.getPozicija().getX(),(int)slotModel.getPozicija().getY(),null);
        }
        else{
            g.drawString(slotModel.getSadrzaj().getSadrzaj(),(int)slotModel.getPozicija().getX(),(int)slotModel.getPozicija().getY()+12);
        }

        g.setPaint(slotModel.getBoja());
        g.setStroke(slotModel.getLinija().getStroke());
        g.drawRect(slotModel.getPozicija().x, slotModel.getPozicija().y,slotModel.getVelicina().width, slotModel.getVelicina().height);
    }

    @Override
    public void update(Object notification) {

    }

    public Image resize2(String inputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {

        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
    }
}
