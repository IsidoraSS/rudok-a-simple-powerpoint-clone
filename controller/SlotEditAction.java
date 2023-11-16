package controller;

import model.Slot;
import view.MainFrame;
import view.error.ErrorFactory;
import view.error.Greske;
import view.slot.SlotEdit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SlotEditAction extends AbstractRudokAction{
    public SlotEditAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../slike/editSlotIcon.png"));
        putValue(NAME,"Izmeni slot");
        putValue(SHORT_DESCRIPTION,"Izmeni slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Slot selektovaniSlot= MainFrame.getInstance().vratiSelektovaniSlot();
        if(selektovaniSlot!=null){
            SlotEdit slotEdit=new SlotEdit(selektovaniSlot);
            slotEdit.setVisible(true);
        }
        else ErrorFactory.getInstance().izbaciGresku(Greske.SLOT_NIJE_SELEKTOVAN);
    }
}
