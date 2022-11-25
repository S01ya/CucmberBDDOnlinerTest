package com.it_academy.cucmber.testNG.pages;


import com.it_academy.cucmber.testNG.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);

    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public WebElement waitForElementVisible(By by) {
      Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(),60); //ofMillis(50000));
      return wait.until(ExpectedConditions.visibilityOfElementLocated(by));}

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }

   public void navigateToElement (By by) {
       Actions action = new Actions(DriverManager.getDriver());
       action.moveToElement(DriverManager.getDriver().findElement(by));
       action.perform();
       this.sleep(2);
   }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
    }
    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(),60);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
