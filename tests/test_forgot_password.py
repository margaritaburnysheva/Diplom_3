import allure

from pages.forgot_password_page import ForgotPasswordPage
from pages.login_page import LoginPage
from pages.reset_password_page import ResetPasswordPage


class TestForgotPassword:
    @allure.title('Проверка перехода на страницу восстановления пароля по ссылке "Восстановить пароль"')
    @allure.description('На странице авторизации кликнуть по ссылке "Восстановить пароль", проверить, что отобразится кнопка "Восстановить"')
    def test_switch_to_forgot_password_page(self, driver):
        login_page = LoginPage(driver)
        login_page.check_click_to_link_password_recovery(driver)
        forgot_password_page = ForgotPasswordPage(driver)
        button_text = forgot_password_page.get_text_from_button_recovery_forgot_password_form()
        assert button_text == "Восстановить", \
            'Ошибка при переходе на страницу восстановления пароля по ссылке "Восстановить пароль"'

    @allure.title('Проверка ввода почты и клика по кнопке "Восстановить"')
    @allure.description('На странице восстановления пароля ввести email, кликнуть по ссылке "Восстановить", проверить, что отобразится кнопка "Созранить" на странице /reset-password')
    def test_add_email_and_click_to_recovery_button(self, driver):
        forgot_password_page = ForgotPasswordPage(driver)
        forgot_password_page.check_add_email_and_click_to_recovery_button(driver)
        reset_password_page = ResetPasswordPage(driver)
        button_text = reset_password_page.get_text_from_button_recovery_forgot_password_form()
        assert button_text == "Сохранить", \
            'Ошибка при переходе на страницу сброса пароля по клику на кнопку "Восстановить"'

    @allure.title('Проверка активности поля "Пароль" по клику по кнопке показать/скрыть')
    @allure.description('На странице восстановления пароля ввести email, кликнуть по ссылке "Восстановить", проверить, что отобразится кнопка "Созранить" на странице /reset-password')
    def test_click_to_show_password_icon(self, driver):
        reset_password_page = ResetPasswordPage(driver)
        result = reset_password_page.click_to_show_password_icon(driver)
        assert 'input_status_active' in result, \
            'Поле "Пароль" не активно по клику по кнопке показать/скрыть'
