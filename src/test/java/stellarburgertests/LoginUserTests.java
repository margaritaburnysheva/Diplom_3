package stellarburgertests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class LoginUserTests {
    private WebDriver driver;
    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().name())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password(6,10))
            .build();
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //для тестирования в YandexBrowser
        // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/yandexdriver-23.5.0.2199-win64/yandexdriver.exe");
        // driver=new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkRegistration();
        registrationPage.inputData(user.getName(), user.getEmail(), user.getPassword());
    }
    //вход по кнопке "Войти в аккаунт" на главной
    @Test
    @DisplayName("Check click Login on Main Page to success user login")
    @Description("Check login using Login to account button on Main Page")
    public void checkClickLoginOnMainPageToSuccessUserLogin() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }
    // вход через кнопку "Личный кабинет"
    @Test
    @DisplayName("Check click personal account button on Main Page to success user login")
    @Description("Check login using Personal Account button on Main Page")
    public void checkClickPersonalAccountButtonOnMainPageToSuccessUserLogin() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnLinkTextPersonalAccount();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }
    // вход через кнопку в форме регистрации
    @Test
    @DisplayName("Check click button on Registration Page to success user login")
    @Description("Check login using button on registration form")
    public void checkClickButtonOnRegistrationPageToSuccessUserLogin() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkRegistration();
        registrationPage.clickOnLinkLoginOnRegistrationForm();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }
    // вход через кнопку в форме восстановления пароля.
    @Test
    @DisplayName("Check click button on Forgotten Password Page to success user login")
    @Description("Check login using button on the Forgotten Password form")
    public void checkClickButtonOnForgottenPasswordPageToSuccessUserLogin() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkPasswordRecovery();
        forgottenPasswordPage.clickOnLinkLoginOnForgottenPasswordPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
