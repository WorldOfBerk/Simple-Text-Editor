package file;

import javax.swing.*;
import java.io.File;

public class FileOperationsImpl implements FileOperations{

    private JFrame jFrame;
    private JTextArea textArea;
    private File currentFile;

    public FileOperationsImpl(JFrame jFrame, JTextArea textArea) {
        this.jFrame = jFrame;
        this.textArea = textArea;
    }


    @Override
    public void openFile() {

    }

    @Override
    public void saveFile() {

    }

    @Override
    public void saveFileAs() {

    }
}
