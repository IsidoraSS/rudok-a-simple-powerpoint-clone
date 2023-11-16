package model;

import observer.ISubscriber;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.util.ArrayList;

public class Prezentacija extends RuNodeComposite{
    private String autor;
    private String pozadinskaSlika;
    private ArrayList<Projekat> projektiDeljenje=new ArrayList<>();

    public Prezentacija(String naziv, RuNode parent, String autor) {
        super(naziv, parent);
        this.autor = autor;
        this.pozadinskaSlika = "../slike/placeholder.jpg";
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Slajd){
            this.getChildren().add(child);
            notifySubscribers(this);
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers(this);
    }

    public void setPozadinskaSlika(String pozadinskaSlikaPath) {
        this.pozadinskaSlika = pozadinskaSlikaPath;
        notifySubscribers(this);
    }

    public String getPozadinskaSlika() {
        return pozadinskaSlika;
    }

    public void podeliPrezentaciju(Projekat projekat){
        projekat.addChild(this);
        this.projektiDeljenje.add(projekat);
    }

    public void obrisiSvuda(){
        for(Projekat p:projektiDeljenje){
            p.removeChild(this);
        }
    }

    public void obrisiIzJednog(Projekat projekat){
        projekat.removeChild(this);
    }

    public ArrayList<Projekat> getProjektiDeljenje() {
        return projektiDeljenje;
    }
}
