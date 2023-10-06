package com.ea.SpringStart.tests;

import com.ea.SpringStart.SpringStartApplicationTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ChromeLogInTest extends SpringStartApplicationTests {

    @Test
    public void contextLoadsTest() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");
    }

    @Test
    public void contextLoadsTest2() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");
    }
}
