package controller.state.GraphicsState;

public class GraphicsStateManager {
    private GraphicsState trenutnoStanje;
    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;
    private MoveSlotState moveSlotState;
    private SelectSlotState selectSlotState;

    public GraphicsStateManager() {
        this.addSlotState = new AddSlotState();
        this.deleteSlotState = new DeleteSlotState();
        this.moveSlotState = new MoveSlotState();
        this.selectSlotState = new SelectSlotState();
        trenutnoStanje=addSlotState;
    }

    public GraphicsState getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setAddSlotState() {
        this.trenutnoStanje = addSlotState;
    }

    public void setDeleteSlotState() {
        this.trenutnoStanje = deleteSlotState;
    }

    public void setMoveSlotState() {
        this.trenutnoStanje = moveSlotState;
    }

    public void setSelectSlotState() {
        this.trenutnoStanje = selectSlotState;
    }
}
