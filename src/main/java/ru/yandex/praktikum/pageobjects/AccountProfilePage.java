package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountProfilePage {
    private final WebDriver driver;
    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    //кнопка "Выход"
    public static By buttonLogOut=By.xpath(".//button[text()='Выход']");
    //текст "Конструктор"
    public static By textConstructor=By.xpath(".//p[text()='Конструктор']");
    //лого
    public static By textLogo=By.className("AppHeader_header__logo__2D0X2");
    //клик по кнопке выход
    @Step("Log out of personal account")
    public boolean logOutOfPersonalAccount(){
        driver.findElement(buttonLogOut).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountLoginPage.buttonLoginOnPersonalAccountLoginPage));
        return driver.findElement(PersonalAccountLoginPage.buttonLoginOnPersonalAccountLoginPage).isDisplayed();
    }
    //клик по конструктору
    @Step("Click constructor")
    public boolean clickConstructor(){
         driver.findElement(textConstructor).click();
         new WebDriverWait(driver, 10)
                 .until(ExpectedConditions.visibilityOfElementLocated(MainPage.buttonCreateOrder));
         return driver.findElement(MainPage.buttonCreateOrder).isDisplayed();
    }
    //клик по лого
    @Step("Click logo")
    public boolean clickLogo() {
        driver.findElement(textLogo).click();
             new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(MainPage.buttonCreateOrder));
        return driver.findElement(MainPage.buttonCreateOrder).isDisplayed();
    }
    //проверка видимости кнопки "Выход"
    @Step("Check exit button is displayed")
    public boolean checkExitTextButtonIsDisplayed(){
        WebElement element=new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogOut));
        return driver.findElement(buttonLogOut).isDisplayed();
    }
}
