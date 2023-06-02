package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertEquals;

public class ErrorInvalidPasswordTests extends BaseTest{

    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().name())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password(1,5))
            .build();
    String message="Некорректный пароль";

    @Test
    @DisplayName("Check error invalid password")
    @Description("Input invalid password and check error message is displayed ")
    public void checkErrorInvalidPassword() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.clickOnLinkRegistration();
        registrationPage.inputData(user.getName(), user.getEmail(), user.getPassword());
        String errorMessage = driver.findElement(RegistrationPage.invalidPasswordErrorMessage).getText();
        assertEquals("Error message is not displayed", errorMessage, message);
    }
    @After
    public void deleteTestData() {
        userClient=new UserClient();
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        if (token != null) {
            userClient.deleteUser(token);
        }
    }
}
