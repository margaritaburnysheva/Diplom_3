package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountLoginPage {
    private final WebDriver driver;
    public PersonalAccountLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //email
    public static By inputEmail = By.xpath(".//form/fieldset[1]/div/div/input");
    //password
    public static By inputPassword = By.xpath(".//form/fieldset[2]/div/div/input");
    //кнопка "Войти"
    public static By buttonLoginOnPersonalAccountLoginPage = By.xpath(".//button[text()='Войти']");
    //ссылка "Зарегистрироваться"
    public static By linkRegistration = By.xpath(".//a[text()='Зарегистрироваться']");
    //ссылка "Восстановить пароль"
    public static By linkPasswordRecovery = By.xpath(".//a[text()='Восстановить пароль']");

    //клик по кнопке "Зарегистрироваться"
    @Step("Click on link registration and transfer to Registration Page")
    public void clickOnLinkRegistration() {
        driver.findElement(linkRegistration).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(RegistrationPage.buttonRegistration));
    }
    //клик по кнопке восстановить пароль
    @Step("Click on link password recovery and transfer to Forgotten Password Page")
    public void clickOnLinkPasswordRecovery() {
        driver.findElement(linkPasswordRecovery).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(ForgottenPasswordPage.buttonPasswordRecovery));
    }
    //ввести почту и пароль
    @Step("Input email and password")
    public void inputDataLogin(String email,String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginOnPersonalAccountLoginPage));
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLoginOnPersonalAccountLoginPage).click();
    }
    //проверка видимости кнопки "Войти"
    @Step("Check Login button is displayed")
    public boolean checkTextLoginButtonIsDisplayed(){
        WebElement element=new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginOnPersonalAccountLoginPage));
        return driver.findElement(buttonLoginOnPersonalAccountLoginPage).isDisplayed();
    }
}