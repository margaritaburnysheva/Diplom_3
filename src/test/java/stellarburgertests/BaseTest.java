package stellarburgertests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pageobjects.Driver;
import ru.yandex.praktikum.pageobjects.UserClient;

public class BaseTest {
    WebDriver driver;
    UserClient userClient;
    String token;

    @BeforeClass
    public static void globalSetUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Before
    public void setUp() {
        driver = Driver.chooseBrowser();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}

