package controller.state.GraphicsState;

import model.Slajd;
import model.Slot;
import view.paneli.SlajdPanel;
import view.slot.SlotView;

public class SelectSlotState extends GraphicsState{
    @Override
    public void mousePressed(Slajd s, SlajdPanel sp, double x, double y) {
        Slot selektovani=null;
        for(Slot slot:s.getSlots()){
            if (slot.elementAt(x,y)){
                selektovani=slot;
            }
        }
        for(Slot slot:s.getSlots()){
            slot.deselektovan();
        }
        if(selektovani!=null)selektovani.selektovan();
        s.notifySubscribers(s);
    }

    @Override
    public void mouseReleased(Slajd s, SlajdPanel sp, double x, double y) {

    }

    @Override
    public void mouseDragged(Slajd s, SlajdPanel sp, double x, double y) {

    }
}
