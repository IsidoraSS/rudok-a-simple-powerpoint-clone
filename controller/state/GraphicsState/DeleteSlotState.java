package controller.state.GraphicsState;

import model.Slajd;
import model.Slot;
import view.paneli.SlajdPanel;
import view.slot.SlotView;

public class DeleteSlotState extends GraphicsState{
    @Override
    public void mousePressed(Slajd s, SlajdPanel sp, double x, double y) {
        Slot zaBrisanje=null;
        for(Slot slot:s.getSlots()){
            if (slot.elementAt(x,y)){
                zaBrisanje=slot;
            }
        }
        if (zaBrisanje!=null)s.removeSlot(zaBrisanje);

    }

    @Override
    public void mouseReleased(Slajd s, SlajdPanel sp, double x, double y) {

    }

    @Override
    public void mouseDragged(Slajd s, SlajdPanel sp, double x, double y) {

    }
}
