package controller.save;

import controller.AbstractRudokAction;
import controller.command.AbstractCommand;
import model.Workspace;
import view.MainFrame;
import view.error.ErrorFactory;
import view.error.Greske;
import view.tools.Serijalizacija;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class OpenAction extends AbstractRudokAction {
    public OpenAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/openIcon.png"));
        putValue(NAME,"Open");
        putValue(SHORT_DESCRIPTION,"Open");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        RuTreeNode o=(RuTreeNode) MainFrame.getInstance().getSelectedNode();
        if(o!=null){
            if(o.getCvor() instanceof Workspace){
                Serijalizacija.openProject();
            }
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);
    }
}
