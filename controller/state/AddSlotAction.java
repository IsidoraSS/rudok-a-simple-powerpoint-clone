package controller.state;

import controller.AbstractRudokAction;
import controller.state.SEState.EditState;
import view.MainFrame;
import view.paneli.PrezentacijaTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddSlotAction extends AbstractRudokAction {
    public AddSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../../slike/addSlotIcon.png"));
        putValue(NAME,"Dodaj slot");
        putValue(SHORT_DESCRIPTION,"Dodaj slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTabPane().getSelectedComponent()!=null){
            PrezentacijaTab selektovanaPrezentaijca=(PrezentacijaTab) MainFrame.getInstance().getTabPane().getSelectedComponent();
            selektovanaPrezentaijca.promeniStanjeUAddSlot();
        }
    }
}
