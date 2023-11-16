package view.paneli;

import javax.swing.*;
import java.awt.*;

public class SlideshowPanel extends JPanel {
    private JPanel akcijePanel=new JPanel(new BorderLayout());
    private CardLayout cardLayout=new CardLayout();
    private JPanel slajdoviPanel=new JPanel(cardLayout);
    private JPanel boxLayout=new JPanel();

    public SlideshowPanel() {
        slajdoviPanel.setMinimumSize(new Dimension(400,250));
        slajdoviPanel.setMaximumSize(new Dimension(400,250));
        slajdoviPanel.setPreferredSize(new Dimension(400,250));
        boxLayout.setLayout(new BoxLayout(boxLayout,BoxLayout.Y_AXIS));
        boxLayout.add(slajdoviPanel);

        this.setLayout(new BorderLayout());
        napraviPanelAkcija();
        this.add(boxLayout,BorderLayout.CENTER);
        this.add(akcijePanel,BorderLayout.SOUTH);
    }

    private void napraviPanelAkcija(){
        JButton prethodni=new JButton("<");
        JButton sledeci=new JButton(">");
        prethodni.addActionListener(e->prethodniStisnut());
        sledeci.addActionListener(e->sledeciStisnut());
        akcijePanel.add(prethodni,BorderLayout.WEST);
        akcijePanel.add(sledeci,BorderLayout.EAST);
    }

    private void prethodniStisnut(){
        cardLayout.previous(slajdoviPanel);
    }

    private void sledeciStisnut(){
        cardLayout.next(slajdoviPanel);
    }

    public void dodajSlajd(SlajdPanel slajdPanel){
        this.slajdoviPanel.add(slajdPanel);
    }

    public void obrisiSlajdove(){
        this.slajdoviPanel.removeAll();
    }

    public void obrisiSlajd(Component component){
        this.slajdoviPanel.remove(component);
    }

    public JPanel getSlajdoviPanel(){
        return slajdoviPanel;
    }
}
