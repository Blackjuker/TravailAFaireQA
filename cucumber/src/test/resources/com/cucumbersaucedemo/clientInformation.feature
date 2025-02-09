@clientinformation
Feature: Envoi des informations client lors du checkout sur SauceDemo

  Background:
    Given l utilisateur est connecte avec "standard_user" et "secret_sauce" 
    And il a ajoute deux produits au panier
    And il a accede au formulaire d information client

  @smoke
  Scenario: Remplir et valider le formulaire avec des informations valides
    When il saisit son prenom "Arnaud"
    And il saisit son nom "Ngabgna"
    And il saisit son adresse "10 rue des Folles"
    And il clique sur le bouton "Continuer"
    Then il doit etre redirige vers la page de confirmation de commande
