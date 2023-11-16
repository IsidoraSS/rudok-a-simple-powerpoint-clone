package controller.factory;

import model.Prezentacija;
import model.RuNode;
import model.RuNodeComposite;

public class PrezentacijaFactory extends AbstractFactory {
    @Override
    public RuNode napraviCvor(RuNode parent) {
        int brDece=((RuNodeComposite)parent).getChildren().size();
        String naziv;
        if(brDece!=0) naziv="Prezentacija "+String.valueOf(brDece+1);
        else naziv="Prezentacija 1";
        return new Prezentacija(naziv,parent,"Autor");
    }
}
