package view.tree;

import model.Workspace;
import view.tree.RuTree;
import view.tree.RuTreeModel;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    RuTree stablo;
    RuTreeModel ruTreeModel;
    Workspace workspace;

    public TreePanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        inicijalizujStablo();
        add(stablo);
    }

    public void inicijalizujStablo(){
        this.stablo=new RuTree();
        this.workspace=new Workspace();
        this.ruTreeModel =new RuTreeModel(workspace);
        this.stablo.setModel(ruTreeModel);
    }

    public RuTree getStablo() {
        return stablo;
    }

    public RuTreeModel getModel(){
        return ruTreeModel;
    }

    public Workspace getWorkspace() {
        return workspace;
    }
}
