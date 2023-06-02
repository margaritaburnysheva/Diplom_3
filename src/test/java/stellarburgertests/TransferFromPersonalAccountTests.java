package stellarburgertests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.*;

import static org.junit.Assert.assertTrue;

public class TransferFromPersonalAccountTests extends BaseTest{
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

    //клик на конструктор
    @Test
    @DisplayName("Check click constructor on Account Profile Page to transfer Main Page")
    @Description("Check Constructor button")
    public void checkClickConstructorOnAccountProfilePageToTransferMainPage() {
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainPage.clickOnButtonLoginAccountOnMainPage();
        personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
        mainPage.clickOnLinkTextPersonalAccountAuthUser();
        AccountProfilePage accountProfilePage=new AccountProfilePage(driver);
        accountProfilePage.clickConstructor();
        boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
        assertTrue("Constructor button is broken", actual);
    }
   //клик на лого
   @Test
   @DisplayName("Check click logo on Account Profile Page to transfer Main Page")
   @Description("Check logo")
   public void checkClickLogoOnAccountProfilePageToTransferMainPage() {
       PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
       mainPage.clickOnButtonLoginAccountOnMainPage();
       personalAccountLoginPage.inputDataLogin(user.getEmail(), user.getPassword());
       mainPage.clickOnLinkTextPersonalAccountAuthUser();
       AccountProfilePage accountProfilePage=new AccountProfilePage(driver);
       accountProfilePage.clickLogo();
       boolean actual=mainPage.checkTextCreateOrderButtonIsDisplayed();
       assertTrue("Logo is broken", actual);
   }
    @After
    public void deleteTestData() {
        token = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
        userClient.deleteUser(token);
    }
}
