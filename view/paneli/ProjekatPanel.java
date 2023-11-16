package view.paneli;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//OVDE SE DODAJU TABOVI
public class ProjekatPanel extends JPanel implements ISubscriber {
    private TabPane tabPane=new TabPane();
    private Projekat projekat;
    public ProjekatPanel(Projekat projekat) {
        this.projekat=projekat;
        projekat.addSubscriber(this);
        this.setLayout(new BorderLayout());
        this.add(tabPane,BorderLayout.CENTER);
    }

    public TabPane getTabPane() {
        return tabPane;
    }


    public void dodajPrezentacijaTab(Prezentacija prezentacija){
        this.tabPane.addTab(prezentacija.getNaziv(),new PrezentacijaTab(prezentacija));
    }

    public void dodajTabove(Projekat projekat){
        ArrayList<Prezentacija> prezentacije=new ArrayList<>();
        for(RuNode node:projekat.getChildren()){
            prezentacije.add((Prezentacija) node);
        }
        for(Prezentacija p:prezentacije){
            dodajPrezentacijaTab(p);
        }
    }

    @Override
    public void update(Object notification) {
        this.tabPane.removeAll();
        this.dodajTabove((Projekat) notification);
    }
}
