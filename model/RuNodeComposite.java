package model;

import java.util.ArrayList;

public abstract class RuNodeComposite extends RuNode{

    private ArrayList<RuNode> children;

    public RuNodeComposite(String naziv, RuNode parent) {
        super(naziv, parent);
        children=new ArrayList<>();
    }

    public abstract void addChild(RuNode child);

    public void removeChild(RuNode child){
        if(this.children==null){
            return;
        }
        else {
            this.children.remove(child);
        }
        notifySubscribers(this);
    }

    public ArrayList<RuNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<RuNode> children) {
        this.children = children;
    }
}
