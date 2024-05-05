import allure

from constants import Constants
from locators.header_locators import HeaderLocators
from locators.login_page_locators import LoginPageLocators
from locators.main_page_locators import MainPageLocators
from locators.personal_account_page_locators import PersonalAccountPageLocators
from pages.base_page import BasePage


class PersonalAccountPage(BasePage):
    @allure.step('Кликнуть по кнопке "История заказов"')
    def check_click_on_order_history_button(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(HeaderLocators.PERSONAL_ACCOUNT)
        self.click_to_element(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON)
        result = self.get_element_attribute(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON, 'aria-current')
        return result

    @allure.step('Кликнуть по кнопке "Выход"')
    def check_logout(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(HeaderLocators.PERSONAL_ACCOUNT)
        self.click_to_element(PersonalAccountPageLocators.LOGOUT_BUTTON)
        result = self.get_text_from_element(LoginPageLocators.LOGIN_BUTTON_LOGIN_PAGE)
        return result

    @allure.step('Найти заказ в истории заказов')
    def get_order_from_history(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_BUN_LOCATOR)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_SAUCE_LOCATOR)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_FILLING_LOCATOR)
        self.click_to_element(MainPageLocators.ORDER_BUTTON_MAIN_PAGE)
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(HeaderLocators.PERSONAL_ACCOUNT)
        self.click_to_element(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON)
        result_history = self.get_text_from_element(PersonalAccountPageLocators.ORDER_LOCATOR)
        return result_history
