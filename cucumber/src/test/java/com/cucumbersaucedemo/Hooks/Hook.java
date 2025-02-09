package com.cucumbersaucedemo.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before
    public void InitProjectConfiguration(){
        WebDriverTools.setup();        
    }

    @After
    public void DeleteConfiguration(){
      WebDriverTools.tearDown();
    }

    @AfterStep
    public void captureScreenshot(Scenario scenario){
      if (!scenario.isFailed()) {  // Vérifie si le test a échoué
            WebDriver driver = WebDriverTools.GetWebDriver();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Capture d'écran");
        }
    }
}
