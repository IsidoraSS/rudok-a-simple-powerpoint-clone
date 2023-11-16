package view.tree;

import controller.command.PodeliPrezentacijuCommand;
import controller.command.RenameCommand;
import model.*;
import view.error.ErrorFactory;
import view.error.Greske;
import view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener{

    private Object stavka = null;
    private JTextField edit = null;

    public RuTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        stavka = arg1;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent) arg0).getClickCount() == 3){
                if(!(((RuTreeNode)(((RuTree)arg0.getSource()).getLastSelectedPathComponent())).getCvor() instanceof Workspace)){
                    return true;
                }
                ErrorFactory.getInstance().izbaciGresku(Greske.WORKSPACE_NAZIV);
            }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        RuNode cvor=((RuTreeNode) MainFrame.getInstance().getSelectedNode()).getCvor();
        if(!(cvor instanceof Workspace)){
            //cvor.setNaziv(e.getActionCommand());
            MainFrame.getInstance().getCommandManager().addCommand(new RenameCommand(cvor,e.getActionCommand()));
            MainFrame.getInstance().getTree().expandTree();
            MainFrame.getInstance().getTree().clearSelection();
        }
    }
}
