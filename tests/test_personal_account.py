import allure

from pages.header_page import HeaderPage
from pages.login_page import LoginPage
from pages.personal_account_page import PersonalAccountPage


class TestPersonalAccount:
    @allure.title('Проверка перехода по клику на "Личный кабинет"')
    @allure.description('Кликнуть на "Личный кабинет", проверить, что открылась страница с данными пользователя и кнопкой "Выход"')
    def test_click_on_personal_account_button(self, driver, login_user):
        header_page = HeaderPage(driver)
        header_page.check_click_on_personal_account_button()
        personal_account_page = PersonalAccountPage(driver)
        result = personal_account_page.get_text_from_logout_button()
        assert result == 'Выход', \
            'Не открылся профиль пользователя с кнопкой "Выход"'

    @allure.title('Проверка перехода по клику по ссылке "История заказов"')
    @allure.description('Кликнуть по ссылке "История заказов", проверить, что открылась страница с заказами пользователя')
    def test_click_on_order_history_button(self, driver, login_user):
        header_page = HeaderPage(driver)
        header_page.check_click_on_personal_account_button()
        personal_account_page = PersonalAccountPage(driver)
        result = personal_account_page.check_click_on_order_history_button()
        assert result == "page", \
            'Не отображается история заказов пользователя'

    @allure.title('Проверка перехода по клику на "Выход"')
    @allure.description('Кликнуть на "Выход", проверить, что открылась страница с кнопкой "Войти"')
    def test_logout(self, driver, login_user):
        header_page = HeaderPage(driver)
        header_page.check_click_on_personal_account_button()
        personal_account_page = PersonalAccountPage(driver)
        personal_account_page.check_logout()
        login_page = LoginPage(driver)
        result = login_page.get_text_from_login_button_login_page()
        assert result == "Войти", \
            'Пользователь не разлогинился'
