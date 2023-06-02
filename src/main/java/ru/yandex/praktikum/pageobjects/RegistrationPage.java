package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //имя
    public static By inputRegistrationName=By.xpath(".//form/fieldset[1]/div/div/input");
    //email
    public static By inputRegistrationEmail=By.xpath(".//form/fieldset[2]/div/div/input");
    //password
    public static By inputRegistrationPassword=By.xpath(".//input[@type='password']");
    //кнопка "Зарегистрироваться"
    public static By buttonRegistration=By.xpath(".//button[text()='Зарегистрироваться']");
    //ссылка "Войти" на форме регистрации
    public static By linkLoginOnRegistrationForm=By.xpath(".//a[text()='Войти']");
    //ошибка "Некорректный пароль"
    public static By invalidPasswordErrorMessage=By.xpath(".//p[text()='Некорректный пароль']");

    //вход через кнопку в форме регистрации
    @Step("Click on the link Login On Registration Form and transfer to Personal Account Login Page")
    public void clickOnLinkLoginOnRegistrationForm(){
        driver.findElement(linkLoginOnRegistrationForm).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountLoginPage.buttonLoginOnPersonalAccountLoginPage));
    }
    //ввести имя, почту и пароль, нажать "Зарегистрировать"
    @Step("Input name, email, password and click on the link Login On Registration Form")
    public void inputData(String name,String email,String password){
        driver.findElement(inputRegistrationName).click();
        driver.findElement(inputRegistrationName).sendKeys(name);
        driver.findElement(inputRegistrationEmail).click();
        driver.findElement(inputRegistrationEmail).sendKeys(email);
        driver.findElement(inputRegistrationPassword).click();
        driver.findElement(inputRegistrationPassword).sendKeys(password);
        driver.findElement(buttonRegistration).click();
    }
}
