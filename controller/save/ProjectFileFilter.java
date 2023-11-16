package controller.save;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".prj"));
    }

    @Override
    public String getDescription() {
        return "RuDok Project Files (*.prj)";
    }
}
