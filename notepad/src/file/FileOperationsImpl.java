package file;

import javax.swing.*;
import java.io.*;

public class FileOperationsImpl implements FileOperations{

    private JFrame frame;
    private JTextArea textArea;
    private File currentFile;

    public FileOperationsImpl(JFrame frame, JTextArea textArea) {
        this.frame = frame;
        this.textArea = textArea;
    }


    @Override
    public void openFile() {

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(currentFile))){
                textArea.read(reader, null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "File could not be opened!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void saveFile() {
        if (currentFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                textArea.write(writer);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "File could not be saved.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            saveFileAs();
        }
    }

    @Override
    public void saveFileAs() {

    }
}
