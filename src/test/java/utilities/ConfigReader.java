package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final static Properties properties;

    static{
        properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
