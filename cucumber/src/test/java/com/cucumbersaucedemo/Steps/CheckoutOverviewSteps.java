package com.cucumbersaucedemo.Steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;


import com.cucumbersaucedemo.Pages.CartPage;
import com.cucumbersaucedemo.Pages.CheckOutOverview;
import com.cucumbersaucedemo.Pages.ClientInformationPage;
import com.cucumbersaucedemo.Pages.LoginPage;
import com.cucumbersaucedemo.Pages.ProductPage;
import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps {
   
    LoginPage loginPage;
    ProductPage productPage;
    ClientInformationPage clientInformationPage;
    CartPage cartPage;
    CheckOutOverview checkOutOverview;
    BigDecimal prixTotal;
  

    @Given("l utilisateur est connecte avec {string} et {string} et l url {string}")
    public void l_utilisateur_est_connecte_avec_et_et_l_url(String s, String s2, String url) {
        // Write code here that turns the phrase above into concrete actions

        WebDriverTools.GetWebDriver().get(url);
        loginPage = new LoginPage(WebDriverTools.GetWebDriver());
        loginPage.SeConnecterAvecLeUsernameEtPasswordValid(s, s2);
        productPage = new ProductPage(WebDriverTools.GetWebDriver());       
        cartPage = new CartPage(WebDriverTools.GetWebDriver());
        clientInformationPage = new ClientInformationPage(WebDriverTools.GetWebDriver());
        checkOutOverview = new CheckOutOverview(WebDriverTools.GetWebDriver());
    }

    @Given("il a ajoute plusieurs produits au panier")
    public void il_a_ajoute_plusieurs_produits_au_panier() {
        // Write code here that turns the phrase above into concrete actions
        productPage.ClicAddOrRemoveProduitDansPanier(0);
        productPage.ClicAddOrRemoveProduitDansPanier(1);
        productPage.CartClickButton();
        cartPage.ClicOnCheckOutButton();
        clientInformationPage.SaisirLastName("Ngabgna");
        clientInformationPage.SaisirFirstName("Arnaud");
        clientInformationPage.SaisirAddresse("12 rue des folles");
        clientInformationPage.ClicButtonContinueCheckoutInformation();
    }
   

    @When("l utilisateur additionne les prix des articles affiches")
    public void l_utilisateur_additionne_les_prix_des_articles_affiches() {
        // Write code here that turns the phrase above into concrete actions
        BigDecimal taxe = new BigDecimal(3.20);
        prixTotal = checkOutOverview.AdditionTotalPrixItem().add(taxe).setScale(2,RoundingMode.HALF_UP);
        
      
    }

    @Then("le total calcule doit correspondre au total affiche sur la page Checkout Overview")
    public void le_total_calcule_doit_correspondre_au_total_affiche_sur_la_page_Checkout_Overview() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(prixTotal, checkOutOverview.RecuperationTotalPrix(), "Le total calculé ne correspond pas au total affiché sur la page.");
    }

    @Given("il a accede a la page de recapitulatif de commande")
    public void il_a_accede_a_la_page_de_recapitulatif_de_commande() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(WebDriverTools.GetWebDriver().getCurrentUrl().contains("/checkout-step-two.html"));
      
    }

}
