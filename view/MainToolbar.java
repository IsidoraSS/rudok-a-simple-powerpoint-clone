package view;

import javax.swing.*;


public class MainToolbar extends JToolBar {

    public MainToolbar(){
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getPromeniAutoraAction());
        add(MainFrame.getInstance().getActionManager().getPromeniPozadinuAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
    }
}
