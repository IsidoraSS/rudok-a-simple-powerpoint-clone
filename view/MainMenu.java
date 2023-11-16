package view;

import javax.swing.*;

public class MainMenu extends JMenuBar {
    public MainMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        JMenu helpMenu=new JMenu("Help");
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());
        this.add(fileMenu);
        this.add(helpMenu);
    }
}
