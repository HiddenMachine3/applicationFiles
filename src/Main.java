import controllers.Updater;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test");

        JFrame frame = new JFrame("release version test");//System.getProperty("java.class.path"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        Updater updater = new Updater();
        updater.performRoutine();
    }

}
