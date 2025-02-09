package com.cucumbersaucedemo.Steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cucumbersaucedemo.Pages.CartPage;
import com.cucumbersaucedemo.Pages.ClientInformationPage;
import com.cucumbersaucedemo.Pages.LoginPage;
import com.cucumbersaucedemo.Pages.ProductPage;
import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientInformationSteps {

    private LoginPage loginPage ;
    private ProductPage productPage;
    private com.cucumbersaucedemo.Pages.ClientInformationPage clientInformationPage;

    @Given("l utilisateur est connecte avec {string} et {string}")
    public void l_utilisateur_est_connecte_avec_et(String s, String s2) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverTools.GetWebDriver().get("https://www.saucedemo.com/");
        loginPage = new LoginPage(WebDriverTools.GetWebDriver());
        loginPage.SeConnecterAvecLeUsernameEtPasswordValid(s, s2);
        productPage = new ProductPage(WebDriverTools.GetWebDriver());        
    }

    @Given("il a ajoute deux produits au panier")
    public void il_a_ajoute_deux_produits_au_panier() {
        // Write code here that turns the phrase above into concrete actions
        productPage.ClicAddOrRemoveProduitDansPanier(0);
        productPage.ClicAddOrRemoveProduitDansPanier(1);
        productPage.CartClickButton();
    }

    @Given("il a accede au formulaire d information client")
    public void il_a_accede_au_formulaire_d_information_client() {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartPage = new CartPage(WebDriverTools.GetWebDriver());
        cartPage.ClicOnCheckOutButton();
        clientInformationPage = new ClientInformationPage(WebDriverTools.GetWebDriver());
    }

    @When("il saisit son nom {string}")
    public void il_saisit_son_nom(String nom) {
        // Write code here that turns the phrase above into concrete actions
        clientInformationPage.SaisirLastName(nom);
    }

    @When("il saisit son adresse {string}")
    public void il_saisit_son_adresse(String adresse) {
        // Write code here that turns the phrase above into concrete actions
        clientInformationPage.SaisirAddresse(adresse);
    }


    @When("il saisit son prenom {string}")
    public void il_saisit_son_prenom(String prenom) {
        // Write code here that turns the phrase above into concrete actions
        clientInformationPage.SaisirFirstName(prenom);
    }

    @When("il clique sur le bouton {string}")
    public void il_clique_sur_le_bouton(String bouton) {
        // Write code here that turns the phrase above into concrete actions
        if (bouton.equalsIgnoreCase("continuer")){
            clientInformationPage.ClicButtonContinueCheckoutInformation();
        }
    }

   

    @Then("il doit etre redirige vers la page de confirmation de commande")
    public void il_doit_etre_redirige_vers_la_page_de_confirmation_de_commande() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(WebDriverTools.GetWebDriver().getCurrentUrl().contains("/checkout-step-two.html"));
    }

}
