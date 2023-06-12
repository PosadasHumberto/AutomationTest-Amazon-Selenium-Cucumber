package org.hposadas.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;  //driver se declara como protected static para permitir que sea accesible desde otras clases que hereden de la clase actual.
    private static WebDriverWait wait;  //wait se declara como private static para limitar su acceso solo dentro de la clase actual.

    //inicializando los atributos estaticos, se ejecuta cuando la clase se carga por primera vez
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    //métodos generales

    // el método navigateTo y closeNavigator es estático porque utiliza el atributo estático driver.
    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeNavigator(){
        driver.quit();
    }

    private WebElement find(String locator){
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Element Not Found" + locator);
        }
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public String textFromElement(String locator){
        return find(locator).getText();
    }

    public void selectNthElementFromList(String locator, int index) {
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        elements.get(index).click();
    }

}
