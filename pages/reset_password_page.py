import allure

from constants import Constants
from locators.forgot_password_page_locators import ForgotPasswordPageLocators
from locators.reset_password_page_locators import ResetPasswordPageLocators
from pages.base_page import BasePage


class ResetPasswordPage(BasePage):
    @allure.step('Получить текст кнопки "Сохранить"')
    def get_text_from_button_recovery_forgot_password_form(self):
        return self.get_text_from_element(ResetPasswordPageLocators.SAVE_BUTTON_RESET_PASSWORD_FORM_LOCATOR)

    @allure.step('Кликнуть по кнопке показать пароль')
    def click_to_show_password_icon(self, driver):
        self.open_page(driver, Constants.FORGOT_PASSWORD_PAGE_URL)
        self.add_text_to_element(ForgotPasswordPageLocators.EMAIL_FORGOT_PASSWORD_FORM, Constants.TEST_EMAIL)
        self.click_to_element(ForgotPasswordPageLocators.BUTTON_RECOVERY_FORGOT_PASSWORD_FORM)
        self.click_to_element(ResetPasswordPageLocators.SHOW_PASSWORD_ICON_LOCATOR)
        result_class = self.get_element_attribute(ResetPasswordPageLocators.EMAIL_RESET_PASSWORD_FORM_LOCATOR, 'class')
        return result_class
