import allure

from locators.personal_account_page_locators import PersonalAccountPageLocators
from pages.base_page import BasePage


class PersonalAccountPage(BasePage):
    @allure.step('Получить текст кнопки "Выход"')
    def get_text_from_logout_button(self):
        return self.get_text_from_element(PersonalAccountPageLocators.LOGOUT_BUTTON)

    @allure.step('Кликнуть по кнопке "История заказов"')
    def check_click_on_order_history_button(self):
        self.click_to_element(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON)
        result = self.get_element_attribute(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON, 'aria-current')
        return result

    @allure.step('Кликнуть по кнопке "Выход"')
    def check_logout(self):
        self.click_to_element(PersonalAccountPageLocators.LOGOUT_BUTTON)

    @allure.step('Найти заказ в истории заказов')
    def get_order_from_history(self):
        self.click_to_element(PersonalAccountPageLocators.ORDER_HISTORY_BUTTON)
        result_history = self.get_text_from_element(PersonalAccountPageLocators.ORDER_LOCATOR)
        return result_history
