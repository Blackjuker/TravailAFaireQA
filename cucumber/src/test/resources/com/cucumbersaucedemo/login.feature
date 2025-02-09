Feature: Test Login

    Background: Nous allons d'abord nous connecter
        When Se connecter au site "https://www.saucedemo.com/"
    
    @smoke
    Scenario: Connexion réussie avec des identifiants valides
        Given l utilisateur est sur la page de connexion
        When il saisit le nom d utilisateur "standard_user"
        And il saisit le mot de passe "secret_sauce"
        And il clique sur le bouton de connexion
        Then il doit etre redirige vers la page d inventaire

    @regression
    Scenario: Échec de connexion avec un mot de passe incorrect
        Given l utilisateur est sur la page de connexion
        When il saisit le nom d utilisateur "standard_user"
        And il saisit un mot de passe incorrect "sxcvcxdsfsdfsf"
        And il clique sur le bouton de connexion
        Then un message d erreur "Epic sadface: Username and password do not match any user in this service" doit s afficher

    Scenario Outline: Connexion avec différents utilisateurs
        When il saisit le nom d utilisateur "<username>"
        And il saisit le mot de passe "secret_sauce"
        And il clique sur le bouton de connexion
        Then l utilisateur doit etre redirige vers la page d inventaire sauf pour "<username>"

        Examples:
        | username                |
        | standard_user           |
        | locked_out_user         |
        | problem_user            |
        | performance_glitch_user |
        | error_user              |
        | visual_user             |