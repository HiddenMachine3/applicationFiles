import backend.spring.config.AppConfig;
import backend.spring.dao.testDAO;
import controllers.Updater;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public void something() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        testDAO tdao = context.getBean(testDAO.class);

        tdao.printA();
        System.out.println("Test");

        JFrame frame = new JFrame("A great shining beginning 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        Updater updater = new Updater();
        updater.performRoutine();
    }

    public static void main(String[] args) {
        new Main().something();
    }

}
