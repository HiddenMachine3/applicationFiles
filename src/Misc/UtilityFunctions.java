package Misc;

import backend.mappers.CustomerMapper;
import backend.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UtilityFunctions {
    private static Logger log = LoggerFactory.getLogger(UtilityFunctions.class);
    public static File jarDirectory;

    static {
        try {
            jarDirectory = new File(UtilityFunctions.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> prepareFieldNameFieldValueMap(Customer customer) {
        HashMap<String, String> map = new HashMap<>();

        String text = customer.toString();

        try {
            String[] keyValueText = text.split(", ");
            for (String pairText : keyValueText) {
                String[] pairArr = pairText.split("=");
                map.put(pairArr[0], pairArr[1]);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return map;
    }

    public static void putDetails(HashMap<String, Object> details, Customer customer) {
        System.out.println(details);
        customer.copy(CustomerMapper.createCustomer(details));
    }

    public static String removeUnderscoreAndCapitalizeFirst(String text) {
        return StringUtils.capitalize(text.replace("_", " "));
    }

    public static String UnderscoreAndUncapitalizeFirst(String text) {
        return StringUtils.uncapitalize(text.replace(" ", "_"));
    }

    public static Icon makeIcon(String path, int width, int height) {
        File file = getFile(path);

        BufferedImage image;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return null;
        }
        ImageIcon icon = new ImageIcon(resizeImage(image, width, height));
        return icon;

    }

    public static BufferedImage resizeImage(BufferedImage original, int newW, int newH) {
        Image result = original.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage output = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics g = output.getGraphics();
        g.drawImage(result, 0, 0, null);
        g.dispose();
        return output;
    }

    public static File getFile(String path) {
        return new File(jarDirectory.getAbsolutePath() + "/" + path);
    }
}
