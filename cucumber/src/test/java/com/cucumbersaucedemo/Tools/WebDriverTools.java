package com.cucumbersaucedemo.Tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTools {

    
    static private WebDriver driver;
    public static void setup(){
        driver = new ChromeDriver();
    }

    static public WebDriver GetWebDriver(){
        return driver;
    }

    public static void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(driver!=null){
            driver.quit();
        }
    }
}
