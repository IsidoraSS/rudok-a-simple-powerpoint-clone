package view.tree;

import model.Prezentacija;
import model.Projekat;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RuTree extends JTree {
    public RuTree() {
        //addTreeSelectionListener(new WorkspaceTreeController());
        setCellEditor(new RuTreeCellEditor(this,new RuTreeCellRenderer()));
        setCellRenderer(new RuTreeCellRenderer());
        setEditable(true);
        setBackground(new Color(238, 238, 238));
        setToggleClickCount(0);
        MouseListener mouseListener=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2 && ((RuTreeNode) MainFrame.getInstance().getSelectedNode()).getCvor() instanceof Projekat){
                    MainFrame.getInstance().dodeliProjekatWorkspacePanelu((Projekat)(((RuTreeNode)MainFrame.getInstance().getSelectedNode()).getCvor()));
                }
                if (SwingUtilities.isRightMouseButton(e) && ((RuTreeNode) MainFrame.getInstance().getSelectedNode()).getCvor() instanceof Prezentacija) {
                    JPopupMenu popup = new JPopupMenu();
                    popup.add(MainFrame.getInstance().getActionManager().getPodeliPrezentacijuAction());
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        };
        this.addMouseListener(mouseListener);
    }



    public void expandTree(){
        for(int i=0;i<this.getRowCount();i++)
        {
            this.expandRow(i);
        }
    }

}
