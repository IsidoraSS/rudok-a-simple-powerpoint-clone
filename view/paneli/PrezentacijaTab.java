package view.paneli;

import controller.state.GraphicsState.GraphicsState;
import controller.state.GraphicsState.GraphicsStateManager;
import controller.state.SEState.SEState;
import controller.state.SEState.SEStateManager;
import model.Prezentacija;
import model.RuNode;
import model.Slajd;
import observer.ISubscriber;
import view.MainFrame;
import view.tools.SlajdTip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrezentacijaTab extends JPanel implements ISubscriber {
    private JPanel panelZaLabel;
    private JToolBar prezentacijaToolbar=new JToolBar();
    private JToolBar slideshowToolbar=new JToolBar();
    private JPanel panelNorth;
    private JPanel panelZaSlajdove=new JPanel();
    private JScrollPane scrollPaneZaSlajdove;
    private Prezentacija prezentacijaModel;
    private JPanel panelZaPreview=new JPanel();
    private JScrollPane scrollPaneZaPreview;
    private SlideshowPanel panelZaSlideshow=new SlideshowPanel();
    private JPanel panelNorthSlideshow;

    private SEStateManager SEStateManager =new SEStateManager();
    private GraphicsStateManager graphicsStateManager=new GraphicsStateManager();

    public PrezentacijaTab(Prezentacija prezentacija) {
        this.prezentacijaModel=prezentacija;
        this.prezentacijaModel.addSubscriber(this);
        this.setLayout(new BorderLayout());


        panelNorth=new JPanel(new BorderLayout());
        panelNorthSlideshow=new JPanel(new BorderLayout());

        this.panelZaLabel = new JPanel(new BorderLayout());
        panelZaLabel.add(new JLabel("     "+prezentacija.getAutor()),BorderLayout.WEST);
        panelNorth.add(panelZaLabel, BorderLayout.SOUTH);

        slideshowToolbar.setFloatable(false);
        slideshowToolbar.add(MainFrame.getInstance().getActionManager().getSeAction());

        prezentacijaToolbar.setFloatable(false);
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getSeAction());

        //TODO: ne prikazuj uvek
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getAddSlotAction());
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        prezentacijaToolbar.add(MainFrame.getInstance().getActionManager().getSlotEditAction());

        panelNorth.add(prezentacijaToolbar, BorderLayout.NORTH);
        panelNorthSlideshow.add(slideshowToolbar,BorderLayout.NORTH);

        this.add(panelNorth,BorderLayout.NORTH);

        this.panelZaPreview.setLayout(new BoxLayout(panelZaPreview,BoxLayout.Y_AXIS));

        panelZaSlajdove.setLayout(new BoxLayout(panelZaSlajdove,BoxLayout.Y_AXIS));
        dodajSlajdove(prezentacijaModel);

        scrollPaneZaPreview=new JScrollPane(panelZaPreview,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneZaPreview.setPreferredSize(new Dimension(90,100));
        scrollPaneZaPreview.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
        scrollPaneZaSlajdove=new JScrollPane(panelZaSlajdove);
        this.add(scrollPaneZaSlajdove,BorderLayout.CENTER);
        this.add(scrollPaneZaPreview,BorderLayout.WEST);
    }


    public void dodajSlajd(SlajdPanel slajdPanel, SlajdPanel previewSlajd){
        this.panelZaSlajdove.add(slajdPanel);
        this.panelZaPreview.add(previewSlajd);

        panelZaSlajdove.repaint(500);
        panelZaPreview.repaint(500);
    }

    public void promeniAutora(Prezentacija prezentacijaModel){
        ((JLabel)panelZaLabel.getComponent(0)).setText("     "+prezentacijaModel.getAutor());
    }


    public void dodajSlajdove(Prezentacija prezentacijaModel){
        panelZaSlajdove.removeAll();
        panelZaPreview.removeAll();
        panelZaSlideshow.obrisiSlajdove();
        panelZaSlajdove.add(Box.createRigidArea(new Dimension(0, 20)));
        panelZaPreview.add(Box.createRigidArea(new Dimension(0,5)));
        ArrayList<Slajd> deca= new ArrayList<>();
        for(RuNode ruNode:prezentacijaModel.getChildren()){
            deca.add((Slajd) ruNode);
        }
        for(Slajd s:deca){
            SlajdPanel slajdPanel=new SlajdPanel((Prezentacija) s.getParent(),s, 400,250, SlajdTip.EDIT);
            SlajdPanel slajdPanelZaPreview=new SlajdPanel((Prezentacija) s.getParent(),s, 80,50, SlajdTip.PREVIEW);
            SlajdPanel slajdZaSlideshow=new SlajdPanel((Prezentacija) s.getParent(),s, 400,250, SlajdTip.SLIDESHOW);
            panelZaSlideshow.dodajSlajd(slajdZaSlideshow);
            dodajSlajd(slajdPanel,slajdPanelZaPreview);
            panelZaSlajdove.add(Box.createRigidArea(new Dimension(0, 20)));
            panelZaPreview.add(Box.createRigidArea(new Dimension(0,5)));
        }

        //ovo je dodato jer se repaint jako sporo poziva u suprotnom. Kada se promeni tekst slajdovi se odmah pojave
        ((JLabel)panelZaLabel.getComponent(0)).setText("     ");
        ((JLabel)panelZaLabel.getComponent(0)).setText("     "+prezentacijaModel.getAutor());
        panelZaSlajdove.repaint();
        panelZaPreview.repaint();
        panelZaSlideshow.repaint();
    }

    public String getNazivPrezentacije(){
        return this.prezentacijaModel.getNaziv();
    }

    @Override
    public void update(Object notification) {
        dodajSlajdove((Prezentacija) notification);
        promeniAutora((Prezentacija) notification);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }

    public SEState getTrenutnoEditStanje() {
        return this.SEStateManager.getTrenutnoStanje();
    }

    public void promeniStanjeUEdit(){
        this.SEStateManager.setEditState();
    }

    public void promeniStanjeUSlideshow(){
        this.SEStateManager.setSlideshowState();
    }

    public void zameniPanele(){
        this.SEStateManager.getTrenutnoStanje().prikaziPanel(this,scrollPaneZaPreview,scrollPaneZaSlajdove,panelZaSlideshow,panelNorth,panelNorthSlideshow);
        ((JLabel)panelZaLabel.getComponent(0)).setText("     ");
        ((JLabel)panelZaLabel.getComponent(0)).setText("     "+prezentacijaModel.getAutor());
        this.revalidate();
        this.repaint();
    }

    public GraphicsState getTrenutnoGraphicsStanje(){
        return this.graphicsStateManager.getTrenutnoStanje();
    }

    public void promeniStanjeUAddSlot(){
        this.graphicsStateManager.setAddSlotState();
    }

    public void promeniStanjeUDeleteSlot(){
        this.graphicsStateManager.setDeleteSlotState();
    }

    public void promeniStanjeUMoveSlot(){
        this.graphicsStateManager.setMoveSlotState();
    }

    public void promeniStanjeUSelectSlot(){
        this.graphicsStateManager.setSelectSlotState();
    }

    public Prezentacija getPrezentacijaModel() {
        return prezentacijaModel;
    }
}
