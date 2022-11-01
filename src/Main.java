import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test");

        JFrame frame = new JFrame("Yeah");//System.getProperty("java.class.path"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
