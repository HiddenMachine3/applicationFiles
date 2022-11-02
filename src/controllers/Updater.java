package controllers;

import gui.customWindows.updatePage;

public class Updater {

    boolean updateNecessary = false;//default value
    String latestVersion = "";

    public void checkForUpdates() {
        //do something
    }

    public void performRoutine() {
        checkForUpdates();
        if (updateNecessary) {
            new updatePage(
                    downloadAction -> {
                        //todo: use getdownUtils to restart getdown(it makes the version.txt file by itself and relauches getdown)
                    },
                    cancelAction -> {
                        System.exit(1);
                    });
        }

    }

}
