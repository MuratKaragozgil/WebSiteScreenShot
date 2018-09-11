package com.challenge;

/**
 * @author Murat Karagözgil
 */
public class Utils {

    public static String getImageFilePath() {
        String workDirectory = System.getProperty("user.dir");
        String screenShotDirectory = "/src/main/resources/screenshots/";
        return workDirectory + screenShotDirectory;
    }

}
