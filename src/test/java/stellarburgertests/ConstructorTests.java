package stellarburgertests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("Check transfer to Buns Menu")
    @Description("Test for Constructor (Buns)")
    public void checkTransferToBunsMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.transferToNameBunsMenuContainer();
        String buttonClassName = driver.findElement(MainPage.scrollBunsMenuContainer).getAttribute("class");
        assertTrue("Error on transfer to Buns Menu", buttonClassName.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Check transfer to Sauces Menu")
    @Description("Test for Constructor (Sauces)")
    public void checkTransferToSaucesMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.transferToNameSaucesMenuContainer();
        String buttonClassName = driver.findElement(MainPage.scrollSaucesMenuContainer).getAttribute("class");
        assertTrue("Error on transfer to Sauces Menu", buttonClassName.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Check transfer to Fillings Menu")
    @Description("Test for Constructor (Fillings)")
    public void checkTransferToFillingsMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.transferToNameFillingsMenuContainer();
        String buttonClassName = driver.findElement(MainPage.scrollFillingsMenuContainer).getAttribute("class");
        assertTrue("Error on transfer to Fillings Menu", buttonClassName.contains("tab_tab_type_current__2BEPc"));
    }
}
