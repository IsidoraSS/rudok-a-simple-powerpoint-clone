package controller.state.SEState;

import javax.swing.*;
import java.awt.*;

public class EditState implements SEState {
    @Override
    public void prikaziPanel(JPanel glavni, JScrollPane levo, JScrollPane desno, JPanel preview, JPanel toolbarEdit, JPanel toolbarSlideshow) {
        glavni.remove(preview);
        glavni.remove(toolbarSlideshow);
        glavni.add(toolbarEdit,BorderLayout.NORTH);
        glavni.add(levo,BorderLayout.WEST);
        glavni.add(desno, BorderLayout.CENTER);
    }
}
