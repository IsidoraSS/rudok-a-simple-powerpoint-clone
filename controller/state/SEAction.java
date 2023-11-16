package controller.state;

import controller.AbstractRudokAction;
import controller.state.SEState.EditState;
import view.MainFrame;
import view.paneli.PrezentacijaTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SEAction extends AbstractRudokAction {

    public SEAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,ucitajIkonicu("../../slike/seIcon.png"));
        putValue(NAME,"Izmeni/pogledaj prezentaciju");
        putValue(SHORT_DESCRIPTION,"Izmeni/pogledaj prezentaciju");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTabPane().getSelectedComponent()!=null){
            PrezentacijaTab selektovanaPrezentaijca=(PrezentacijaTab) MainFrame.getInstance().getTabPane().getSelectedComponent();
            if(selektovanaPrezentaijca.getTrenutnoEditStanje() instanceof EditState){
                selektovanaPrezentaijca.promeniStanjeUSlideshow();
            }
            else{
                selektovanaPrezentaijca.promeniStanjeUEdit();
            }
            selektovanaPrezentaijca.zameniPanele();
        }
    }
}
