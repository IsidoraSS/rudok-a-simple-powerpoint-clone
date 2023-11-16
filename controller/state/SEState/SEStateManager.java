package controller.state.SEState;

public class SEStateManager {
    private SEState trenutnoStanje;
    private SlideshowState slideshowState;
    private EditState editState;

    public SEStateManager(){
        editState=new EditState();
        slideshowState=new SlideshowState();
        trenutnoStanje=editState;
    }

    public SEState getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setSlideshowState() {
        trenutnoStanje=slideshowState;
    }

    public void setEditState() {
        trenutnoStanje = editState;
    }
}
