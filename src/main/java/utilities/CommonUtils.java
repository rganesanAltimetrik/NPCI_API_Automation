package utilities;

import java.io.*;
import java.util.Properties;

public class CommonUtils {

    public static String getValueFromApplicationProperty(String key) throws IOException {
        Properties prop = new Properties();
        File f = new File("src/main/resources/application.properties");
        FileInputStream fis = new FileInputStream(f.getAbsolutePath());
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

}
