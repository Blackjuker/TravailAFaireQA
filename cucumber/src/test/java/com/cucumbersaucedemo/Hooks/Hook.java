package com.cucumbersaucedemo.Hooks;

import com.cucumbersaucedemo.Tools.WebDriverTools;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void InitProjectConfiguration(){
        WebDriverTools.setup();        
    }

    @After
    public void DeleteConfiguration(){
      //  WebDriverTools.tearDown();
    }
}
