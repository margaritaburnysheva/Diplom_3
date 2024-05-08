import allure

from constants import Constants
from locators.order_feed_list_page_locators import OrderFeedListPageLocators
from pages.base_page import BasePage


class OrderFeedListPage(BasePage):
    @allure.step('Получить текст заголовка "Лента заказов"')
    def get_text_from_title_order_feed_list(self):
        return self.get_text_from_element(OrderFeedListPageLocators.TITLE_ORDER_FEED_LIST_LOCATOR)

    @allure.step('Кликнуть по заказу и открыть детали')
    def check_click_to_order_and_view_details(self):
        self.open_page(Constants.ORDER_FEED_LIST_URL)
        self.click_to_element(OrderFeedListPageLocators.FIRST_ORDER_LOCATOR)
        result = self.get_element_attribute(OrderFeedListPageLocators.FIRST_ORDER_DETAILS_LOCATOR, 'class')
        return result

    @allure.step('Получить номера заказов из ленты')
    def get_orders_numbers_from_feed_list(self):
        self.open_page(Constants.ORDER_FEED_LIST_URL)
        result_list = self.get_text_from_element(OrderFeedListPageLocators.FIRST_ORDER_LOCATOR)
        return result_list

    @allure.step('Получить заказы "В работе"')
    def get_order_list_processing(self):
        self.driver.execute_script("window.open('https://stellarburgers.nomoreparties.site/feed')")
        self.switch_to_window(OrderFeedListPageLocators.ORDERS_IN_PROCESSING_LOCATOR, 1)
        result = self.get_text_from_element(OrderFeedListPageLocators.ORDERS_IN_PROCESSING_LOCATOR)
        return result

    @allure.step('Получить количество "Выполнено за все время"')
    def check_total_order_counter(self):
        self.open_page(Constants.ORDER_FEED_LIST_URL)
        result = self.get_text_from_element(OrderFeedListPageLocators.TOTAL_ORDER_COUNTER)
        return result

    @allure.step('Получить количество "Выполнено за сегодня"')
    def check_today_order_counter(self):
        self.open_page(Constants.ORDER_FEED_LIST_URL)
        result = self.get_text_from_element(OrderFeedListPageLocators.TODAY_ORDER_COUNTER)
        return result
