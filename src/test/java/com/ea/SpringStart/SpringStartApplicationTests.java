package com.ea.SpringStart;


import com.ea.SpringStart.pages.HomePage;
import com.ea.SpringStart.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest()
public class SpringStartApplicationTests {

    @Autowired
    protected HomePage homePage;

    @Autowired
    protected LoginPage loginPage;

    @Value("${app.url}")
    protected String appUrl;

    @Value("${app.user}")
    protected String appUser;


    @Value("${app.password}")
    protected String appPass;
}
