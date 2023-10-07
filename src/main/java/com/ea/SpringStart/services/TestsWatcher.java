package com.ea.SpringStart.services;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Lazy
public class TestsWatcher implements TestWatcher {

 /*   @Autowired
    @Lazy
    ScreenshotService screenshotService;*/

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
      /*  screenshotService.getScreenshot();
        screenshotService.takeScreenShot(context);*/
    }
}
