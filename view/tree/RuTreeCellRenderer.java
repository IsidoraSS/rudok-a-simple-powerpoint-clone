package view.tree;

import lombok.SneakyThrows;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    @SneakyThrows
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

        //RuTreeNode ruTreeNode=(RuTreeNode) value;
        //RuNode instanca=ruTreeNode.getCvor();
        if (value instanceof Workspace) {
            URL imageURL=getClass().getResource("../../slike/projekatIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Projekat) {
            URL imageURL = getClass().getResource("../../slike/projekatIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Prezentacija) {
            URL imageURL = getClass().getResource("../../slike/prezentacijaIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Slajd) {
            URL imageURL = getClass().getResource("../../slike/slajdIcon.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        }
        return this;
    }

    @Override
    public Color getBackgroundNonSelectionColor() {
        return (null);
    }

    @Override
    public Color getBackgroundSelectionColor() {
        return (null);
    }

    @Override
    public Color getBackground() {
        return (null);
    }

}
