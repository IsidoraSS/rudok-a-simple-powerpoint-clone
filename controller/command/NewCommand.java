package controller.command;

import controller.factory.AbstractFactory;
import model.Prezentacija;
import model.RuNode;
import model.RuNodeComposite;
import model.Slajd;
import view.MainFrame;
import view.error.ErrorFactory;
import view.error.Greske;
import view.tree.RuTreeNode;

import javax.swing.*;

import static controller.factory.FactoryGen.returnNodeFactory;

public class NewCommand extends AbstractCommand{

    private RuTreeNode parent=null;
    private RuNode zaDodavanje=null;

    public NewCommand(RuTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public void doCommand() {
        if(zaDodavanje==null){
            if(parent!=null){
                if(!(parent.getCvor() instanceof Slajd)){
                    AbstractFactory abstractFactory=returnNodeFactory(parent);
                    zaDodavanje=abstractFactory.vratiCvor(parent.getCvor());
                }
            }
        }

        parent.addChild(zaDodavanje);

    }

    @Override
    public void undoCommand() {
        if(zaDodavanje instanceof Prezentacija){
            ((Prezentacija)zaDodavanje).obrisiSvuda();
        }
        ((RuNodeComposite)zaDodavanje.getParent()).removeChild(zaDodavanje);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        MainFrame.getInstance().getTree().expandTree();
    }
}
