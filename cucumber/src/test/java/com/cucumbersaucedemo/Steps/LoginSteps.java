package com.cucumbersaucedemo.Steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cucumbersaucedemo.Pages.LoginPage;
import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;

    @When("Se connecter au site {string}")
    public void Se_connecter_au_site(String s) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverTools.GetWebDriver().get(s);
        loginPage  = new LoginPage(WebDriverTools.GetWebDriver());
    }

    @When("il saisit le nom d utilisateur {string}")
    public void il_saisit_le_nom_d_utilisateur(String s) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.SaisirUsername(s);
    }

    @When("il saisit le mot de passe {string}")
    public void il_saisit_le_mot_de_passe(String s) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.SaisirPassword(s);
    }

    @Given("l utilisateur est sur la page de connexion")
    public void l_utilisateur_est_sur_la_page_de_connexion() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("il clique sur le bouton de connexion")
    public void il_clique_sur_le_bouton_de_connexion() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.ClickOnLoginButton();
    }

    @When("il saisit un mot de passe incorrect {string}")
    public void il_saisit_un_mot_de_passe_incorrect(String s) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.SaisirPassword(s);
    }

    @Then("il doit etre redirige vers la page d inventaire")
    public void il_doit_etre_redirige_vers_la_page_d_inventaire() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(WebDriverTools.GetWebDriver().getCurrentUrl().contains("/inventory.html"), "Echec de connexion : URL actuelle = "+ WebDriverTools.GetWebDriver().getCurrentUrl());
    }

    @Then("un message d erreur {string} doit s afficher")
    public void un_message_d_erreur_doit_s_afficher(String s) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(s, loginPage.RecuperationMessageErreurLogin());
    }

    @Then("l utilisateur doit etre redirige vers la page d inventaire sauf pour {string}")
    public void utilisateurRedirigeOuErreur(String username) {
        if (username.equals("locked_out_user")) {
            String expectedError = "Epic sadface: Sorry, this user has been locked out.";
            assertEquals(expectedError, loginPage.RecuperationMessageErreurLogin(),
                    "Message d'erreur incorrect pour un utilisateur bloqué.");
        } else {
            assertTrue(WebDriverTools.GetWebDriver().getCurrentUrl().contains("/inventory.html"),
                    "Échec de connexion : URL actuelle = " + WebDriverTools.GetWebDriver().getCurrentUrl());
        }
    }

    



    
}
