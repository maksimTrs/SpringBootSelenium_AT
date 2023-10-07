package com.ea.SpringStart.aspects;


import com.ea.SpringStart.annotations.TakeScreenshot;
import com.ea.SpringStart.services.ScreenshotService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Aspect
@Component
public class ScreenshotAspect {

    private static final Logger LOGGER = Logger.getLogger(ScreenshotService.class.getName());

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint joinPoint, TakeScreenshot takeScreenshot) throws IOException {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("<<<<< Was initiated the screenshot for method: " + methodName + " >>>>>");

        this.screenshotService.takeScreenShot(methodName);
        this.screenshotService.getScreenshot();
    }
}
