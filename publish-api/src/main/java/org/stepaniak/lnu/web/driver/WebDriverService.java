package org.stepaniak.lnu.web.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WebDriverService {
    private static final String SOURCE = "https://zaxid.net/novini_lvova_tag50956/";
    private static final String XPATH = "/html/body/div[1]/div/section/div/div/div[1]/div[1]/div[2]/ul[1]/li";
    private static final int LOAD_COUNT = 10;

    private ChromeOptions options = new ChromeOptions().addArguments("--headless");
    private WebDriver driver = new ChromeDriver(options);

    public WebDriverService() {
    }

    public List<String> load() {
        driver.get(SOURCE);
        List<WebElement> data = driver.findElements(By.xpath(XPATH));
        return data.stream()
                .map(WebElement::getText)
                .flatMap(string -> Stream.of(string.split("([0-9]{2}:[0-9]{2})\n")))
                .filter(string -> !string.isEmpty())
                .limit(LOAD_COUNT)
                .filter(string -> !string.contains("PROMOTED"))
                .collect(Collectors.toList());
    }

    public static String getSOURCE() {
        return SOURCE;
    }
}
