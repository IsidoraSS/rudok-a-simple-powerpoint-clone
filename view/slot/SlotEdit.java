package view.slot;

import model.Slot;
import model.SlotSadrzaj;
import model.SlotTip;
import view.MainFrame;
import view.tools.CustomColor;
import view.tools.SerializableStroke;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.MouseMotionListener;

public class SlotEdit extends JDialog{
    private Slot selektovaniSlot;
    private JTextPane textPane;
    private JDialog dialogZaTekst;

    private CustomColor[] boje={new CustomColor("#ed0c0c","Crvena"),new CustomColor("#0c0ced","Plava"),new CustomColor("#0ced10","Zelena"),
    new CustomColor("#ede90c", "Zuta"), new CustomColor("#630266", "Ljubicasta"), new CustomColor("#fa75e8","Roze"), new CustomColor("#ed5209","Narandzasta"),
    new CustomColor("#5e5d5c", "Siva"), new CustomColor("#ffffff", "Bela"), new CustomColor("#000000","Crna")};
    private String[] strokes={"Puna linija","Isprekidana linija"};

    private JPanel panelGore=new JPanel(new BorderLayout());
    private JPanel panelZaIzgled=new JPanel(new BorderLayout());
    private JComboBox comboBoxBoje=new JComboBox(boje);
    private JComboBox comboBoxStroke=new JComboBox(strokes);
    private JButton sacuvajIzgled=new JButton("Sacuvaj izgled slota");
    private JButton promeniTipTekst=new JButton("Promeni tip slota u tekstualni");
    private JButton promeniTipSlika=new JButton("Promeni tip slota u sliku");

    public SlotEdit(Slot selektovaniSlot) {
        super(MainFrame.getInstance(), "Uredi slot");
        this.setSize(MainFrame.getInstance().getWidth()/2,MainFrame.getInstance().getHeight()/3);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.selektovaniSlot=selektovaniSlot;

        panelGore.add(panelZaIzgled,BorderLayout.NORTH);

        sacuvajIzgled.setPreferredSize(new Dimension(200,35));
        sacuvajIzgled.addActionListener(e->sacuvajIzgled());
        panelGore.add(sacuvajIzgled,BorderLayout.SOUTH);

        this.add(panelGore,BorderLayout.NORTH);
        postaviComboboxBoje();
        postaviComboBoxStroke();

        promeniTipTekst.setPreferredSize(new Dimension(this.getWidth()/2,200));
        promeniTipTekst.addActionListener(e->promeniUTekst());
        promeniTipSlika.setPreferredSize(new Dimension(this.getWidth()/2,200));
        promeniTipSlika.addActionListener(e->promeniUSliku());
        this.add(promeniTipTekst,BorderLayout.WEST);
        this.add(promeniTipSlika,BorderLayout.EAST);
    }

    private void postaviComboboxBoje(){
        ComboBoxBojeRenderer renderer= new ComboBoxBojeRenderer();
        renderer.setPreferredSize(new Dimension(200, 30));
        comboBoxBoje.setRenderer(renderer);
        comboBoxBoje.setMaximumRowCount(3);
        panelZaIzgled.add(comboBoxBoje,BorderLayout.NORTH);
    }

    private void postaviComboBoxStroke(){
        panelZaIzgled.add(comboBoxStroke,BorderLayout.SOUTH);
    }




    class ComboBoxBojeRenderer extends JLabel implements ListCellRenderer{
        public ComboBoxBojeRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            //int selectedIndex = (int)value;
            ImageIcon ikonica=((CustomColor)value).getIkonica();
            String tekst=((CustomColor)value).getNaziv();
            setIcon(ikonica);
            setText(tekst);
            return this;
        }
    }

    public String getSelektovanaBoja(){
        return ((CustomColor)comboBoxBoje.getSelectedItem()).getHexValue();
    }

    public int getSelektovaniStroke(){
        return comboBoxStroke.getSelectedIndex();
    }

    private void sacuvajIzgled(){
        selektovaniSlot.setBoja(getSelektovanaBoja());
        if(getSelektovaniStroke()==0){
            BasicStroke bs=new BasicStroke(2.0f);
            SerializableStroke ss=new SerializableStroke(bs);
            selektovaniSlot.setLinija(ss);
        }
        else{
            //isprekidan
            float dash[] = { 10.0f };
            BasicStroke bs=new BasicStroke(2.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,3.0f,dash,0.0f);
            SerializableStroke ss=new SerializableStroke(bs);
            selektovaniSlot.setLinija(ss);
        }
    }

    private void promeniUTekst(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da promenite tip slota?", "Promena tipa slota u tekst", dialogButton);
        if(dialogResult == 0) {
            selektovaniSlot.setTip(SlotTip.TEKST);
            selektovaniSlot.setSadrzaj(new SlotSadrzaj(""));

            JButton sacuvajTekst=new JButton("Sacuvaj tekst slota");
            sacuvajTekst.addActionListener(e->sacuvajTekst());

            textPane=new JTextPane();
            JScrollPane scText=new JScrollPane(textPane);

            dialogZaTekst=new JDialog();
            dialogZaTekst.setSize(this.getWidth(),this.getHeight());
            dialogZaTekst.setLocationRelativeTo(null);
            dialogZaTekst.add(scText,BorderLayout.CENTER);
            dialogZaTekst.add(sacuvajTekst,BorderLayout.SOUTH);
            dialogZaTekst.setVisible(true);

            this.dispose();
        }
    }

    private void promeniUSliku(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da promenite tip slota?", "Promena tipa slota u sliku", dialogButton);
        if(dialogResult == 0) {
            selektovaniSlot.setTip(SlotTip.SLIKA);
            selektovaniSlot.setSadrzaj(new SlotSadrzaj(""));

            selektovaniSlot.setSadrzaj(new SlotSadrzaj("C://Users/IsidoraS/Desktop/testSlika.jpg"));
            //otvori panel za sliku
            this.dispose();
        }
    }

    private void sacuvajTekst(){
        selektovaniSlot.setSadrzaj(new SlotSadrzaj(textPane.getText()));
        dialogZaTekst.dispose();
    }

}
