package view.tools;

import controller.save.ProjectFileFilter;
import model.Projekat;
import view.MainFrame;

import javax.swing.*;
import java.io.*;

public class Serijalizacija {

    public static void saveProject(Projekat projekat){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setFileFilter(new ProjectFileFilter());
        File projekatFile=projekat.getProjekatFile();

        if(projekat.jePromenjen()==true){
            return;
        }

        if(projekat.getProjekatFile()==null){
            if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                projekatFile=fileChooser.getSelectedFile();
            }else{
                return;
            }
        }

        ObjectOutputStream os;
        try{
            os=new ObjectOutputStream(new FileOutputStream(projekatFile));
            os.writeObject(projekat);
            projekat.setProjekatFile(projekatFile);
            projekat.setPromenjen(false);
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (IOException e1){
            e1.printStackTrace();
        }
    }

    public static void openProject(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new ProjectFileFilter());

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile()));
                Projekat projekat = null;
                try {
                    projekat = (Projekat) objectInputStream.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                MainFrame.getInstance().dodajProjekat(projekat);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
            MainFrame.getInstance().getTree().expandTree();
        }
    }


}
