package controller.factory;

import model.Prezentacija;
import model.Projekat;
import model.Workspace;
import view.tree.RuTreeNode;

public class FactoryGen {
    static ProjekatFactory projekatFactory = new ProjekatFactory();
    static PrezentacijaFactory prezentacijaFactory = new PrezentacijaFactory();
    static SlajdFactory slajdFactory = new SlajdFactory();

    public static AbstractFactory returnNodeFactory(RuTreeNode selectedNode){

        if (selectedNode.getCvor() instanceof Workspace) {
            return projekatFactory;
        }
        if (selectedNode.getCvor() instanceof Projekat) {
            return prezentacijaFactory;
        }
        if (selectedNode.getCvor() instanceof Prezentacija) {
            return slajdFactory;
        }
        return null;
    }
}
