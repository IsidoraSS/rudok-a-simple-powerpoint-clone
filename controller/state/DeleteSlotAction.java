package controller.state;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.paneli.PrezentacijaTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteSlotAction extends AbstractRudokAction {
    public DeleteSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../../slike/deleteSlotIcon.png"));
        putValue(NAME,"Obrisi slot");
        putValue(SHORT_DESCRIPTION,"Obrisi slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTabPane().getSelectedComponent()!=null){
            PrezentacijaTab selektovanaPrezentaijca=(PrezentacijaTab) MainFrame.getInstance().getTabPane().getSelectedComponent();
            selektovanaPrezentaijca.promeniStanjeUDeleteSlot();
        }
    }
}
