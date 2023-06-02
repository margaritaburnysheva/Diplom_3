package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class LogOutOfPersonalAccountTests extends BaseTest {
    private MainPage mainPage;
    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().name())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password(6, 10))
            .build();

    @Before
    public void prepareData() {
        userClient = new UserClient();
        userClient.createUser(user);
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @Test
    @DisplayName("Check success user log out")
    @Description("Check success user log out using exit button on Account Profile Page")
    public void checkSuccessUserLogOut() {
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        mainPage.clickOnLinkTextPersonalAccountAuthUser();
        accountProfilePage.logOutOfPersonalAccount();
        boolean actual = personalAccountLoginPage.checkTextLoginButtonIsDisplayed();
        assertTrue("User is not logged out", actual);
    }

    @After
    public void deleteTestData() {
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(token);
    }
}
