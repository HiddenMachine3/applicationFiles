package Misc;

import java.io.File;
import java.net.URISyntaxException;

public class UtilityFunctions {
    public static File jarDirectory;

    static {
        try {
            jarDirectory = new File(UtilityFunctions.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getFile(String path) {
        return new File(jarDirectory.getAbsolutePath() + "/" + path);
    }
}
