package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtil extends BaseClass {

    public static void captureScreenshot(String screenshotName) {

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken successfully..");

            File dest = new File("./target/screenshots/" + screenshotName + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}