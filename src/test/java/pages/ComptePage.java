package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTools;

public class ComptePage extends BaseTools {

    @FindBy(id="name")
    WebElement champName;

    @FindBy(id="email")
    WebElement champEmail;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement boutonCreerCompte;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    WebElement checkbox;

    @FindBy(xpath = "//label[@for=\"phone\"]//following-sibling::div[2]/span")
    WebElement messagetext;
    WebDriver driver;
    public ComptePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void saisirName(String name){
        System.out.println("saisir nom " + name);
        waitAndSendkeys(driver,champName,name);

    }

    public void saisirEmail(String email){
        System.out.println("saisir email " + email);
        waitAndSendkeys(driver,champEmail,email);

    }

    public void cliquerCreer(){
        System.out.println("cliquer sur creer un compte");
        waitAndClickElement(driver,boutonCreerCompte);

    }

    public void cliquerCheckbox(){
        System.out.println("cliquer sur checkbox");
        waitAndClickElement(driver,checkbox);

    }

    public String verifierMessage(){
        System.out.println("verifier le message d'erreur");
        String result ="";
        try {

            if(messagetext.isDisplayed()){
                result=messagetext.getText();
                System.out.println("message is displayed "+ result);
            }
        }catch (Exception e){
            System.out.println("message is not displayed "+ result);
        }
        return result;
    }

    public boolean verifierCheckBox(){
        System.out.println("verifier si la case et toujours coché");
        Boolean result =false;
        try {

            if(checkbox.isDisplayed()){
                result=checkbox.isSelected();
                System.out.println("my checkbox is selected "+result);
            }
        }catch (Exception e){
            System.out.println("my checkbox is not selected "+ result);
        }
        return result;
    }
}
