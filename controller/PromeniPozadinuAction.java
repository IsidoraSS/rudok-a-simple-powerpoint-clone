package controller;

import model.Prezentacija;
import view.error.ErrorFactory;
import view.error.Greske;
import view.MainFrame;
import view.tree.RuTreeNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;

public class PromeniPozadinuAction extends AbstractRudokAction{
    public PromeniPozadinuAction(){
        putValue(SMALL_ICON,ucitajIkonicu("../slike/promenipozadinuIcon.png"));
        putValue(NAME,"Promeni pozadinu");
        putValue(SHORT_DESCRIPTION,"Promeni pozadinsku sliku");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o= MainFrame.getInstance().getSelectedNode();
        if(o!=null){
            if(((RuTreeNode)o).getCvor() instanceof Prezentacija){
                String path=vratiPath();
                if(!path.equals("-"))((Prezentacija)(((RuTreeNode)o).getCvor())).setPozadinskaSlika(path);
            }
            else ErrorFactory.getInstance().izbaciGresku(Greske.PREZENTACIJA_SLIKA);
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.NODE_NIJE_SELEKTOVAN);

    }

    private String vratiPath(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("C://"));
        chooser.setDialogTitle("Izaberi sliku");
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(imageFilter);
        chooser.showOpenDialog(null);
        String path="-";
        if(chooser.getSelectedFile()!=null)path=chooser.getSelectedFile().toString();
        return path;
    }

}
