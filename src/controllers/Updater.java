package controllers;

import Misc.UtilityFunctions;
import gui.customWindows.updatePage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import static com.threerings.getdown.util.LaunchUtil.updateVersionAndRelaunch;

public class Updater {

    boolean newUpdateFound = false;//default value
    String latestVersion = null, currentVersion = null;
    updatePage updateWindow;

    public void checkForUpdates() {
        currentVersion = getCurrentVersion();
        latestVersion = getLatestVersion();
        if (currentVersion != null && latestVersion != null && !latestVersion.equals(currentVersion)) {
            newUpdateFound = true;
        } else System.out.println("No update available");
    }

    private String getLatestVersion() {
        String text = null;
        try {
            text = new Scanner(UtilityFunctions.getFile("LatestVersion.txt")).nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found LatestVersion.txt!");
            newUpdateFound = false;
            return null;
        }
        return text;
    }

    private String getCurrentVersion() {
        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(UtilityFunctions.getFile("getdown.txt")));
            properties.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String currentVersion = (String) properties.get("version");
        System.out.println(currentVersion);
        return currentVersion;
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
            updateWindow.setVersions(currentVersion, latestVersion);
            updateWindow.start();
        }

    }

}
