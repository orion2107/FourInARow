package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameProperties {

    private static Properties prop;

    static{
        try {
            prop = new Properties();
            prop.load(GameVerificator.class.getClassLoader().getResourceAsStream("game.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}

