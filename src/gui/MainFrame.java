package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Optional;

public class MainFrame extends JFrame {
    private JButton btnChooseFile;
    private JFileChooser fileChooser;
    private JButton btnRunTests;

    public MainFrame(){
        initGui();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initGui() {
        setLayout(new GridLayout(2,2));

        btnChooseFile = new JButton("Choose file");
        btnChooseFile.addActionListener(e -> saveToFile());
        btnRunTests = new JButton("Run tests");

        add(btnChooseFile);
        add(btnRunTests);

        pack();
    }

    private void saveToFile(){
        fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(btnChooseFile);
        System.out.println(retval);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream("./testing/" + file.getName());

                byte[] buffer = new byte[1024];
                int length;

                while ((length = fis.read(buffer)) > 0) {

                    fos.write(buffer, 0, length);
                }
            }catch (Exception e){e.printStackTrace();}
        }
    }
}
