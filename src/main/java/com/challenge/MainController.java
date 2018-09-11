package com.challenge;

import com.challenge.service.ScreenShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Murat Karagözgil
 */
@RestController
@RequestMapping("/screenshot")
public class MainController {

    @Autowired
    private ScreenShotService screenShotService;

    private final Logger logger = Logger.getLogger(getClass().getName());

    @PostMapping("/generate-screenshot")
    public ResponseEntity generateScreenshots(HttpServletRequest request, @RequestBody List<String> webSiteList) {
        String baseUrl = String.format("%s://%s:%d/", request.getScheme(), request.getServerName(), request.getServerPort());

        logger.info("generateScreenshots::webSiteList::" + webSiteList);

        List<String> screenshotUrlList = screenShotService.getScreenshotUrls(baseUrl, webSiteList);

        return ResponseEntity
                .ok()
                .body(screenshotUrlList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getImage(@PathVariable String id) {

        File imgFile = new File(Utils.getImageFilePath() + id + ".png");

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(imgFile);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(fileInputStream));
    }

}

