package view.tree;

import model.RuNode;
import model.RuNodeComposite;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.*;

public class RuTreeNode implements MutableTreeNode {
    private RuNode cvor;

    public RuTreeNode(RuNode cvor) {
        this.cvor = cvor;
    }

    @Override
    public void insert(MutableTreeNode child, int index) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(MutableTreeNode node) {

    }

    @Override
    public void setUserObject(Object object) {

    }

    @Override
    public void removeFromParent() {
        RuNode roditelj=cvor.getParent();
        ((RuNodeComposite)roditelj).removeChild(cvor);
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        //TODO: error handling - workspace nema parent, slajd moze samo u prezentaciju itd... Factory?
        cvor.setParent((RuNode)newParent);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        List<RuNode> nodovi = ((RuNodeComposite) cvor).getChildren();
        RuNode ruNode = nodovi.get(childIndex);
        RuTreeNode treeNode = new RuTreeNode(ruNode);
        return treeNode;
    }

    @Override
    public int getChildCount() {
        if(cvor instanceof RuNodeComposite) return ((RuNodeComposite) cvor).getChildren().size();
        else return 0;
    }

    @Override
    public TreeNode getParent() {
        return (TreeNode)cvor.getParent();
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        if(cvor instanceof RuNodeComposite) return true;
        return false;
    }

    @Override
    public boolean isLeaf() {
        if(!(cvor instanceof RuNodeComposite)) return true;
        return false;
    }

    /*@Override
    public Enumeration<? extends TreeNode> children() {
        if(cvor instanceof RuNodeComposite) {
            return (Enumeration<? extends TreeNode>) ((RuNodeComposite) cvor).getChildren();
        }
        else return null;
    }*/

    @Override
    public Enumeration children() {
        if(cvor instanceof RuNodeComposite){
            Enumeration enumeration=Collections.enumeration(((RuNodeComposite) cvor).getChildren());
            return enumeration;
        }

        return null;
    }

    public void addChild(RuNode child){
        if(cvor instanceof RuNodeComposite){
            ((RuNodeComposite) cvor).addChild(child);
        }
    }

    public RuNode getCvor() {
        return cvor;
    }

    @Override
    public String toString() {
        return cvor.getNaziv();
    }
}
