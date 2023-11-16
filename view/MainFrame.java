package view;

import controller.ActionManager;
import controller.command.CommandManager;
import model.*;
import view.paneli.PrezentacijaTab;
import view.paneli.ProjekatPanel;
import view.paneli.TabPane;
import view.paneli.WorkspacePanel;
import view.tree.RuTree;
import view.tree.RuTreeModel;
import view.tree.RuTreeNode;
import view.tree.TreePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame mainFrame=null;
    private ActionManager actionManager;
    private TreePanel treePanel;
    private WorkspacePanel workspacePanel;
    private MainToolbar tb;
    private MainMenu mm;
    private CommandManager commandManager;

    private MainFrame(){
    }
    private void initialise(){
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension velicinaEkarana=kit.getScreenSize();
        int sirinaEkrana=velicinaEkarana.width;
        int visinaEkarana=velicinaEkarana.height;
        actionManager=new ActionManager();
        setSize(sirinaEkrana*2/3,visinaEkarana*2/3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("RuDok");

        commandManager=new CommandManager();

        mm=new MainMenu();
        setJMenuBar(mm);

        tb=new MainToolbar();
        this.add(tb,BorderLayout.NORTH);

        namestiPanele();

        setVisible(true);
    }
    public static MainFrame getInstance(){
        if(mainFrame==null){
            mainFrame=new MainFrame();
            mainFrame.initialise();
        }
        return mainFrame;
    }

    private void namestiPanele(){
        treePanel=new TreePanel();
        workspacePanel=new WorkspacePanel();
        JScrollPane scrollPane=new JScrollPane(treePanel);
        scrollPane.setMinimumSize(new Dimension(200,200));
        JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,workspacePanel);
        splitPane.setDividerLocation(200);
        this.add(splitPane,BorderLayout.CENTER);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public Object getSelectedNode() {
        return this.getTree().getLastSelectedPathComponent();
    }

    public RuTree getTree(){
        return this.treePanel.getStablo();
    }

    public Workspace getWorkspace(){
        return this.treePanel.getWorkspace();
    }

    public RuTreeModel getModel(){
        return this.treePanel.getModel();
    }

    public void dodeliProjekatWorkspacePanelu(Projekat projekat) {
        workspacePanel.setProjekat(projekat);
    }

    public TabPane getTabPane(){
        return workspacePanel.getTabPane();
    }

    public Prezentacija vratiOtvorenuPrezentaciju(){
        return ((PrezentacijaTab)getTabPane().getSelectedComponent()).getPrezentacijaModel();
    }

    public Slot vratiSelektovaniSlot(){
        Slot selektovanislot=null;
        Petlja:{
            for(RuNode rS: vratiOtvorenuPrezentaciju().getChildren()){
                Slajd s=(Slajd)rS;
                for(Slot slot:s.getSlots()){
                    if(slot.isSelected()==true){
                        selektovanislot=slot;
                        break Petlja;
                    }
                }
            }
        }

        return selektovanislot;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void dodajProjekat(Projekat projekat){
        treePanel.getWorkspace().addChild(projekat);
        projekat.setParent(treePanel.getWorkspace());
    }
}
