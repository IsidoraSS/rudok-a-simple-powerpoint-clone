package controller;

import controller.command.NewCommand;
import controller.factory.AbstractFactory;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.Workspace;
import view.error.ErrorFactory;
import view.error.Greske;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static controller.factory.FactoryGen.returnNodeFactory;

public class NewAction extends AbstractRudokAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/newIcon.png"));
        putValue(NAME,"New");
        putValue(SHORT_DESCRIPTION,"Napravi novi file");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuTreeNode o=(RuTreeNode) MainFrame.getInstance().getSelectedNode();
        /*if(o!=null){
            if(!(o.getCvor() instanceof Slajd)){
                AbstractFactory abstractFactory=returnNodeFactory(o);
                o.addChild(abstractFactory.vratiCvor(o.getCvor()));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
                MainFrame.getInstance().getTree().expandTree();
            }
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);*/
        if(o!=null){
            MainFrame.getInstance().getCommandManager().addCommand(new NewCommand((RuTreeNode) o));
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
            MainFrame.getInstance().getTree().expandTree();
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);
    }

}
