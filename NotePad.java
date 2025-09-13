import javax.swing.*;
import java.awt.*;
import java.io.*;
public class NotePad {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Notepad\nCreated by: Shenuri\nID: s16661",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        helpMenu.add(aboutItem);

        JFileChooser chooser = new JFileChooser();

        openItem.addActionListener(e -> {
            int choice = chooser.showOpenDialog(frame);
            if (choice == JFileChooser.APPROVE_OPTION) {
                try {
                    FileReader fr = new FileReader(chooser.getSelectedFile());
                    textArea.read(fr, null);
                    fr.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error opening file!");
                }
            }
        });

        saveItem.addActionListener(e -> {
            int choice = chooser.showSaveDialog(frame);
            if (choice == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter fw = new FileWriter(chooser.getSelectedFile());
                    textArea.write(fw);
                    fw.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file!");
                }
            }
        });

        exitItem.addActionListener(e -> System.exit(0));

        cutItem.addActionListener(e -> textArea.cut());
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());


        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }
}
