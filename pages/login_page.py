import allure

from constants import Constants
from locators.login_page_locators import LoginPageLocators
from pages.base_page import BasePage


class LoginPage(BasePage):
    @allure.step('Получить текст кнопки "Войти"')
    def get_text_from_login_button_login_page(self):
        return self.get_text_from_element(LoginPageLocators.LOGIN_BUTTON_LOGIN_PAGE)

    @allure.step('Кликнуть по сслыке "Восстановить пароль"')
    def check_click_to_link_password_recovery(self):
        self.open_page(Constants.LOGIN_PAGE_URL)
        self.find_element_with_wait(LoginPageLocators.LINK_PASSWORD_RECOVERY)
        self.click_to_element(LoginPageLocators.LINK_PASSWORD_RECOVERY)

    @allure.step('Логин пользователя"')
    def user_login(self, user_data):
        self.open_page(Constants.LOGIN_PAGE_URL)
        self.add_text_to_element(LoginPageLocators.EMAIL_INPUT_FORM_LOGIN, user_data["email"])
        self.add_text_to_element(LoginPageLocators.PASSWORD_INPUT_FORM_LOGIN, user_data["password"])
        self.click_to_element(LoginPageLocators.LOGIN_BUTTON_LOGIN_PAGE)
        self.wait_element_is_not_located(LoginPageLocators.LOGIN_BUTTON_LOGIN_PAGE)
