package controller.state.SEState;

import javax.swing.*;
import java.awt.*;

public class SlideshowState implements SEState {
    @Override
    public void prikaziPanel(JPanel glavni, JScrollPane levo, JScrollPane desno, JPanel preview, JPanel toolbarEdit, JPanel toolbarSlideshow) {
        glavni.remove(levo);
        glavni.remove(desno);
        glavni.remove(toolbarEdit);
        glavni.add(toolbarSlideshow,BorderLayout.NORTH);
        glavni.add(preview, BorderLayout.CENTER);
    }
}
