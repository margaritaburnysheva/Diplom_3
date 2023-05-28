package stellarburgertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobjects.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTests {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //для тестирования в YandexBrowser
       // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/yandexdriver-23.5.0.2199-win64/yandexdriver.exe");
       // driver=new ChromeDriver();
    }

    @Test
    @DisplayName("Check transfer to Buns Menu")
    @Description("Test for Constructor (Buns)")
    public void checkTransferToBunsMenu(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean isBunsMenuDisplayed=mainPage.transferToNameBunsMenuContainer();
        assertTrue("Error on transfer to Buns Menu",isBunsMenuDisplayed);
    }
    @Test
    @DisplayName("Check transfer to Sauces Menu")
    @Description("Test for Constructor (Sauces)")
    public void checkTransferToSaucesMenu(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean isSaucesMenuDisplayed=mainPage.transferToNameSaucesMenuContainer();
        assertTrue("Error on transfer to Sauces Menu",isSaucesMenuDisplayed);
    }
    @Test
    @DisplayName("Check transfer to Fillings Menu")
    @Description("Test for Constructor (Fillings)")
    public void checkTransferToFillingsMenu(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean isFillingsMenuDisplayed=mainPage.transferToNameFillingsMenuContainer();
        assertTrue("Error on transfer to Fillings Menu",isFillingsMenuDisplayed);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
