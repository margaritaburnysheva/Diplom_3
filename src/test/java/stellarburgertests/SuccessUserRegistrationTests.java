package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class SuccessUserRegistrationTests extends BaseTest{
    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().name())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password(6,10))
            .build();
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
    public void deleteTestData() {
        userClient=new UserClient();
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(token);
    }
}
