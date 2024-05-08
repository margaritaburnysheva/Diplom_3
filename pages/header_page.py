import allure

from constants import Constants
from locators.header_locators import HeaderLocators
from pages.base_page import BasePage


class HeaderPage(BasePage):
    @allure.step('Кликнуть по ссылке "Лента заказов"')
    def check_click_to_order_feed_list(self):
        self.open_page(Constants.BASE_URL)
        self.click_to_element(HeaderLocators.ORDER_FEED_LIST_LOCATOR)

    @allure.step('Кликнуть по кнопке "Личный кабинет"')
    def check_click_on_personal_account_button(self):
        self.open_page(Constants.BASE_URL)
        self.click_to_element(HeaderLocators.PERSONAL_ACCOUNT)

    @allure.step('Кликнуть по ссылке "Конструктор"')
    def check_click_to_constructor(self):
        self.open_page(Constants.LOGIN_PAGE_URL)
        self.click_to_element(HeaderLocators.CONSTRUCTOR_LOCATOR)
