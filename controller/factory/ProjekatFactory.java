package controller.factory;

import model.Projekat;
import model.RuNode;
import model.RuNodeComposite;

public class ProjekatFactory extends AbstractFactory{
    @Override
    public RuNode napraviCvor(RuNode parent) {
        int brDece=((RuNodeComposite)parent).getChildren().size();
        String naziv;
        if(brDece!=0) naziv="Projekat "+String.valueOf(brDece+1);
        else naziv="Projekat 1";
        return new Projekat(naziv,parent);
    }
}
