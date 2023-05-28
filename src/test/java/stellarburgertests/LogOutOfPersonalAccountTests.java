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

public class LogOutOfPersonalAccountTests {
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
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Check success user log out")
    @Description("Check success user log out using exit button on Account Profile Page")
    public void checkSuccessUserLogOut() {
        MainPage mainPage = new MainPage(driver);
        AccountProfilePage accountProfilePage=new AccountProfilePage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.clickOnLinkTextPersonalAccountAuthUser();
        accountProfilePage.logOutOfPersonalAccount();
        boolean actual=personalAccountLoginPage.checkTextLoginButtonIsDisplayed();
        assertTrue("User is not logged out", actual);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
