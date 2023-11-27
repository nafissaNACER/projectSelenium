package configuration;



import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    Properties properties;
    String env = System.getenv("ENV");
    public void loadProperties(){

        properties = new Properties();


        try {
            properties.load(ConfigFileReader.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public String getUrl(){

            return properties.getProperty("url");


    }

    public String getBrowser(){
        return properties.getProperty("VersionBrowser");
    }
}
