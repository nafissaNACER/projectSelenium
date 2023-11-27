package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTools;

import java.util.List;

public class AccueilPage extends BaseTools {

    @FindBy(name = "keyword")
    WebElement champsRechercher;

    @FindBy(xpath = "//button[@aria-label='Rechercher']")
    WebElement boutonRechercher;

    @FindBy(xpath = "//img[@class=\"sc-bsm2tm-3 dQOodK\"]")
    List<WebElement> listProduct;

    @FindBy(xpath = "//span[contains(text(),'Se connecter')]")
            WebElement linkSeConnecter;


    WebDriver driver;

    public AccueilPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void searchProduct(String product){
        champsRechercher.sendKeys(product);
        boutonRechercher.click();

    }


    public boolean VerifierResultatsDeRecherche() {
        boolean verif=false;
        try {

            if (listProduct.size() != 0) {
                verif=true;
                System.out.println("le nombre de produit trouvé est "+ listProduct.size());
            }

        } catch (Exception e) {
            System.out.println("not found result");
        }
        return verif;
    }

    public void cliquerSeConnecter() {
        //linkSeConnecter.click();
        waitAndClickElement(driver,linkSeConnecter);
    }
}
