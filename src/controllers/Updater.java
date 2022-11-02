package controllers;

import Misc.UtilityFunctions;
import gui.customWindows.updatePage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.threerings.getdown.util.LaunchUtil.updateVersionAndRelaunch;

public class Updater {

    boolean updateNecessary = true;//default value
    String latestVersion = "";

    public void checkForUpdates() {
        try {
            latestVersion = new Scanner(UtilityFunctions.getFile("LatestVersion.txt")).nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found LatestVersion.txt!");
            updateNecessary = true;
        }
    }

    public void performRoutine() {
        checkForUpdates();
        if (updateNecessary) {
            new updatePage(
                    downloadAction -> {
                        //todo: use getdownUtils to restart getdown(it makes the version.txt file by itself and relauches getdown)
                        try {
                            updateVersionAndRelaunch(UtilityFunctions.getFile(""), "getdown.jar", latestVersion, "");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    },
                    cancelAction -> {
                        System.exit(1);
                    }).start();
        }

    }

}
