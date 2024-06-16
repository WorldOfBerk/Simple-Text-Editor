package ui;

import file.FileOperations;
import file.FileOperationsImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NotepadWindow extends JFrame {

    private JTextArea textArea;
    private FileOperations fileOperations;

    public NotepadWindow() {

        setTitle("Notepad Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        fileOperations = new FileOperationsImpl(this, textArea);

        createMenuBar();
    }

    private void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> textArea.setText(""));

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(e -> fileOperations.openFile());

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> fileOperations.saveFile());

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.addActionListener(e -> fileOperations.saveFileAs());

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}
