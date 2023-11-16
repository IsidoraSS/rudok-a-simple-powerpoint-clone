package controller;

import controller.command.DeleteCommand;
import controller.command.NewCommand;
import model.Prezentacija;
import model.Workspace;
import view.error.ErrorFactory;
import view.error.Greske;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/deleteIcon.png"));
        putValue(NAME,"Delete");
        putValue(SHORT_DESCRIPTION,"Obriši file");
    }

    public void actionPerformed(ActionEvent e) {
        Object o= MainFrame.getInstance().getSelectedNode();
        /*if(o!=null){
            if(!(((RuTreeNode)o).getCvor() instanceof Workspace)){
                if((((RuTreeNode)o).getCvor() instanceof Prezentacija)){
                    ((Prezentacija) ((RuTreeNode) o).getCvor()).obrisiSvuda();
                }
                ((RuTreeNode)o).removeFromParent();
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
                MainFrame.getInstance().getTree().expandTree();
            }
            else ErrorFactory.getInstance().izbaciGresku(Greske.WORKSPACE_BRISANJE);
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);*/
        if(o!=null){
            if(!(((RuTreeNode)o).getCvor() instanceof Workspace)){
                MainFrame.getInstance().getCommandManager().addCommand(new DeleteCommand(((RuTreeNode)o).getCvor()));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
                MainFrame.getInstance().getTree().expandTree();
            }
            else ErrorFactory.getInstance().izbaciGresku(Greske.WORKSPACE_BRISANJE);
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);
    }

}
