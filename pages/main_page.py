import allure
from seletools.actions import drag_and_drop

from constants import Constants
from locators.header_locators import HeaderLocators
from locators.main_page_locators import MainPageLocators

from locators.order_feed_list_page_locators import OrderFeedListPageLocators
from locators.personal_account_page_locators import PersonalAccountPageLocators
from pages.base_page import BasePage


class MainPage(BasePage):
    @allure.step('Кликнуть по ссылке "Лента заказов"')
    def check_click_to_order_feed_list(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(HeaderLocators.ORDER_FEED_LIST_LOCATOR)
        result_text = self.find_element_with_wait(OrderFeedListPageLocators.TITLE_ORDER_FEED_LIST_LOCATOR).text
        return result_text

    @allure.step('Кликнуть по изображению ингредиента')
    def check_click_to_ingredient(self, driver, ingredient):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(ingredient)
        result = self.get_element_attribute(MainPageLocators.INGREDIENT_DETAILS, 'class')
        return result

    @allure.step('Кликнуть по крестику в окне "Детали ингредиента"')
    def check_click_close_button_on_ingredient_details(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(MainPageLocators.FIRST_BUN_LOCATOR)
        self.click_to_element(MainPageLocators.INGREDIENT_DETAILS_CLOSE_BUTTON_LOCATOR)
        result = self.get_element_attribute(MainPageLocators.INGREDIENT_DETAILS, 'class')
        return result

    @allure.step('Добавить ингредиент в корзину и получить значение счетчика')
    def check_add_ingredient_and_counter_increases(self, driver, ingredient, cnt):
        self.open_page(driver, Constants.BASE_URL)
        burger_ingredient = self.find_element_with_wait(ingredient)
        basket = self.find_element_with_wait(MainPageLocators.BASKET_LOCATOR)
        drag_and_drop(driver, burger_ingredient, basket)
        result = self.get_text_from_element(cnt)
        return result

    @allure.step('Собрать корзину и оформить заказ')
    def check_create_order(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_BUN_LOCATOR)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_SAUCE_LOCATOR)
        self.add_ingredients_to_basket(driver, MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_FILLING_LOCATOR)
        self.click_to_element(MainPageLocators.ORDER_BUTTON_MAIN_PAGE)
        result = self.get_element_attribute(MainPageLocators.MODAL_WITH_ORDER_ID, 'class')
        return result

    @allure.step('Получить номер заказа')
    def get_order_number(self):
        self.switch_to_window(MainPageLocators.ORDER_ID, 0)
        result = self.get_text_from_element(MainPageLocators.ORDER_ID)
        return result

    @allure.step('Кликнуть по кнопке "Личный кабинет"')
    def check_click_on_personal_account_button(self, driver):
        self.open_page(driver, Constants.BASE_URL)
        self.click_to_element(HeaderLocators.PERSONAL_ACCOUNT)
        self.find_element_with_wait(PersonalAccountPageLocators.LOGOUT_BUTTON)
        result = self.get_text_from_element(PersonalAccountPageLocators.LOGOUT_BUTTON)
        return result
