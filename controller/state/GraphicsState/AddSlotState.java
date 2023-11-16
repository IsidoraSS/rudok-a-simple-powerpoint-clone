package controller.state.GraphicsState;

import model.Slajd;
import model.Slot;
import view.paneli.SlajdPanel;
import view.slot.SlotView;
import view.tools.SerializableStroke;

import java.awt.*;

public class AddSlotState extends GraphicsState{
    @Override
    public void mousePressed(Slajd s, SlajdPanel sp, double x, double y) {
        Paint fill = new Color(255,255,255);
        Point position=new Point((int)x,(int)y);
        Slot slot = new Slot(fill,new SerializableStroke(new BasicStroke(2f)),"","",new Dimension(100,50),position);
        slot.setNaziv("Slot " + s.getSlots().size()+1);
        s.addSlots(slot);
        SlotView sw=new SlotView(slot);

        sp.dodajSlotView(sw);
    }

    @Override
    public void mouseReleased(Slajd s, SlajdPanel sp, double x, double y) {

    }

    @Override
    public void mouseDragged(Slajd s, SlajdPanel sp, double x, double y) {

    }
}
