package model;

import java.io.Serializable;

public class SlotSadrzaj implements Serializable {
    String sadrzaj;

    public SlotSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public SlotSadrzaj() {
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
