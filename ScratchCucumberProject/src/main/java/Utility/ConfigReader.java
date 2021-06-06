package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;
    public FileInputStream fis;

    public Properties init_prop() {
        prop = new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src//test//resources//Config//Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }


    public String getProperies(String Key) {
        String value = prop.getProperty(Key);
        return value;
    }


}
