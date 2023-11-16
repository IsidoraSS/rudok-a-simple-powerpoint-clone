package view.tree;

import model.Workspace;

import javax.swing.tree.DefaultTreeModel;

public class RuTreeModel extends DefaultTreeModel {
    public RuTreeModel(Workspace root) {
        super(new RuTreeNode(root));
    }

}
