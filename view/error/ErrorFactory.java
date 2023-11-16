package view.error;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ErrorFactory{

    private static ErrorFactory errorFactory=null;
    MainFrame root= MainFrame.getInstance();

    private ErrorFactory(){
    }

    public static ErrorFactory getInstance(){
        if(errorFactory==null){
            errorFactory=new ErrorFactory();
        }
        return errorFactory;
    }

    public void izbaciGresku(Greske greske){
        if(greske==Greske.WORKSPACE_BRISANJE){
            napraviError("Workspace ne može biti obrisan!");
        }
        else if(greske==Greske.WORKSPACE_NAZIV){
            napraviError("Workspace ne može biti preimenovan!");
        }
        else if(greske==Greske.NODE_NIJE_SELEKTOVAN){
            napraviError("Prvo morate selektovati čvor!");
        }
        else if(greske==Greske.PREZENTACIJA_AUTOR){
            napraviError("Možete menjati samo autora prezentacije!");
        }
        else if(greske==Greske.PREZENTACIJA_SLIKA){
            napraviError("Možete menjati samo pozadinsku sliku prezentacije!");
        }
        else if(greske==Greske.SLOT_NIJE_SELEKTOVAN){
            napraviError("Prvo morate selektovati slot!");
        }
    }

    private void napraviError(String errorString){
        JDialog popupDialog = new JDialog(root, "Error", true);
        JLabel popupLabel = new JLabel(errorString, SwingConstants.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        popupDialog.setSize(screenSize.width / 4, screenSize.height / 5);
        popupDialog.setLocationRelativeTo(null);
        popupDialog.add(popupLabel);
        popupDialog.setVisible(true);
    }



}
