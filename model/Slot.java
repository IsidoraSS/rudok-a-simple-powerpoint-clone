package model;

import lombok.Getter;
import lombok.Setter;
import observer.IPublisher;
import observer.ISubscriber;
import view.tools.SerializableStroke;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;


public class Slot implements IPublisher, Serializable {
    private Paint boja;
    private SerializableStroke linija;
    private String naziv;
    private String deskripcija;
    private Dimension velicina;
    private Point pozicija;
    private boolean isSelected=false;
    private Paint bojaSelektovan=Color.red;
    private SlotTip tip;
    private SlotSadrzaj sadrzaj=new SlotSadrzaj("");
    private transient ArrayList<ISubscriber> subscribers;

    public Slot(Paint boja, SerializableStroke linija, String naziv, String deskripcija, Dimension velicina, Point pozicija) {
        this.boja = boja;
        this.linija = linija;
        this.naziv = naziv;
        this.deskripcija = deskripcija;
        this.velicina = velicina;
        this.pozicija = pozicija;
    }

    public boolean elementAt(double x, double y){
        return izmedju(x,this.getPozicija().getX(),this.getPozicija().getX()+this.getVelicina().getWidth()) && izmedju(y,this.getPozicija().getY(),this.getPozicija().getY()+this.getVelicina().getHeight());
    }

    private boolean izmedju(double provera, double x, double y){
        if (x < y)
            return x <= provera && provera <= y;
        else
            return y <= provera && provera <= x;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.getSubscribers() ==null)
            this.setSubscribers(new ArrayList<>());
        if(this.getSubscribers().contains(sub))
            return;
        this.getSubscribers().add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.getSubscribers() == null || !this.getSubscribers().contains(sub))
            return;
        this.getSubscribers().remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.getSubscribers() == null || this.getSubscribers().isEmpty())
            return;
        for(ISubscriber listener : (ArrayList<ISubscriber>)this.getSubscribers().clone()){
            listener.update(notification);
        }
    }

    public void selektovan(){
        if(this.isSelected==false){
            this.isSelected=true;
            this.bojaSelektovan=boja;
            this.boja=Color.RED;
            notifySubscribers(this);
        }
    }

    public void deselektovan(){
        if(this.isSelected==true){
            this.isSelected=false;
            this.boja=bojaSelektovan;
            notifySubscribers(this);
        }
    }

    public ArrayList<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public Dimension getVelicina() {
        return velicina;
    }

    public void setVelicina(Dimension velicina) {
        this.velicina = velicina;
        notifySubscribers(this);
    }

    public Point getPozicija() {
        return pozicija;
    }

    public void setPozicija(Point pozicija) {
        this.pozicija = pozicija;
        notifySubscribers(this);
    }

    public Paint getBoja() {
        return boja;
    }

    public SerializableStroke getLinija() {
        return linija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public SlotTip getTip() {
        return tip;
    }

    public SlotSadrzaj getSadrzaj() {
        return sadrzaj;
    }

    public void setTip(SlotTip tip) {
        this.tip = tip;
    }

    public void setSadrzaj(SlotSadrzaj sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setBoja(String hex) {
        this.bojaSelektovan=Color.decode(hex);
    }

    public void setLinija(SerializableStroke linija) {
        this.linija = linija;
    }
}
