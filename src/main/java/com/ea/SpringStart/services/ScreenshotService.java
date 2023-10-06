package com.ea.SpringStart.services;

import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Lazy
@Service
public class ScreenshotService {

    private static final Logger LOGGER = Logger.getLogger(ScreenshotService.class.getName());

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;


    public void takeScreenShot(TestInfo method)  {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(sourceFile, this.path.resolve(method.getDisplayName()
                    + "__"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_dd_MM_hh_mm_ss"))
                    + ".png").toFile());
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "<<< Error copying screenshot file: ", e + " >>>");
        }
    }

  /*  public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }*/

}
