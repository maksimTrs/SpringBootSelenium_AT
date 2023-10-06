package com.ea.SpringStart;


import com.ea.SpringStart.pages.HomePage;
import com.ea.SpringStart.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest()
@ActiveProfiles("")
public class SpringStartApplicationTests {

    @Autowired
    @Lazy
    protected HomePage homePage;

    @Autowired
    @Lazy
    protected LoginPage loginPage;

    @Value("${app.url}")
    protected String appUrl;

    @Value("${app.user}")
    protected String appUser;


    @Value("${app.password}")
    protected String appPass;

    @Value("${app.user2:user}")
    protected String appUser2;


    @Value("${app.wrongPassword}")
    protected String appWrongPass;

    @AfterEach
    public void closeBrowser() {
        homePage.close();
    }
}
