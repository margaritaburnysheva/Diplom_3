import allure

from constants import Constants
from locators.main_page_locators import MainPageLocators
from pages.base_page import BasePage


class MainPage(BasePage):
    @allure.step('Получить текст кнопки "Войти в аккаунт"')
    def get_text_from_login_button_main_page(self):
        return self.get_text_from_element(MainPageLocators.LOGIN_BUTTON_MAIN_PAGE)

    @allure.step('Кликнуть по изображению ингредиента')
    def check_click_to_ingredient(self, ingredient):
        self.open_page(Constants.BASE_URL)
        self.click_to_element(ingredient)
        result = self.get_element_attribute(MainPageLocators.INGREDIENT_DETAILS, 'class')
        return result

    @allure.step('Кликнуть по крестику в окне "Детали ингредиента"')
    def check_click_close_button_on_ingredient_details(self):
        self.open_page(Constants.BASE_URL)
        self.click_to_element(MainPageLocators.FIRST_BUN_LOCATOR)
        self.click_to_element(MainPageLocators.INGREDIENT_DETAILS_CLOSE_BUTTON_LOCATOR)
        result = self.get_element_attribute(MainPageLocators.INGREDIENT_DETAILS, 'class')
        return result

    @allure.step('Добавить ингредиент в корзину и получить значение счетчика')
    def check_add_ingredient_and_counter_increases(self, ingredient, cnt):
        self.open_page(Constants.BASE_URL)
        self.add_ingredients_to_basket(MainPageLocators.BASKET_LOCATOR, ingredient)
        result = self.get_text_from_element(cnt)
        return result

    @allure.step('Собрать корзину и оформить заказ')
    def check_create_order(self):
        self.open_page(Constants.BASE_URL)
        self.add_ingredients_to_basket(MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_BUN_LOCATOR)
        self.add_ingredients_to_basket(MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_SAUCE_LOCATOR)
        self.add_ingredients_to_basket(MainPageLocators.BASKET_LOCATOR, MainPageLocators.FIRST_FILLING_LOCATOR)
        self.click_to_element(MainPageLocators.ORDER_BUTTON_MAIN_PAGE)
        result = self.get_element_attribute(MainPageLocators.MODAL_WITH_ORDER_ID, 'class')
        return result

    @allure.step('Получить номер заказа')
    def get_order_number(self):
        self.switch_to_window(MainPageLocators.ORDER_ID, 0)
        result = self.get_text_from_element(MainPageLocators.ORDER_ID)
        return result
