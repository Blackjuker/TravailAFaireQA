@test_panier
Feature: Gestion des produits dans le panier sur SauceDemo

  
  Background:
    Given l utilisateur est connecte avec "standard_user" et "secret_sauce" sur l url "https://www.saucedemo.com/"
    And il est sur la page des produits

  @smoke
  Scenario: Verification du prix hors panier et dans le panier
    When l utilisateur ajoute le premier produit au panier
    Then le badge du panier doit afficher "1"
    When il ouvre le panier
    Then le prix du produit dans le panier doit etre identique au prix affiche sur la page produit

  @functional
  Scenario: Suppression d un article du panier
    When l utilisateur ajoute le premier produit au panier
    And il ouvre le panier
    And il supprime le produit du panier
    Then le panier doit etre vide
