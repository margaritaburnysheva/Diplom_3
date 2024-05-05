import allure

from constants import Constants
from locators.forgot_password_page_locators import ForgotPasswordPageLocators
from locators.header_locators import HeaderLocators
from locators.login_page_locators import LoginPageLocators
from locators.main_page_locators import MainPageLocators
from pages.base_page import BasePage


class LoginPage(BasePage):
    @allure.step('Кликнуть по сслыке "Восстановить пароль"')
    def check_click_to_link_password_recovery(self, driver):
        self.open_page(driver, Constants.LOGIN_PAGE_URL)
        self.find_element_with_wait(LoginPageLocators.LINK_PASSWORD_RECOVERY)
        self.click_to_element(LoginPageLocators.LINK_PASSWORD_RECOVERY)
        self.find_element_with_wait(ForgotPasswordPageLocators.BUTTON_RECOVERY_FORGOT_PASSWORD_FORM)

    @allure.step('Кликнуть по ссылке "Конструктор"')
    def check_click_to_constructor(self, driver):
        self.open_page(driver, Constants.LOGIN_PAGE_URL)
        self.click_to_element(HeaderLocators.CONSTRUCTOR_LOCATOR)
        result_text = self.find_element_with_wait(MainPageLocators.LOGIN_BUTTON_MAIN_PAGE).text
        return result_text
