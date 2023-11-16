package controller.save;

import controller.AbstractRudokAction;
import model.Projekat;
import view.MainFrame;
import view.error.ErrorFactory;
import view.error.Greske;
import view.tools.Serijalizacija;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveAction extends AbstractRudokAction {
    public SaveAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/saveIcon.png"));
        putValue(NAME,"Save");
        putValue(SHORT_DESCRIPTION,"Save");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuTreeNode o=(RuTreeNode) MainFrame.getInstance().getSelectedNode();
        if(o!=null){
            if(o.getCvor() instanceof Projekat){
                Serijalizacija.saveProject((Projekat) o.getCvor());
            }
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);
    }
}
