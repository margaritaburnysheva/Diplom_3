package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private static final String MAIN_PAGE_URL="https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //кнопка "Войти в аккаунт" на главной
    public static By buttonLoginAccountOnMainPage=By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Личный кабинет"
    public static By linkTextPersonalAccount=By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    //лого Stellar Burgers
    public static By headerLogo=By.className("AppHeader_header__logo__2D0X2");
    //"Булки"
    public static By tabBunsBurgerIngredients=By.xpath(".//span[text()='Булки']/..");
    //"Соусы"
    public static By tabSaucesBurgerIngredients=By.xpath(".//span[text()='Соусы']/..");
    //"Начинки"
    public static By tabFillingsBurgerIngredients=By.xpath(".//span[text()='Начинки']/..");
    //кнопка "Оформить заказ"
    public static By buttonCreateOrder=By.xpath(".//button[text()='Оформить заказ']");
    //локатор для прокрутки в конструкторе "Булки"
    public static By nameBunsMenuContainer=By.xpath(".//section[1]/div[2]/h2[1]");
    //локатор для прокрутки в конструкторе "Соусы"
    public static By nameSaucesMenuContainer=By.xpath(".//section[1]/div[2]/h2[2]");
    //локатор для прокрутки в конструкторе "Начинки"
    public static By nameFillingsMenuContainer=By.xpath(".//section[1]/div[2]/h2[3]");
    //ссылка "Зарегистрироваться"
    public static By linkRegistration=By.xpath(".//a[text()='Зарегистрироваться']");

    @Step("Open main page Stellar Burgers")
    public void openMainPage(){
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogo));
    };
    //клик по кнопке «Войти в аккаунт» на главной
    @Step("Click on the button Login Account On Main Page and transfer to Personal Account Login Page")
    public void clickOnButtonLoginAccountOnMainPage(){
        driver.findElement(buttonLoginAccountOnMainPage).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(linkRegistration));
    }
    //клик по ссылке «Личный кабинет»
    @Step("Click on the link Text Personal Account and transfer to Personal Account Login Page")
    public void clickOnLinkTextPersonalAccount(){
        driver.findElement(linkTextPersonalAccount).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(linkTextPersonalAccount));
    }
    //прокрутка до меню "Булки"
   @Step("Click Tab Buns Burger Ingredients and Transfer to Buns Menu Container")
   public boolean transferToNameBunsMenuContainer(){
       driver.findElement(tabFillingsBurgerIngredients).click();
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.visibilityOfElementLocated(nameFillingsMenuContainer));
       driver.findElement(tabBunsBurgerIngredients).click();
       WebElement element = driver.findElement(nameBunsMenuContainer);
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.visibilityOfElementLocated(nameBunsMenuContainer));
       return driver.findElement(nameBunsMenuContainer).isDisplayed();
   }
    //прокрутка до меню "Соусы"
    @Step("Click Tab Sauces Burger Ingredients and Transfer to Sauces Menu Container")
    public boolean transferToNameSaucesMenuContainer(){
        driver.findElement(tabSaucesBurgerIngredients).click();
        WebElement element = driver.findElement(nameSaucesMenuContainer);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameSaucesMenuContainer));
        return driver.findElement(nameSaucesMenuContainer).isDisplayed();
    }
    //прокрутка до меню "Начинки"
    @Step("Click Tab Fillings Burger Ingredients and Transfer to Fillings Menu Container")
    public boolean transferToNameFillingsMenuContainer(){
        driver.findElement(tabFillingsBurgerIngredients).click();
        WebElement element = driver.findElement(nameFillingsMenuContainer);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameFillingsMenuContainer));
        return driver.findElement(nameFillingsMenuContainer).isDisplayed();
    }
    //проверка видимости кнопки "Оформить заказ"
    @Step("Check Order button is displayed")
    public boolean checkTextCreateOrderButtonIsDisplayed(){
        WebElement element=new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }
    //клик по ссылке «Личный кабинет» авториз пользователь
    @Step("Click on the link Text Personal Account and transfer to Personal Account Login Page")
    public void clickOnLinkTextPersonalAccountAuthUser(){
        driver.findElement(linkTextPersonalAccount).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(AccountProfilePage.buttonLogOut));
    }
}
