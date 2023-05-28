package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgottenPasswordPage {
    private final WebDriver driver;
    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    //кнопка "Восстановить"
    public static By buttonPasswordRecovery=By.xpath(".//button[text()='Восстановить']");
    //ссылка "Войти" в форме восстановления пароля
    public static By linkLoginOnForgottenPasswordPage=By.xpath(".//a[text()='Войти']");
    //вход через кнопку в форме восстановления пароля
    @Step("Click on link login on forgotten password page")
    public void clickOnLinkLoginOnForgottenPasswordPage() {
        driver.findElement(linkLoginOnForgottenPasswordPage).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountLoginPage.buttonLoginOnPersonalAccountLoginPage));
    }
}
