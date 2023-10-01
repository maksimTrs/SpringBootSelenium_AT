package com.ea.SpringStart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


public class BasePage {

    @Autowired
    //@Qualifier("getChromeDriver")
    public WebDriver driver;

    @PostConstruct
    public void initDriver() {
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(String url) {
        Class<? extends WebDriver> webDriverClass = driver.getClass();

        this.driver.navigate().to(url);
        System.out.println(">>> Open Home page via browser: " + webDriverClass.getSimpleName());
        System.out.println(">>> In THREAD: " + Thread.currentThread().getName());
    }

}
