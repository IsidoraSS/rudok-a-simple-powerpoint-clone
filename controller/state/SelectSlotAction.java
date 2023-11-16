package controller.state;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.paneli.PrezentacijaTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectSlotAction extends AbstractRudokAction {
    public SelectSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../../slike/selectSlotIcon.png"));
        putValue(NAME,"Selektuj slot");
        putValue(SHORT_DESCRIPTION,"Selektuj slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTabPane().getSelectedComponent()!=null){
            PrezentacijaTab selektovanaPrezentaijca=(PrezentacijaTab) MainFrame.getInstance().getTabPane().getSelectedComponent();
            selektovanaPrezentaijca.promeniStanjeUSelectSlot();
        }
    }
}
