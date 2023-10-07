package com.ea.SpringStart.tests;

import com.ea.SpringStart.SpringStartApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;


@Execution(ExecutionMode.CONCURRENT)
public class ErrorLogInTest extends SpringStartApplicationTests {

    @Test
    public void doLogInWithWrongPassTest() {
        homePage.openHomePage(appUrl);
        homePage.clickOnLoginBtn();
        loginPage.fillLogInUserNameAndPassword(appUser, appWrongPass);
        loginPage.doLogIn();

        assertThat(loginPage.getLogInErrorMsg()).contains("Invalid login111111111");

        //homePage.close();
    }
}
