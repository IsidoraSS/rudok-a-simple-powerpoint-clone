package controller.factory;

import model.RuNode;
import model.RuNodeComposite;
import model.Slajd;

public class SlajdFactory extends AbstractFactory {
    @Override
    public RuNode napraviCvor(RuNode parent) {
        int brDece=((RuNodeComposite)parent).getChildren().size();
        String naziv;
        if(brDece!=0) naziv="Slajd "+String.valueOf(brDece+1);
        else naziv="Slajd 1";
        return new Slajd(naziv,parent,1);
    }
}
