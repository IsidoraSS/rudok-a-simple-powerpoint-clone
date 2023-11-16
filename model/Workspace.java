package model;

import observer.ISubscriber;

import java.util.ArrayList;

public class Workspace extends RuNodeComposite{

    public Workspace() {
        super("Workspace", null);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Projekat){
            this.getChildren().add(child);
            notifySubscribers(this);
        }
    }
}
