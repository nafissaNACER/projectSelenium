package suitesTest;

import configuration.SetUpTearDown;
import org.testng.annotations.Test;
import pages.AccueilPage;
import pages.ComptePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SuiteAvito extends SetUpTearDown {

    @Test
    public void scenario01_chercherdansAvito(){
        String produit="voiture";
        AccueilPage accueilPage= new AccueilPage(driver);
        accueilPage.searchProduct(produit);
        assertTrue(accueilPage.VerifierResultatsDeRecherche());
    }

    @Test
    public void scenario01_loginInvalid() throws InterruptedException {
        String email= "test@gmail.com";
        String pass= "tazertt";
        String messageAttendu="Mauvais email ou mot de passe";
        AccueilPage accueilPage = new AccueilPage(driver);
        accueilPage.cliquerSeConnecter();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.saisrirEmail(email);
        loginPage.saisirPassword(pass);
        loginPage.cliquerSeConnecter();
        assertEquals(loginPage.verifierMessage(),messageAttendu);
    }

    @Test
    public void scenario03_creerCompte() throws InterruptedException {
        String email= "test@gmail.com";
        String nom= "test";
        String messageAttendu="Doit être un numéro de téléphone valide";
        //2.	Cliquer sur lien se connecter
        Thread.sleep(5000);
        AccueilPage accueilPage = new AccueilPage(driver);
        accueilPage.cliquerSeConnecter();
        //3.	Cliquer sur lien  S'inscrire gratuitement.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.cliquerSinscrire();
        //4.	Saisir le nom
        ComptePage comptePage=new ComptePage(driver);
        comptePage.saisirName(nom);
        //5.	Saisir un email
        comptePage.saisirEmail(email);
        //6.	Coché checkBox
        comptePage.cliquerCheckbox();
        //7.	Cliquer creer
        comptePage.cliquerCreer();
        // 8.	Vérifier le message d’erreur «Doit être un numéro de téléphone valide «
        assertEquals(comptePage.verifierMessage(),messageAttendu);
        //9.	Vérifier que checkBox est toujours coché
        assertTrue(comptePage.verifierCheckBox());

    }
}
