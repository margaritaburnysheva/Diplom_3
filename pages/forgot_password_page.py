import allure

from constants import Constants
from locators.forgot_password_page_locators import ForgotPasswordPageLocators
from pages.base_page import BasePage


class ForgotPasswordPage(BasePage):
    @allure.step('Получить текст кнопки "Восстановить"')
    def get_text_from_button_recovery_forgot_password_form(self):
        return self.get_text_from_element(ForgotPasswordPageLocators.BUTTON_RECOVERY_FORGOT_PASSWORD_FORM)

    @allure.step('Ввести email на странице восстановления пароля и кликнуть по кнопке "Восстановить"')
    def check_add_email_and_click_to_recovery_button(self):
        self.open_page(Constants.FORGOT_PASSWORD_PAGE_URL)
        self.add_text_to_element(ForgotPasswordPageLocators.EMAIL_FORGOT_PASSWORD_FORM, Constants.TEST_EMAIL)
        self.click_to_element(ForgotPasswordPageLocators.BUTTON_RECOVERY_FORGOT_PASSWORD_FORM)

    @allure.step('Ввести email и кликнуть по кнопке "Восстановить" на странице восстановления пароля')
    def input_email_and_click_button_recovery(self):
        self.open_page(Constants.FORGOT_PASSWORD_PAGE_URL)
        self.add_text_to_element(ForgotPasswordPageLocators.EMAIL_FORGOT_PASSWORD_FORM, Constants.TEST_EMAIL)
        self.click_to_element(ForgotPasswordPageLocators.BUTTON_RECOVERY_FORGOT_PASSWORD_FORM)
