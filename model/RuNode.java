package model;

import observer.IPublisher;
import observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class RuNode implements IPublisher, Serializable {
    private String naziv;
    private RuNode parent;
    private transient ArrayList<ISubscriber> subscribers;

    public RuNode(String naziv, RuNode parent) {
        this.naziv = naziv;
        this.parent = parent;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
        notifySubscribers(this);
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
        notifySubscribers(this);
    }

    public ArrayList<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<ISubscriber> subscribers) {
        this.subscribers = subscribers;
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

}
