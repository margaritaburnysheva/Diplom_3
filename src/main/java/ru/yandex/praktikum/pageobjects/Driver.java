package ru.yandex.praktikum.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver chooseBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "yandex";
        }
        switch (browser) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
                return new ChromeDriver(options);
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Users/Aleksandr/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                return new ChromeDriver(options);
            }
            default:
                throw new RuntimeException("No browser");
        }
    }
}
