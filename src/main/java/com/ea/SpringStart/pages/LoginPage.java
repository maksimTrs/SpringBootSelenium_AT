package com.ea.SpringStart.pages;

import com.ea.SpringStart.annotations.TakeScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = ".btn-default")
    public WebElement btnLogin;

    @FindBy(how = How.CSS, using = "#loginForm ul li")
    public WebElement logInErrorMsg;

    public void fillLogInUserNameAndPassword(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    @TakeScreenshot
    public void doLogIn() {
        btnLogin.submit();
        System.out.println(">>> Click Login Btn on LogIn page");
    }

    //@TakeScreenshot
    public String getLogInErrorMsg() {
        wait.until(d -> logInErrorMsg.isDisplayed());
        return logInErrorMsg.getText();
    }
}
