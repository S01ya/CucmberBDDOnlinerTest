package com.it_academy.cucmber.testNG.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  private DriverManager() {
    }

    public static void setupDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
        } else {
            System.out.println("driver has been set" + Thread.currentThread().getId());
        }
    }

    public static WebDriver getDriver() {
      return driverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            driverThreadLocal.remove();
        });
    }
}
