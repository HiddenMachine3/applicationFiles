package controllers;

import Misc.UtilityFunctions;
import gui.customWindows.updatePage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.threerings.getdown.util.LaunchUtil.updateVersionAndRelaunch;

public class Updater {

    boolean newUpdateFound = true;//default value
    String latestVersion = "";
    updatePage updateWindow;

    public void checkForUpdates() {
        try {
            latestVersion = new Scanner(UtilityFunctions.getFile("LatestVersion.txt")).nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found LatestVersion.txt!");
            newUpdateFound = false;
        }
    }

    public void performRoutine() {
        checkForUpdates();
        if (newUpdateFound) {
            updateWindow = new updatePage(
                    downloadAction -> {
                        try {
                            updateVersionAndRelaunch(UtilityFunctions.getFile(""), "getdown.jar", latestVersion, "");
                            System.exit(1);//exit current application
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    },
                    cancelAction -> {
                        updateWindow.delete();
                    });
            updateWindow.start();
        }

    }

}
