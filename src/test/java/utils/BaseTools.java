package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTools {

    WebDriverWait wait;

    int TIME= 300;

    public void waitAndClickElement(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitAndSendkeys(WebDriver driver, WebElement element,String text){
        wait = new WebDriverWait(driver,Duration.ofSeconds(TIME));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public void waitElementToBeVisible(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver,Duration.ofSeconds(TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
