package com.cucumbersaucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientInformationPage {
    @FindBy(id="first-name")
    private WebElement firstNameElement;
    @FindBy(id = "last-name")
    private WebElement lastNameElement;
    @FindBy(id="postal-code")
    private WebElement addressElement;
    @FindBy(id="continue")
    private WebElement contactContinueBtnElement;

    WebDriver drive;
    public ClientInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void SaisirFirstName(String firstName){
        firstNameElement.sendKeys(firstName);
    }

    public void SaisirLastName(String lastName ){
        lastNameElement.sendKeys(lastName);
    }

    public void SaisirAddresse(String address){
        addressElement.sendKeys(address);
    }

    public void ClicButtonContinueCheckoutInformation(){
        contactContinueBtnElement.click();
    }

}
