package com.ea.SpringStart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


public class BasePage {

    @Autowired
    //@Qualifier("getChromeDriver")
    protected WebDriver driver;

    @PostConstruct
    public void initDriver() {
        PageFactory.initElements(driver, this);
    }


}
