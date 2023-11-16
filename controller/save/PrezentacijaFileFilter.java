package controller.save;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PrezentacijaFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".pre"));
    }

    @Override
    public String getDescription() {
        return "RuDok Presentation Files (*.pre)";
    }
}
