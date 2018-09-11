package com.challenge.service;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Murat Karagözgil
 */
@Service
public class ScreenShotService {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    private static final UrlValidator urlValidator = UrlValidator.getInstance();

    public List<String> getScreenshotUrls(String baseUrl, List<String> urls) {
        List<String> screenshotUrls = new ArrayList<>(urls.size());
        for (String url : urls) {

            if (urlValidator.isValid(url)) {
                String id = UUID.randomUUID().toString();
                Runnable worker = new ScreenShotWorker(id, url);
                executor.execute(worker);
                screenshotUrls.add(baseUrl + "/screenshot/" + id);
            } else {
                screenshotUrls.add("Url is not valid! " + url);
            }
        }
        return screenshotUrls;
    }
}
