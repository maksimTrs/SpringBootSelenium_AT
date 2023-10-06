package com.ea.SpringStart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomePage extends BasePage {


    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    @FindBy(how = How.XPATH, xpath = "//a[text()='Log off']")
    public WebElement logOffBtn;


    public void openHomePage(String url) {
        Class<? extends WebDriver> webDriverClass = driver.getClass();

        this.driver.navigate().to(url);
        System.out.println(">>> Open Home page via browser: " + webDriverClass.getSimpleName());
        System.out.println(">>> In THREAD: " + Thread.currentThread().getName());
    }

    public void clickOnLoginBtn() {
        lnkLogin.click();
        System.out.println(">>> Click Login on Home page");
    }

    public String assertLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logOffBtn));

        return logOffBtn.getText();
    }
}
