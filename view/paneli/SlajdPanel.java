package view.paneli;

import controller.state.GraphicsState.GraphicsState;
import controller.state.GraphicsState.GraphicsStateManager;
import controller.state.SEState.SEStateManager;
import lombok.SneakyThrows;
import model.Prezentacija;
import model.Slajd;
import model.Slot;
import observer.ISubscriber;
import view.slot.MouseController;
import view.slot.SlotView;
import view.tools.SlajdTip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SlajdPanel extends JPanel implements ISubscriber {
    private Slajd slajdModel;
    private Prezentacija prezentacijaModel;
    private Image img;
    private int sirina;
    private int visina;
    private ArrayList<SlotView> slotViewLista = new ArrayList<>();
    private MouseController mouseController;
    private SlajdTip tip;


    public SlajdPanel(Prezentacija prezentacijaModel, Slajd slajdModel, int sirina, int visina, SlajdTip tip){
        this(sirina,visina);
        this.prezentacijaModel=prezentacijaModel;
        prezentacijaModel.addSubscriber(this);
        this.slajdModel=slajdModel;
        slajdModel.addSubscriber(this);
        this.tip=tip;
        try {
            img=resize("../../slike/placeholder.jpg",sirina,visina);
        } catch (IOException e) {

        }

        refreshujSlotViewe();
        mouseController= new MouseController(this.slajdModel,this);
        if(this.tip==SlajdTip.EDIT){
            this.addMouseListener(mouseController);
            this.addMouseMotionListener(mouseController);
        }
    }

    public SlajdPanel(int sirina, int visina){
        this.sirina=sirina;
        this.visina=visina;
        setPreferredSize(new Dimension(sirina,visina));
        setMaximumSize(new Dimension(sirina,visina));
        setMinimumSize(new Dimension(sirina,visina));
    }

   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            img=resize2(prezentacijaModel.getPozadinskaSlika(),sirina,visina);
        } catch (IOException e) {
        }
        g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
                (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);

       Graphics2D g2 = (Graphics2D)g;
       for(SlotView s:this.slotViewLista){
           if(this.tip==SlajdTip.PREVIEW) s.paintPreview(g2);
           else if(this.tip==SlajdTip.SLIDESHOW) s.paintSlideshow(g2);
           else s.paint(g2);
       }
    }

    public Image resize(String inputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {

        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(getClass().getResource(inputImagePath));

        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
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

    @SneakyThrows
    @Override
    public void update(Object notification) {
        if(notification instanceof Prezentacija){

        }
        if(notification instanceof Slajd){

        }
        refreshujSlotViewe();
    }

    public ArrayList<SlotView> getSlotViewLista() {
        return slotViewLista;
    }

    public void dodajSlotView(SlotView slotView){
        this.slotViewLista.add(slotView);
    }

    public void refreshujSlotViewe(){
        slotViewLista.removeAll(slotViewLista);
        for(Slot s:slajdModel.getSlots()){
            this.dodajSlotView(new SlotView(s));
        }
        revalidate();
        repaint();
    }
}