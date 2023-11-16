package view.slot;

import model.Slajd;
import model.Slot;
import view.MainFrame;
import view.paneli.PrezentacijaTab;
import view.paneli.SlajdPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    private Slajd slajdModel;
    private SlajdPanel slajdPanel;

    public MouseController(Slajd slajdModel, SlajdPanel slajdPanel) {
        this.slajdModel = slajdModel;
        this.slajdPanel = slajdPanel;
    }

    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();
            ((PrezentacijaTab)MainFrame.getInstance().getTabPane().getSelectedComponent()).getTrenutnoGraphicsStanje().mousePressed(slajdModel,slajdPanel,position.getX(), position.getY());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point position = e.getPoint();
        ((PrezentacijaTab)MainFrame.getInstance().getTabPane().getSelectedComponent()).getTrenutnoGraphicsStanje().mouseDragged(slajdModel,slajdPanel,position.getX(), position.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point position = e.getPoint();
        ((PrezentacijaTab)MainFrame.getInstance().getTabPane().getSelectedComponent()).getTrenutnoGraphicsStanje().mouseReleased(slajdModel,slajdPanel,position.getX(), position.getY());
    }
}
