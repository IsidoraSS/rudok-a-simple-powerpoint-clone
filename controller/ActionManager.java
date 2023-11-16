package controller;
import controller.save.OpenAction;
import controller.save.SaveAction;
import controller.state.*;
import lombok.Getter;
import lombok.Setter;
import model.Slot;

@Getter
@Setter
public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private DeleteAction deleteAction;
    private PromeniAutoraAction promeniAutoraAction;
    private PromeniPozadinuAction promeniPozadinuAction;
    private SEAction seAction;
    private AddSlotAction addSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private MoveSlotAction moveSlotAction;
    private SelectSlotAction selectSlotAction;
    private SlotEditAction slotEditAction;
    private PodeliPrezentacijuAction podeliPrezentacijuAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveAction saveAction;
    private OpenAction openAction;

    public ActionManager(){
        inicijalizujAkcije();
    }

    private void inicijalizujAkcije() {
        infoAction=new InfoAction();
        newAction=new NewAction();
        deleteAction=new DeleteAction();
        promeniAutoraAction=new PromeniAutoraAction();
        promeniPozadinuAction=new PromeniPozadinuAction();
        seAction=new SEAction();
        addSlotAction=new AddSlotAction();
        deleteSlotAction=new DeleteSlotAction();
        moveSlotAction=new MoveSlotAction();
        selectSlotAction=new SelectSlotAction();
        slotEditAction=new SlotEditAction();
        podeliPrezentacijuAction=new PodeliPrezentacijuAction();
        undoAction=new UndoAction();
        redoAction=new RedoAction();
        saveAction=new SaveAction();
        openAction=new OpenAction();
    }

}
