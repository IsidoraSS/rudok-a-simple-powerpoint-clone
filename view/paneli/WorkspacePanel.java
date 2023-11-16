package view.paneli;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WorkspacePanel extends JPanel implements ISubscriber {
    private TabPane tabPane=new TabPane();
    private JPanel panelZaLabel;
    private Projekat projekat;

    public WorkspacePanel() {
        this.setLayout(new BorderLayout());
        this.add(tabPane,BorderLayout.CENTER);
    }

    public TabPane getTabPane() {
        return tabPane;
    }

    public void setProjekat(Projekat projekat) {
        tabPane.removeAll();
        this.projekat = projekat;
        this.projekat.addSubscriber(this);
        this.panelZaLabel = new JPanel(new BorderLayout());
        panelZaLabel.add(new JLabel("     "+projekat.getNaziv()),BorderLayout.CENTER);
        this.add(panelZaLabel,BorderLayout.NORTH);
        dodajTabove(projekat);
    }

    public void dodajProjectTab(PrezentacijaTab tab){
        this.tabPane.addTab(tab.getNazivPrezentacije(),tab);
    }

    public void promeniNaziv(Projekat projekat){
        ((JLabel)panelZaLabel.getComponent(0)).setText("     "+projekat.getNaziv());
    }

    public void dodajTabove(Projekat projekat) {
        tabPane.removeAll();
        ArrayList<Prezentacija> deca= new ArrayList<>();
        for(RuNode ruNode:projekat.getChildren()){
            deca.add((Prezentacija) ruNode);
        }
        for(Prezentacija p:deca){
            PrezentacijaTab tab=new PrezentacijaTab(p);
            dodajProjectTab(tab);
        }
    }

    public Projekat getProjekat() {
        return projekat;
    }

    @Override
    public void update(Object notification) {
        dodajTabove((Projekat)notification);
        promeniNaziv((Projekat) notification);
    }
}
