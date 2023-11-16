package controller;

import model.Prezentacija;
import view.error.ErrorFactory;
import view.error.Greske;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PromeniAutoraAction extends AbstractRudokAction{
    public PromeniAutoraAction(){
        putValue(SMALL_ICON,ucitajIkonicu("../slike/promeniautoraIcon.png"));
        putValue(NAME,"Promeni autora");
        putValue(SHORT_DESCRIPTION,"Promeni autora prezentacije");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o= MainFrame.getInstance().getSelectedNode();
        if(o!=null){
            if(((RuTreeNode)o).getCvor() instanceof Prezentacija){
                String autor=JOptionPane.showInputDialog("Unesite ime autora");
                if(autor!=null){
                    ((Prezentacija)(((RuTreeNode)o).getCvor())).setAutor(autor);
                }
            }
            else ErrorFactory.getInstance().izbaciGresku(Greske.PREZENTACIJA_AUTOR);
        }
        else{
            ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);
        }

    }
}
