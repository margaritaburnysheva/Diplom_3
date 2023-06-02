package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class TransferToPersonalAccountTests extends BaseTest{
    private MainPage mainPage;
    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().name())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password(6,10))
            .build();
    @Before
    public void prepareData() {
        userClient = new UserClient();
        userClient.createUser(user);
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }
    @Test
    @DisplayName("Check click Personal Account button to transfer Account Profile Page")
    @Description("Check Personal account button to transfer Account Profile Page")
    public void checkClickPersonalAccountButtonToTransferAccountProfilePage() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        AccountProfilePage accountProfilePage=new AccountProfilePage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        mainPage.clickOnLinkTextPersonalAccountAuthUser();
        boolean actual=accountProfilePage.checkExitTextButtonIsDisplayed();
        assertTrue("Personal account button is broken", actual);
    }
    @After
    public void deleteTestData() {
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(token);
    }
}
