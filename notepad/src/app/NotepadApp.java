package app;

import ui.NotepadWindow;

import javax.swing.*;

public class NotepadApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadWindow window = new NotepadWindow();
            window.setVisible(true);
        });
    }
}
