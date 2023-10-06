package com.ea.SpringStart.tests;

import com.ea.SpringStart.SpringStartApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;


@Execution(ExecutionMode.CONCURRENT)
public class LogInTest extends SpringStartApplicationTests {

    @Test
    public void contextLoadsTest() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");

        //homePage.close();
    }

    @Test
    public void contextLoadsTest2() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser2, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");

        //homePage.close();
    }
}
