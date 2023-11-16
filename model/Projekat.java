package model;

import observer.ISubscriber;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Projekat extends RuNodeComposite{

    public Projekat(String naziv, RuNode parent) {
        super(naziv, parent);
    }
    private File projekatFile=null;
    private boolean promenjen=false;

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Prezentacija){
            this.getChildren().add(child);
            notifySubscribers(this);
        }
    }

    public File getProjekatFile() {
        return projekatFile;
    }

    public void setProjekatFile(File projekatFile) {
        this.projekatFile = projekatFile;
    }

    public boolean jePromenjen() {
        return promenjen;
    }

    public void setPromenjen(boolean promenjen) {
        this.promenjen = promenjen;
    }

    @Override
    public String toString() {
        return this.getNaziv();
    }
}
