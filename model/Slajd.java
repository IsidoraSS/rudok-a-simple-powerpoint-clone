package model;

import observer.ISubscriber;

import java.util.ArrayList;

public class Slajd extends RuNode{
    private int redniBroj;

    public Slajd(String naziv, RuNode parent, int redniBroj) {
        super(naziv, parent);
        this.redniBroj = redniBroj;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
        notifySubscribers(this);
    }

    private ArrayList<Slot> listaSlotova = new ArrayList<>();

    public ArrayList<Slot> getSlots() {
        return listaSlotova;
    }

    public void addSlots(Slot s){
        this.listaSlotova.add(s);
        notifySubscribers(this);
    }

    public void removeSlot(Slot s){
        this.listaSlotova.remove(s);
        notifySubscribers(this);
    }

}
