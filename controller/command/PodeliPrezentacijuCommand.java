package controller.command;

import model.Prezentacija;
import model.Projekat;

public class PodeliPrezentacijuCommand extends AbstractCommand{

    Prezentacija zaDeljenje;
    Projekat projekatZaDeljenje;

    public PodeliPrezentacijuCommand(Prezentacija zaDeljenje, Projekat projekatZaDeljenje) {
        this.zaDeljenje = zaDeljenje;
        this.projekatZaDeljenje = projekatZaDeljenje;
    }

    @Override
    public void doCommand() {
        zaDeljenje.podeliPrezentaciju(projekatZaDeljenje);
    }

    @Override
    public void undoCommand() {
        zaDeljenje.obrisiIzJednog(projekatZaDeljenje);
    }
}
