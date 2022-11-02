package gui.customWindows;

import javax.swing.*;
import java.awt.event.ActionListener;

public class updatePage {
    private JButton downloadNewVersionButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    JFrame frame;

    public updatePage(ActionListener downloadAction, ActionListener cancelAction) {
        downloadNewVersionButton.addActionListener(downloadAction);
        cancelButton.addActionListener(cancelAction);
    }

    public void start() {
        frame = new JFrame("Updater");

        frame.add(mainPanel);
        frame.pack();
//        frame.setUndecorated(false);

        frame.setVisible(true);
    }

    public void delete() {
        frame.dispose();
    }
}
