import allure

from locators.reset_password_page_locators import ResetPasswordPageLocators
from pages.base_page import BasePage


class ResetPasswordPage(BasePage):
    @allure.step('Получить текст кнопки "Сохранить"')
    def get_text_from_button_recovery_forgot_password_form(self):
        return self.get_text_from_element(ResetPasswordPageLocators.SAVE_BUTTON_RESET_PASSWORD_FORM_LOCATOR)

    @allure.step('Кликнуть по кнопке показать пароль')
    def click_to_show_password_icon(self):
        self.click_to_element(ResetPasswordPageLocators.SHOW_PASSWORD_ICON_LOCATOR)
        result_class = self.get_element_attribute(ResetPasswordPageLocators.EMAIL_RESET_PASSWORD_FORM_LOCATOR, 'class')
        return result_class
