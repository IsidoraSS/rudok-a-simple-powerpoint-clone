package controller;
import controller.command.PodeliPrezentacijuCommand;
import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PodeliPrezentacijuAction extends AbstractRudokAction{
    public PodeliPrezentacijuAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/editSlotIcon.png"));
        putValue(NAME,"Podeli prezentaciju");
        putValue(SHORT_DESCRIPTION,"Podeli prezentaciju");
    }

    JComboBox projekti;
    Prezentacija selektovanaPrezentacija;

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<RuNode> listaProjekata=MainFrame.getInstance().getWorkspace().getChildren();
        selektovanaPrezentacija=(Prezentacija) ((RuTreeNode)MainFrame.getInstance().getSelectedNode()).getCvor();
        projekti=new JComboBox(listaProjekata.toArray());

        JDialog izaberiProjekat=new JDialog();
        izaberiProjekat.setSize(200,100);
        izaberiProjekat.setLocationRelativeTo(null);

        izaberiProjekat.add(projekti,BorderLayout.NORTH);

        JButton podeli=new JButton("Podeli prezentaciju");
        podeli.addActionListener(m->podeliPrez());

        izaberiProjekat.add(podeli,BorderLayout.SOUTH);
        izaberiProjekat.setVisible(true);
    }

    private void podeliPrez(){
        Projekat selektovaniProjekat=(Projekat) projekti.getSelectedItem();
        //selektovanaPrezentacija.podeliPrezentaciju(selektovaniProjekat);
        MainFrame.getInstance().getCommandManager().addCommand(new PodeliPrezentacijuCommand(selektovanaPrezentacija,selektovaniProjekat));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        MainFrame.getInstance().getTree().expandTree();
    }

}
