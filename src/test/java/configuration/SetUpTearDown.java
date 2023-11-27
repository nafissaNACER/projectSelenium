package configuration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SetUpTearDown {
    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        configFileReader.loadProperties();
        System.out.println("lunch browser");
        driver= new EdgeDriver();
        driver.get(configFileReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void teardown(){
        System.out.println("close browser");
        driver.close();
        driver.quit();
    }
}
