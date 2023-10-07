package com.ea.SpringStart.tests;

import com.ea.SpringStart.SpringStartApplicationTests;
import com.ea.SpringStart.services.TestsWatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;


@Execution(ExecutionMode.CONCURRENT)
public class LogInTest extends SpringStartApplicationTests {

    @Test
    public void doLogInAsAdminTest() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");

        //homePage.close();
    }

    @Test
    public void doLogInAsUserTest() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser2, appPass);
        loginPage.doLogIn();

        assertThat(homePage.assertLogIn()).isEqualTo("Log off");

        //homePage.close();
    }
}
