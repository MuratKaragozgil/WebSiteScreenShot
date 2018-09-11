package com.challenge.service;

import com.challenge.Utils;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * @author Murat Karagözgil
 */
public class ScreenShotWorker implements Runnable {

    private String id;
    private String url;

    public ScreenShotWorker(String id, String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public void run() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String filePath = Utils.getImageFilePath() + id + ".png";
        boolean result = screenshot.renameTo(new File(filePath));
    }
}
