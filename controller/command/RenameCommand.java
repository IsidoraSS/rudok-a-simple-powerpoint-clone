package controller.command;

import model.RuNode;

public class RenameCommand extends AbstractCommand{

    private RuNode zaPreimenovanje;
    private String stariNaziv;
    private String noviNaziv;

    public RenameCommand(RuNode zaPreimenovanje, String noviNaziv) {
        this.zaPreimenovanje = zaPreimenovanje;
        this.noviNaziv = noviNaziv;
        this.stariNaziv=zaPreimenovanje.getNaziv();
    }

    @Override
    public void doCommand() {
        zaPreimenovanje.setNaziv(noviNaziv);
    }

    @Override
    public void undoCommand() {
        zaPreimenovanje.setNaziv(stariNaziv);
    }
}
