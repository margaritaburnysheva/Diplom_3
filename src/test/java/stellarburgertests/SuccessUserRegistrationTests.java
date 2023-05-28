package stellarburgertests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class SuccessUserRegistrationTests {
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
    }
    @Test
    @DisplayName("Check success user registration")
    public void checkSuccessUserRegistration() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkRegistration();
        registrationPage.inputData(user.getName(), user.getEmail(), user.getPassword());
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not registered", actual);
    }
    @After
    public void cleanUp(){
        driver.quit();
    }

}
