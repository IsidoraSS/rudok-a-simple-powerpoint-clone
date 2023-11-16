package controller.state.GraphicsState;

import model.Slajd;
import model.Slot;
import view.paneli.SlajdPanel;
import view.slot.SlotView;

import java.awt.*;

public class MoveSlotState extends GraphicsState{
    private Slot zaPomeranje=null;
    @Override
    public void mousePressed(Slajd s, SlajdPanel sp, double x, double y) {
        for(Slot slot:s.getSlots()){
            if (slot.elementAt(x,y)){
                zaPomeranje=slot;
            }
        }
    }

    @Override
    public void mouseReleased(Slajd s, SlajdPanel sp, double x, double y) {
        zaPomeranje=null;
    }

    @Override
    public void mouseDragged(Slajd s, SlajdPanel sp, double x, double y) {
        if(zaPomeranje!=null){
            zaPomeranje.setPozicija(new Point((int)x,(int)y));
            s.notifySubscribers(s);
        }
    }
}
