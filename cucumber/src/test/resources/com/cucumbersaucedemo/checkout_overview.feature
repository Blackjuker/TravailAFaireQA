@checkout_overview
Feature: Vérification des prix dans la page Checkout Overview sur SauceDemo

  Background:
    Given l utilisateur est connecte avec "standard_user" et "secret_sauce" et l url "https://www.saucedemo.com/"
    And il a ajoute plusieurs produits au panier
    And il a accede a la page de recapitulatif de commande

  Scenario: Verification du total des prix des articles
    When l utilisateur additionne les prix des articles affiches
    Then le total calcule doit correspondre au total affiche sur la page Checkout Overview
