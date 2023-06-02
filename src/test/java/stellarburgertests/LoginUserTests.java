package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class LoginUserTests extends BaseTest {
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

    //вход по кнопке "Войти в аккаунт" на главной
    @Test
    @DisplayName("Check click Login on Main Page to success user login")
    @Description("Check login using Login to account button on Main Page")
    public void checkClickLoginOnMainPageToSuccessUserLogin() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual = mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }

    // вход через кнопку "Личный кабинет"
    @Test
    @DisplayName("Check click personal account button on Main Page to success user login")
    @Description("Check login using Personal Account button on Main Page")
    public void checkClickPersonalAccountButtonOnMainPageToSuccessUserLogin() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.clickOnLinkTextPersonalAccount();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual = mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }

    // вход через кнопку в форме регистрации
    @Test
    @DisplayName("Check click button on Registration Page to success user login")
    @Description("Check login using button on registration form")
    public void checkClickButtonOnRegistrationPageToSuccessUserLogin() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkRegistration();
        registrationPage.clickOnLinkLoginOnRegistrationForm();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual = mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }

    // вход через кнопку в форме восстановления пароля.
    @Test
    @DisplayName("Check click button on Forgotten Password Page to success user login")
    @Description("Check login using button on the Forgotten Password form")
    public void checkClickButtonOnForgottenPasswordPageToSuccessUserLogin() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkPasswordRecovery();
        forgottenPasswordPage.clickOnLinkLoginOnForgottenPasswordPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        boolean actual = mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("User is not logged in", actual);
    }

    @After
    public void deleteTestData() {
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(token);
    }
}
