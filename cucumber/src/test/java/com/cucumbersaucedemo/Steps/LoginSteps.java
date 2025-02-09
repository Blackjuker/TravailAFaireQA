package com.cucumbersaucedemo.Steps;

import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.en.When;

public class LoginSteps {

    @When("Se connecter au site {string}")
    public void Se_connecter_au_site(String s) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverTools.GetWebDriver().get(s);
    }
    
}
