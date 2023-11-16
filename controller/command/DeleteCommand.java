package controller.command;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import model.RuNodeComposite;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.util.ArrayList;

public class DeleteCommand extends AbstractCommand{

    private RuNode zaBrisanje;
    private RuNode parent;
    private ArrayList<Projekat> projekti;

    public DeleteCommand(RuNode zaBrisanje) {
        this.zaBrisanje = zaBrisanje;
        this.parent=zaBrisanje.getParent();
        if(zaBrisanje instanceof Prezentacija) projekti= ((Prezentacija) zaBrisanje).getProjektiDeljenje();
    }

    @Override
    public void doCommand() {
        if(zaBrisanje instanceof Prezentacija){
            ((Prezentacija)zaBrisanje).obrisiSvuda();
        }
        ((RuNodeComposite)parent).removeChild(zaBrisanje);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        MainFrame.getInstance().getTree().expandTree();
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)parent).addChild(zaBrisanje);
        if(zaBrisanje instanceof Prezentacija){
            for(Projekat p:projekti){
                p.addChild(zaBrisanje);
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        MainFrame.getInstance().getTree().expandTree();
    }
}
