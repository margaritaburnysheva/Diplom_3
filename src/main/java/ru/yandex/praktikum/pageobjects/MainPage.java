package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Войти в аккаунт" на главной
    public static By buttonLoginAccountOnMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Личный кабинет"
    public static By linkTextPersonalAccount = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    //лого Stellar Burgers
    public static By headerLogo = By.className("AppHeader_header__logo__2D0X2");
    //"Булки"
    public static By tabBunsBurgerIngredients = By.xpath(".//span[text()='Булки']/..");
    //"Соусы"
    public static By tabSaucesBurgerIngredients = By.xpath(".//span[text()='Соусы']/..");
    //"Начинки"
    public static By tabFillingsBurgerIngredients = By.xpath(".//span[text()='Начинки']/..");
    //кнопка "Оформить заказ"
    public static By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    //локатор для прокрутки в конструкторе "Булки"
    public static By scrollBunsMenuContainer = By.xpath(".//div[@style='display: flex;']/div[1]");
    //локатор для прокрутки в конструкторе "Соусы"
    public static By scrollSaucesMenuContainer = By.xpath(".//div[@style='display: flex;']/div[2]");
    //локатор для прокрутки в конструкторе "Начинки"
    public static By scrollFillingsMenuContainer = By.xpath(".//div[@style='display: flex;']/div[3]");
    //ссылка "Зарегистрироваться"
    public static By linkRegistration = By.xpath(".//a[text()='Зарегистрироваться']");

    @Step("Open main page Stellar Burgers")
    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogo));
    }

    //клик по кнопке «Войти в аккаунт» на главной
    @Step("Click on the button Login Account On Main Page and transfer to Personal Account Login Page")
    public void clickOnButtonLoginAccountOnMainPage() {
        driver.findElement(buttonLoginAccountOnMainPage).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(linkRegistration));
    }

    //клик по ссылке «Личный кабинет»
    @Step("Click on the link Text Personal Account and transfer to Personal Account Login Page")
    public void clickOnLinkTextPersonalAccount() {
        driver.findElement(linkTextPersonalAccount).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(linkTextPersonalAccount));
    }

    //прокрутка до меню "Булки"
    @Step("Click Tab Buns Burger Ingredients and Transfer to Buns Menu Container")
    public void transferToNameBunsMenuContainer() {
        driver.findElement(tabFillingsBurgerIngredients).click();
        driver.findElement(tabBunsBurgerIngredients).click();
    }

    //прокрутка до меню "Соусы"
    @Step("Click Tab Sauces Burger Ingredients and Transfer to Sauces Menu Container")
    public void transferToNameSaucesMenuContainer() {
        driver.findElement(tabSaucesBurgerIngredients).click();
    }

    //прокрутка до меню "Начинки"
    @Step("Click Tab Fillings Burger Ingredients and Transfer to Fillings Menu Container")
    public void transferToNameFillingsMenuContainer() {
        driver.findElement(tabFillingsBurgerIngredients).click();
    }

    //проверка видимости кнопки "Оформить заказ"
    @Step("Check Order button is displayed")
    public boolean checkTextCreateOrderButtonIsDisplayed() {
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    //клик по ссылке «Личный кабинет» авториз пользователь
    @Step("Click on the link Text Personal Account and transfer to Personal Account Login Page")
    public void clickOnLinkTextPersonalAccountAuthUser() {
        driver.findElement(linkTextPersonalAccount).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(AccountProfilePage.buttonLogOut));
    }
}
