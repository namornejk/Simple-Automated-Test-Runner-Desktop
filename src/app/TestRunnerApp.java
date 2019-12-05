package app;

import javax.swing.*;
import gui.*;

public class TestRunnerApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

}