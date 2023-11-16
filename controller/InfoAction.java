package controller;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class InfoAction extends AbstractRudokAction{

    public InfoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/infoIcon.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION,"Informacije o studentu");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), "Isidora Stošić RN109/21");
    }
}
