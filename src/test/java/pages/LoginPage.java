package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTools;

public class LoginPage extends BaseTools {
    @FindBy(name = "E-mail")
    WebElement champEmail;

    @FindBy(name = "Mot de passe")
    WebElement champPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSeConnecter;

    @FindBy(id="swal2-html-container")
            WebElement messageText;

    @FindBy(linkText = "S'inscrire gratuitement.")
    WebElement lienSinscrire;

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void saisrirEmail(String Email){
        champEmail.sendKeys(Email);

    }

    public void saisirPassword(String pass){
        champPassword.sendKeys(pass);
    }

    public void cliquerSeConnecter(){
        btnSeConnecter.click();
    }

    public String verifierMessage(){
        String messageActuel = messageText.getText();
        return messageActuel;
    }


    public void cliquerSinscrire() {
       waitAndClickElement(driver,lienSinscrire);
    }
}
