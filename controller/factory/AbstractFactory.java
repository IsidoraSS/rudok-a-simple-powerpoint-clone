package controller.factory;

import model.RuNode;

public abstract class AbstractFactory {

    public RuNode vratiCvor(RuNode selektovaniCvor){
        RuNode node = napraviCvor(selektovaniCvor);
        return node;
    }

    public abstract RuNode napraviCvor(RuNode cvor);
}
