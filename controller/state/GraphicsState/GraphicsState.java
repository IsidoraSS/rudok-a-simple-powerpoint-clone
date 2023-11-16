package controller.state.GraphicsState;

import model.Slajd;
import model.Slot;
import view.paneli.SlajdPanel;
import view.slot.SlotView;

public abstract class GraphicsState {
    public abstract void mousePressed(Slajd s, SlajdPanel sp, double x, double y);
    public abstract void mouseReleased(Slajd s, SlajdPanel sp, double x, double y);
    public abstract void mouseDragged(Slajd s, SlajdPanel sp, double x, double y);
}
