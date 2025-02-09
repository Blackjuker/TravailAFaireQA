package com.cucumbersaucedemo.Steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;

import com.cucumbersaucedemo.Pages.LoginPage;
import com.cucumbersaucedemo.Pages.ProductPage;
import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {


    private LoginPage loginPage ;
    private ProductPage productPage;
    private String prixProduitHorsPanier;

    @Given("l utilisateur est connecte avec {string} et {string} sur l url {string}")
    public void l_utilisateur_est_connecte_avec_et_sur_l_url(String s, String s2, String url) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverTools.GetWebDriver().get(url);
        loginPage = new LoginPage(WebDriverTools.GetWebDriver());
        loginPage.SeConnecterAvecLeUsernameEtPasswordValid(s, s2);
        productPage = new ProductPage(WebDriverTools.GetWebDriver());
    }

    
    @Given("il est sur la page des produits")
    public void il_est_sur_la_page_des_produits() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(WebDriverTools.GetWebDriver().getCurrentUrl().contains("/inventory.html"));
    }

    @When("l utilisateur ajoute le premier produit au panier")
    public void l_utilisateur_ajoute_le_premier_produit_au_panier() {
        // Write code here that turns the phrase above into concrete actions
        prixProduitHorsPanier = productPage.GetPrixProduit(0);
        System.out.println("**************************** "+ prixProduitHorsPanier);
        productPage.ClicAddOrRemoveProduitDansPanier(0);
    }
    
    @Then("le badge du panier doit afficher {string}")
    public void le_badge_du_panier_doit_afficher(String expectedBadge) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedBadge, productPage.GetBadgeNombre());
    }

    @When("il ouvre le panier")
    public void il_ouvre_le_panier() {
        // Write code here that turns the phrase above into concrete actions
        productPage.CartClickButton();
    }


    @Then("le prix du produit dans le panier doit etre identique au prix affiche sur la page produit")
    public void le_prix_du_produit_dans_le_panier_doit_etre_identique_au_prix_affiche_sur_la_page_produit() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(prixProduitHorsPanier, productPage.GetPrixProduit(0));
    }

    @When("il supprime le produit du panier")
    public void il_supprime_le_produit_du_panier() {
        // Write code here that turns the phrase above into concrete actions
        productPage.RemoveProduitInCart(0);
    }

    @Then("le panier doit etre vide")
    public void le_panier_doit_etre_vide() {
        // Write code here that turns the phrase above into concrete actions
      //  assertEquals("0", productPage.CountListProduit());
    }


    

  


}
