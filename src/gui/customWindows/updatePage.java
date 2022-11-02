package gui.customWindows;

import javax.swing.*;
import java.awt.event.ActionListener;

public class updatePage {
    private JButton downloadNewVersionButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    public updatePage(ActionListener downloadAction, ActionListener cancelAction) {
        downloadNewVersionButton.addActionListener(downloadAction);
        cancelButton.addActionListener(cancelAction);
    }

    public void start(){
        JFrame frame = new JFrame("Updater");

        frame.add(mainPanel);
        frame.pack();
        frame.setUndecorated(false);

        frame.setVisible(true);
    }
}
